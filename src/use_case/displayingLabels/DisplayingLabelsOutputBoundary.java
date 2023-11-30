package use_case.displayingLabels;

public interface DisplayingLabelsOutputBoundary {
    void prepareSuccessView(DisplayingLabelsOutputData displayingLabelsOutputData);
    void prepareFailView(String error);
}
