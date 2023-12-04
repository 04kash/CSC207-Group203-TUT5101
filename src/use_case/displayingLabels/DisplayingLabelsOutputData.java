package use_case.displayingLabels;

import entity.Label;

import java.util.Set;

/**
 * This class represents the output data of a display label use case operation
 */
public class DisplayingLabelsOutputData {
    private final Set<Label> labels;
    private boolean useCaseFailed;

    /**
     * Constructs an instance of the output data with the labels of the user and the success or failure status of the
     * corresponding use case operation.
     *
     * @param labels the set of labels retrieved from the users planner
     * @param useCaseFailed true if the corresponding use case operation has failed, false otherwise.
     */
    public DisplayingLabelsOutputData(Set<Label> labels, boolean useCaseFailed) {
        this.labels = labels;
        this.useCaseFailed = useCaseFailed;
    }

    /**
     * Gets the set of labels retrieved from the user's planner
     *
     * @return the set of labels
     */
    public Set<Label> getLabels() {
        return labels;
    }
}
