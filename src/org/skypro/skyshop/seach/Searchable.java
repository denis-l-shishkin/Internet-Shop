package org.skypro.skyshop.seach;

public interface Searchable {
    String getSearchTerm();
    String getTypeContent();
    String getNameObject();
    default String getStringRepresentation(){
        return getNameObject() + " - " + getTypeContent();
    }
}
