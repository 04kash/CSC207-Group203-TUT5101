package interface_adapter.displayingLabels;

import entity.Label;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents the state associated with the display of labels.
 * This class holds information such as the displayed labels and any potential label-related errors.
 */
public class DisplayingLabelsState {

    private static Set<Label> labels = new HashSet<>();
    private String labelError = "";

    /**
     * Default constructor for DisplayingLabelsState.
     */
    public DisplayingLabelsState() {}

    /**
     * Constructs a new DisplayingLabelsState by copying the contents of another instance.
     *
     * @param copy the DisplayingLabelsState instance to copy
     */
    public DisplayingLabelsState(DisplayingLabelsState copy) {
        labels = copy.labels;
        labelError = copy.labelError;
    }

    /**
     * Gets the set of labels to be displayed.
     *
     * @return the set of labels
     */
    public static Set<Label> getLabels() {
        return labels;
    }

    /**
     * Sets the set of labels to be displayed.
     *
     * @param labels the set of labels to set
     */
    public static void setLabels(Set<Label> labels) {
        DisplayingLabelsState.labels = labels;
    }

    /**
     * Sets the error message related to label display.
     *
     * @param labelError the error message to set
     */
    public void setLabelError(String labelError) {
        this.labelError = labelError;
    }

    public String getLabelError() {
        return labelError;
    }
}
