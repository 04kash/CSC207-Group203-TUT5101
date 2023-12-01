package use_case.CreateLabel;
import entity.*;
public class CreateLabelInteractor implements CreateLabelInputBoundary{
    final CreateLabelDataAccessInterface labelDataAccessObject;
    final CreateLabelOutputBoundary labelPresentor;
    //final UserFactory userFactory;

    public CreateLabelInteractor(CreateLabelDataAccessInterface labelDataAccessObject,
                                 CreateLabelOutputBoundary labelPresentor){
        this.labelDataAccessObject = labelDataAccessObject;
        this.labelPresentor = labelPresentor;
        //this.userFactory = userFactory;
    }

    @Override
    public void excecute(CreateLabelInputData createLabelInputData) {
        Label label = new Label(createLabelInputData.getChosenLabel());
        String currentUser = labelDataAccessObject.getCurrentUser();
        if(labelDataAccessObject.labelExists(currentUser,label)){
            labelPresentor.prepareFailView("Label Name already exists");
        }
        else {labelDataAccessObject.addLabelToPlanner(currentUser,label);
            if(labelDataAccessObject.labelExists(currentUser, label)){
                labelPresentor.prepareSuccessView("Label saved successfully");
            }else{
                labelPresentor.prepareFailView("Label was not saved.Please try again.");
            }
        }
    }
}
