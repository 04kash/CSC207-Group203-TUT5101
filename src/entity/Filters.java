package entity;

public class Filters {
    private final String[] filters;
    private final String[] preferences;

    Filters(String[] filters, String[] preferences) {
        this.filters = filters;
        this.preferences = preferences;
    }

    public String[] getFilters() {
        return filters;
    }

    public String[] getPreferences() {
        return preferences;
    }
}
