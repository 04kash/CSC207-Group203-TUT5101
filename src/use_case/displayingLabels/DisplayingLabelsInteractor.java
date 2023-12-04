package use_case.displayingLabels;

import entity.Label;
import entity.User;

import java.util.Set;

/**
 * This class represents the interactor for handling the displaying of labels use case
 * It implements the interface, defining the logic for processing display labels input data.
 */
public class DisplayingLabelsInteractor implements DisplayingLabelsInputBoundary{
    final DisplayingLabelsUserDataAccessInterface userDataAccessInterface;
    final DisplayingLabelsOutputBoundary displayingLabelsPresenter;

    /**
     * Constructs a new instance of the display label interactor with specified data access object and output boundary
     *
     * @param userDataAccessInterface the data access object for the display labels use case data operations
     * @param displayingLabelsOutputBoundary the output boundary for presenting display labels use case related output data
     */
    public DisplayingLabelsInteractor(DisplayingLabelsUserDataAccessInterface userDataAccessInterface, DisplayingLabelsOutputBoundary displayingLabelsOutputBoundary) {
        this.displayingLabelsPresenter = displayingLabelsOutputBoundary;
        this.userDataAccessInterface = userDataAccessInterface;
    }

    /**
     * Executes the display label use case based on the provided input data
     *
     * @param displayingLabelsInputData the input data for the use case operation
     */
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
