package use_case.CreateLabel;
import entity.*;
public class CreateLabelInteractor {
    final CreateLabelDataAccessInterface labelDataAccessObject;
    final CreateLabelOutputBoundary labelPresentor;
    final UserFactory userFactory;

    public CreateLabelInteractor(CreateLabelDataAccessInterface labelDataAccessObject,
                                 CreateLabelOutputBoundary labelPresentor, UserFactory userFactory){
        this.labelDataAccessObject = labelDataAccessObject;
        this.labelPresentor = labelPresentor;
        this.userFactory = userFactory;
    }
    public void execute(CreateLabelInputData createLabelInputData){
        Label label = new Label(createLabelInputData.getChosenLabel());
        //User currentUser = labelDataAccessObject.get(createLabelInputData.getUsername());
        if(labelDataAccessObject.labelExists(createLabelInputData.getUsername(),label)){
            labelPresentor.prepareFailView("Label Name already exists");
        }
        else {labelDataAccessObject.addLabelToPlanner(createLabelInputData.getUsername(),label);
            if(labelDataAccessObject.labelExists(createLabelInputData.getUsername(), label)){
                labelPresentor.prepareSuccessView("Location saved successfully");
            }else{
                labelPresentor.prepareFailView("Location was not saved.Please try again.");
            }
    }
}}
