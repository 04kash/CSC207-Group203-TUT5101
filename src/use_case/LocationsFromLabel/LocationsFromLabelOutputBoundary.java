package use_case.LocationsFromLabel;

import use_case.api_returns.ApiOutputData;

public interface LocationsFromLabelOutputBoundary {
    void prepareSuccessView(LocationsFromLabelOutputData locations);

    void prepareFailView(String error);
}
