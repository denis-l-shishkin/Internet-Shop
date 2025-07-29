package org.skypro.skyshop.seach;

import org.skypro.skyshop.exception.BestResultNotFound;

public class SearchEngine {
    private Searchable[] searchables;
    private int size;
    public SearchEngine(int capacity) {
        this.searchables = new Searchable[capacity];
        this.size = 0;
    }
    public Searchable[] search(String query) {
        Searchable[] result = new Searchable[5];
        int count = 0;
        for (Searchable searchable : searchables) {
            if (searchable.getSearchTerm().contains(query)) {
                result[count++] = searchable;

            }
            if (count == 5) {
                break;
            }
        }
        return result;
    }
    public Searchable searchTheBest(String query) {
        int maxCount = 0;
        Searchable bestResult = null;
        for (Searchable searchable : searchables) {
            int index = 0;
            int count = 0;
            int indexSubStr = searchable.getSearchTerm().indexOf(query, index);
            while (indexSubStr != -1) {
                count++;
                index = indexSubStr + query.length();
                indexSubStr = searchable.getSearchTerm().indexOf(query, index);
            }
            if (count > maxCount) {
                maxCount = count;
                bestResult = searchable;
            }
        }
        if (bestResult == null) {
            throw new BestResultNotFound(query);
        } else {
            return bestResult;
        }
    }

    public void add(Searchable searchable) {
        if (size < searchables.length) {
            searchables[size++] = searchable;
        }
    }
}
