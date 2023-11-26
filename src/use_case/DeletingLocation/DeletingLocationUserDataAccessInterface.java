package use_case.DeletingLocation;

import entity.Location;

import java.util.ArrayList;

public class DeletingLocationUserDataAccessInterface {
    boolean existsByName(String identifier);
    public ArrayList<String> getLocation();

    public void clear();

    void save(Location location);
}
