package use_case.SavingLocation;


public interface SavingLocationOutputBoundary {
    void prepareSuccessView(String success);

    void prepareFailView(String error);
}
