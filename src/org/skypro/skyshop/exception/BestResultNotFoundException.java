package org.skypro.skyshop.exception;

public class BestResultNotFoundException extends RuntimeException {
    private String query;

    public BestResultNotFoundException(String query) {
        this.query = query;
    }

    @Override
    public String toString() {
        return "BestResultNotFound{ Для поискового запроса: \"" + query + "\" подходящих результатов не найдено.}";
    }
}
