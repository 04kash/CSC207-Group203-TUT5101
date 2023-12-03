package use_case.apiReturns;

public interface ApiOutputBoundary {

    void prepareSuccessView(ApiOutputData user);

    void prepareFailView(String error);
}
