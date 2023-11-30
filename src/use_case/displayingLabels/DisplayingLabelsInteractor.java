package use_case.displayingLabels;

import entity.Label;
import entity.User;

import java.util.Set;

public class DisplayingLabelsInteractor implements DisplayingLabelsInputBoundary{
    final DisplayingLabelsUserDataAccessInterface userDataAccessInterface;
    final DisplayingLabelsOutputBoundary displayingLabelsPresenter;

    public DisplayingLabelsInteractor(DisplayingLabelsUserDataAccessInterface userDataAccessInterface, DisplayingLabelsOutputBoundary displayingLabelsOutputBoundary) {
        this.displayingLabelsPresenter = displayingLabelsOutputBoundary;
        this.userDataAccessInterface = userDataAccessInterface;
    }

    @Override
    public void execute(DisplayingLabelsInputData displayingLabelsInputData) {
        if (userDataAccessInterface.get(userDataAccessInterface.getCurrentUser()) != null) {
            User user = userDataAccessInterface.get(userDataAccessInterface.getCurrentUser());
            Set<Label> labels = user.getPlanner().getLabel();

            DisplayingLabelsOutputData displayingLabelsOutputData = new DisplayingLabelsOutputData(labels, false);
            displayingLabelsPresenter.prepareSuccessView(displayingLabelsOutputData);
        }
    }
}
