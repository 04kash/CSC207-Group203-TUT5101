package use_case.displayingLocations;

public interface DisplayingLocationsOutputBoundary {
    void prepareSuccessView(DisplayingLocationsOutputData displayingLocationsOutputData);
    void prepareFailView(String error);
}
