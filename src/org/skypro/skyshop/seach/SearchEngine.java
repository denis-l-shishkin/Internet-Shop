package org.skypro.skyshop.seach;

import org.skypro.skyshop.exception.BestResultNotFoundException;
import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {
    private Set<Searchable> searchables;
    private int size;

    public SearchEngine() {
        this.searchables = new HashSet<>();
        this.size = 0;
    }

    public Set<Searchable> search(String query) {
        Set<Searchable> result = searchables.stream()
                .filter(searchable -> searchable.getSearchTerm().contains(query))
                .collect(Collectors.toCollection(() -> new TreeSet<>(((o1, o2) -> {
                    int lengthO1 = o1.getNameObject().length();
                    int lengthO2 = o2.getNameObject().length();
                    if (lengthO1 != lengthO2) {
                        return Integer.compare(lengthO1, lengthO2);
                    }
                    return o1.getNameObject().compareTo(o2.getNameObject());
                }))));
        /*for (Searchable searchable : searchables) {
            if (searchable.getSearchTerm().contains(query)) {
                result.add(searchable);
            }
        }*/
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
