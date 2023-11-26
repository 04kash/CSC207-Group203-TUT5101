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
        User currentUser = labelDataAccessObject.getUser(createLabelInputData.getUsername());
        if(labelDataAccessObject.labelExists(label)){
            labelPresentor.prepareFailView("Label Name already exists");
        }
        else {labelDataAccessObject.addLabelToPlanner(currentUser,label);
            if(labelDataAccessObject.labelExists(label)){
                labelPresentor.prepareSuccessView("Label added Successfully");
            }else{
                labelPresentor.prepareFailView("Label was not added Successfully. Please try again.");
            }
    }
}}

