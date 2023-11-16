package use_case.api_returns;

public interface ApiOutputBoundary {

    void prepareSuccessView(ApiOutputData user);

    void prepareFailView(String error);
}
