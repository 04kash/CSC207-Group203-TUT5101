package interface_adapter.CreateLabel;

import use_case.CreateLabel.CreateLabelInputBoundary;
import use_case.CreateLabel.CreateLabelInputData;

/**
 * Controller class responsible for handling the creation of a label through the specified input boundary.
 * This class acts as an interface adapter between the external system and the use case.
 */
public class CreateLabelController {

    /**
     * The input boundary for the create label use case.
     */
    final CreateLabelInputBoundary createLabelInteractor;

    /**
     * Constructs a new CreateLabelController with the specified CreateLabelInputBoundary.
     *
     * @param createLabelInteractor the input boundary for the create label use case
     */
    public CreateLabelController(CreateLabelInputBoundary createLabelInteractor){
        this.createLabelInteractor = createLabelInteractor;
    }

    /**
     * Executes the creation of a label using the provided label string.
     *
     * @param label the string representing the label to be created
     */
    public void execute(String label){
        CreateLabelInputData createLabelInputData = new CreateLabelInputData(label);
        createLabelInteractor.execute(createLabelInputData);
    }
}
