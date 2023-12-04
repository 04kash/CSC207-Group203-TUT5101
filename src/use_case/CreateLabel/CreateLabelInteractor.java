package use_case.CreateLabel;

import entity.*;

/**
 * This class represents the interactor for handling the creation of new labels use case
 * It implements the interface, defining the logic for processing creating labels input data.
 */
public class CreateLabelInteractor implements CreateLabelInputBoundary{
    final CreateLabelDataAccessInterface labelDataAccessObject;
    final CreateLabelOutputBoundary labelPresentor;

    /**
     * Constructs a new instance of the create label interactor with specified data access object and output boundary
     *
     * @param labelDataAccessObject the data access object for the create labels use case data operations
     * @param labelPresentor the output boundary for presenting create labels use case related output data
     */
    public CreateLabelInteractor(CreateLabelDataAccessInterface labelDataAccessObject,
                                 CreateLabelOutputBoundary labelPresentor){
        this.labelDataAccessObject = labelDataAccessObject;
        this.labelPresentor = labelPresentor;
    }

    /**
     * Executes the create label use case based on the provided input data
     *
     * @param createLabelInputData The input data for the use case operation
     */
    @Override
    public void execute(CreateLabelInputData createLabelInputData) {
        Label label = new Label(createLabelInputData.getChosenLabel());
        String currentUser = labelDataAccessObject.getCurrentUser();
        if(labelDataAccessObject.labelExists(currentUser,label)){
            labelPresentor.prepareFailView("Label Name already exists");
        }
        else {labelDataAccessObject.addLabelToPlanner(currentUser,label);
            if(labelDataAccessObject.labelExists(currentUser, label)){
                labelPresentor.prepareSuccessView("Label saved successfully");
            }
        }
    }
}
