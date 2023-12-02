package use_case.LocationsFromLabel;

public interface LocationsFromLabelOutputBoundary {
    void prepareSuccessView(LocationsFromLabelOutputData locations);

    void prepareFailView(String error);
}
