package use_case.LocationsFromLabel;

import entity.Label;

public class LocationsFromLabelInputData {
    final private String label;

    public LocationsFromLabelInputData(String label){
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
