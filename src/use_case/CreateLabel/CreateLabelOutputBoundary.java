package src.use_case.CreateLabel;

public interface CreateLabelOutputBoundary {
    void prepareFailView(String error);
    void prepareSuccessView(String success);
}
