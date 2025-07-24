package org.skypro.skyshop.seach;

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
                System.out.println(searchable.getStringRepresentation());
            }
            if (count == 5) {
                break;
            }
        }
        return result;
    }

    public void add(Searchable searchable) {
        if (size < searchables.length) {
            searchables[size] = searchable;
            size++;
        }
    }

}
