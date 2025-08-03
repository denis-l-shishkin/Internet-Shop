package org.skypro.skyshop.seach;

import org.skypro.skyshop.exception.BestResultNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private List<Searchable> searchables;
    private int size;

    public SearchEngine() {
        this.searchables = new ArrayList<>();
        this.size = 0;
    }

    public List<Searchable> search(String query) {
        List<Searchable> result = new ArrayList<>();
        for (Searchable searchable : searchables) {
            if (searchable.getSearchTerm().contains(query)) {
                result.add(searchable);

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
            throw new BestResultNotFoundException(query);
        }
        return bestResult;
    }

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }
}
