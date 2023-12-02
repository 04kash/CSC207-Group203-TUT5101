package data_access;

import entity.*;
import use_case.SavingLocation.SavingLocationUserDataAccessInterface;

import java.util.*;


public class InMemorySavingLocation implements SavingLocationUserDataAccessInterface {
    private final Map<String, User> accounts = new HashMap<>();

    private String currentUser="Kashish";

    public InMemorySavingLocation(){
        Planner planner = new Planner();
        planner.setLabel(new Label("favorite"),new ArrayList<>());
        User user = new CommonUser("Kashish","123",planner);
        accounts.put("Kashish",user);
    }
    @Override
    public void addLocation(String username, Location location, Label newLabel) {
        Set<Label> labels = accounts.get(username).getPlanner().getLabel();
        Label savedLabel = new Label();
        boolean inPlanner = false;
        for (Label label: labels) {
            if (label.getTitle().equals(newLabel.getTitle())) {
                savedLabel = label;
                inPlanner = true;
            }
        }
        if (inPlanner) {
            accounts.get(username).getPlanner().getLocations(savedLabel).add(location);
        } else {
            ArrayList<Location> list = new ArrayList<>();
            list.add(location);
            accounts.get(username).getPlanner().setLabel(savedLabel, list);
        }
    }

    @Override
    public boolean locationExists(String username, Coordinate coordinate) {
        User user = accounts.get(username);
        Label[] labels = user.getPlanner().getLabel().toArray(new Label[0]);
        for (Label label : labels) {
            ArrayList<Location> locations = user.getPlanner().getLocations(label);

            for (Location location : locations) {
                if ((Double.compare(location.getCoordinate().getLatitude(),coordinate.getLatitude())==0 && Double.compare(location.getCoordinate().getLongitude(),coordinate.getLongitude())==0 )){
                    return true;
                }
            }
        }

        return false;
    }
    @Override
    public String getCurrentUser() {
        return currentUser;
    }
}
