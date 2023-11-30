package interface_adapter.displayingLabels;

import use_case.displayingLabels.DisplayingLabelsInputBoundary;
import use_case.displayingLabels.DisplayingLabelsInputData;

public class DisplayingLabelsController {
    final DisplayingLabelsInputBoundary displayingLabelsInputBoundary;

    public DisplayingLabelsController(DisplayingLabelsInputBoundary displayingLabelsInputBoundary) {
        this.displayingLabelsInputBoundary = displayingLabelsInputBoundary;
    }

    public void execute() {
        DisplayingLabelsInputData displayingLabelsInputData = new DisplayingLabelsInputData();
        displayingLabelsInputBoundary.execute(displayingLabelsInputData);
    }
}
