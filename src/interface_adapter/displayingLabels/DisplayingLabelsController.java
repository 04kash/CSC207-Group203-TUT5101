package interface_adapter.displayingLabels;

import use_case.displayingLabels.DisplayingLabelsInputBoundary;
import use_case.displayingLabels.DisplayingLabelsInputData;

/**
 * Controller class responsible for executing the display labels use case.
 * This class acts as an interface adapter between the external system and the use case.
 */
public class DisplayingLabelsController {

    /**
     * The input boundary for the display labels use case.
     */
    final DisplayingLabelsInputBoundary displayingLabelsInputBoundary;

    /**
     * Constructs a new DisplayingLabelsController with the specified DisplayingLabelsInputBoundary.
     *
     * @param displayingLabelsInputBoundary the input boundary for the display labels use case
     */
    public DisplayingLabelsController(DisplayingLabelsInputBoundary displayingLabelsInputBoundary) {
        this.displayingLabelsInputBoundary = displayingLabelsInputBoundary;
    }

    /**
     * Executes the display labels use case.
     */
    public void execute() {
        DisplayingLabelsInputData displayingLabelsInputData = new DisplayingLabelsInputData();
        displayingLabelsInputBoundary.execute(displayingLabelsInputData);
    }
}
