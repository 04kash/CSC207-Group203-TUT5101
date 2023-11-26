package use_case.CreateLabel;
import entity.*;
public class CreateLabelInteractor {
    final CreateLabelDataAccessInterface labelDataAccessObject;
    final CreateLabelOutputBoundary labelPresenter;
    final UserFactory userFactory;

    public CreateLabelInteractor(CreateLabelDataAccessInterface labelDataAccessObject,
                                 CreateLabelOutputBoundary labelPresenter, UserFactory userFactory){
        this.labelDataAccessObject = labelDataAccessObject;
        this.labelPresenter = labelPresenter;
        this.userFactory = userFactory;
    }
    public void execute(CreateLabelInputData createLabelInputData){
        Label label = new Label(createLabelInputData.getChosenLabel());
        //User currentUser = labelDataAccessObject.get(createLabelInputData.getUsername());
        if(labelDataAccessObject.labelExists(createLabelInputData.getUsername(),label)){
            labelPresenter.prepareFailView("Label Name already exists");
        }
        else {labelDataAccessObject.addLabelToPlanner(createLabelInputData.getUsername(),label);
            if(labelDataAccessObject.labelExists(createLabelInputData.getUsername(),label)){
                labelPresenter.prepareSuccessView("Label added Successfully");
            }else{
                labelPresenter.prepareFailView("Label was not added Successfully. Please try again.");
            }
    }
}}

