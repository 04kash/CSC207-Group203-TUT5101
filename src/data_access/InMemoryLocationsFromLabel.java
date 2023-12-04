package data_access;

import entity.*;
import use_case.LocationsFromLabel.LocationsFromLabelInteractor;
import use_case.LocationsFromLabel.LocationsFromLabelUserDataAccessInterface;

import java.util.*;

public class InMemoryLocationsFromLabel implements LocationsFromLabelUserDataAccessInterface {
    private final Map<String, User> accounts = new HashMap<>();

    private String currentUser="Kashish";

    public InMemoryLocationsFromLabel(String label,ArrayList<Location> locations){
        Planner planner = new Planner(new HashMap<>());
        planner.setLabel(new Label(label),locations);
        planner.setLabel(new Label("favorite"),new ArrayList<>());
        User user = new CommonUser("Kashish","123",planner);
        accounts.put("Kashish",user);
    }
    @Override
    public ArrayList<Location> getLocationsFromLabel(String username, Label newLabel) {
        Set<Label> labels = accounts.get(username).getPlanner().getLabel();
        Label savedLabel = new Label();
        boolean inPlanner = false;
        for (Label label : labels) {
            if (label.getTitle().equals(newLabel.getTitle())) {
                savedLabel = label;
                inPlanner = true;
            }
        }
        if (inPlanner) {
            return accounts.get(username).getPlanner().getLocations(savedLabel);
        } else {
            ArrayList<Location> list = new ArrayList<>();
            return list;
        }
    }

    @Override
    public boolean labelExists(String username, Label label) {
        User user = accounts.get(username);
        //System.out.println(accounts);
        Label[] labels = user.getPlanner().getLabel().toArray(new Label[0]);
        for(Label labelInPlanner:labels){
            if(Objects.equals(labelInPlanner.getTitle(), label.getTitle())){
                return true;
            }
    }
        return false;
    }

    @Override
    public String getCurrentUser() {
            return currentUser;
    }

    @Override
    public boolean labelIsEmpty(String username, Label label) {
        User user = accounts.get(username);
        Label[] labels = user.getPlanner().getLabel().toArray(new Label[0]);
        for(Label labelInPlanner:labels){
            if(Objects.equals(labelInPlanner.getTitle(), label.getTitle())){
                if(user.getPlanner().getLocations(labelInPlanner).isEmpty()){
                    return true;
                }
            }

        }
        return false;
    }
}
