package entity;

public class Filters {
    private final String[] filters;

    Filters(String[] filters, String[] preferences) {
        this.filters = filters;
    }

    public String[] getFilters() {
        return filters;
    }
}
