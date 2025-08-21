package org.skypro.skyshop.article;

import org.skypro.skyshop.seach.Searchable;

import java.util.Objects;

public final class Article implements Searchable {
    private final String title;
    private final String text;

    public Article(String title, String text) {
        this.title = title;
        this.text = text;
    }
    public String getTitle() {
        return title;
    }
    public String getText() {
        return text;
    }
    @Override
    public String toString() {
        return title + "\n" + text;
    }
    @Override
    public String getSearchTerm() {
        return title + " " + text;
    }

    @Override
    public String getTypeContent() {
        return "ARTICLE";
    }

    @Override
    public String getNameObject() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(title, article.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
