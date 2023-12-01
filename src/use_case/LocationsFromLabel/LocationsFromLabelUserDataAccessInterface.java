package use_case.LocationsFromLabel;

import entity.Label;
import entity.Location;

import java.util.ArrayList;

public interface LocationsFromLabelUserDataAccessInterface {
    ArrayList<Location> getLocationsFromLabel(String username,Label label);
    boolean labelExists(String username,Label label);
    String getCurrentUser();

    boolean labelIsEmpty(String username,Label label);
}
