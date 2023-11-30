package use_case.displayingLabels;

import entity.Label;

import java.util.Set;

public class DisplayingLabelsOutputData {
    public final Set<Label> labels;
    private boolean useCaseFailed;
    public DisplayingLabelsOutputData(Set<Label> labels, boolean useCaseFailed) {
        this.labels = labels;
        this.useCaseFailed = useCaseFailed;
    }

    public Set<Label> getLabels() {
        return labels;
    }
}
