package interface_adapter.CreateLabel;

import use_case.CreateLabel.CreateLabelInputBoundary;
import use_case.CreateLabel.CreateLabelInputBoundary;
import use_case.CreateLabel.CreateLabelInputData;


public class CreateLabelController {

    final CreateLabelInputBoundary createLabelInteractor;
    public CreateLabelController(CreateLabelInputBoundary createLabelInteractor){
        this.createLabelInteractor = createLabelInteractor;
    }

    public void execute(String label){
        CreateLabelInputData createLabelInputData = new CreateLabelInputData(label);
        createLabelInteractor.excecute(createLabelInputData);
    }
}
