package src.interface_adapter.CreateLabel;

import src.use_case.CreateLabel.CreateLabelInputBoundary;
import src.use_case.CreateLabel.CreateLabelInputBoundary;
import src.use_case.CreateLabel.CreateLabelInputData;


public class CreateLabelController {

    final CreateLabelInputBoundary createLabelInteractor;
    public CreateLabelController(CreateLabelInputBoundary createLabelInteractor){
        this.createLabelInteractor = createLabelInteractor;
    }

    public void execute(String username, String password, String label){
        CreateLabelInputData createLabelInputData = new CreateLabelInputData(username, password, label);
        createLabelInteractor.excecute(createLabelInputData);
    }
}
