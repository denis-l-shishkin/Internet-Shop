package org.skypro.skyshop.exception;

public class BestResultNotFound extends RuntimeException {
    private String query;

    public BestResultNotFound(String query) {
        this.query = query;
    }

    @Override
    public String toString() {
        return "BestResultNotFound{ Для поискового запроса: \"" + query + "\" подходящих результатов не найдено.}";
    }
}
