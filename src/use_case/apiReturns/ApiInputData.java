package use_case.apiReturns;

public class ApiInputData {
    final private String location;
    final private String filter;

    public ApiInputData(String location, String filter) {
        this.location = location;
        this.filter = filter;
    }

    String getLocation() {
        return location;
    }

    String getFilter() {
        return filter;
    }
}
