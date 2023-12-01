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
        String currentUser = labelDataAccessObject.getCurrentUser();
        if(labelDataAccessObject.labelExists(currentUser,label)){
            labelPresentor.prepareFailView("Label Name already exists");
        }
        else {labelDataAccessObject.addLabelToPlanner(currentUser,label);
            if(labelDataAccessObject.labelExists(currentUser, label)){
                labelPresentor.prepareSuccessView("Location saved successfully");
            }else{
                labelPresentor.prepareFailView("Location was not saved.Please try again.");
            }
    }
}}
