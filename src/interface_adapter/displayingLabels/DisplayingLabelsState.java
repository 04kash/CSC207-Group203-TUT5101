package interface_adapter.displayingLabels;

import entity.Label;

import java.util.HashSet;
import java.util.Set;

public class DisplayingLabelsState {
    private static Set<Label> labels = new HashSet<>();
    private String labelError = "";
    public DisplayingLabelsState() {}
    public DisplayingLabelsState(DisplayingLabelsState copy) {
        labels = copy.labels;
        labelError = copy.labelError;;
    }

    public static Set<Label> getLabels() {
        return labels;
    }

    public static void setLabels(Set<Label> labels) {
        DisplayingLabelsState.labels = labels;
    }

    public void setLabelError(String labelError) {
        this.labelError = labelError;
    }
}
