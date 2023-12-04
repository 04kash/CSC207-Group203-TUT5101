package data_access;

import entity.CommonUser;
import entity.Label;
import entity.Planner;
import entity.User;
import use_case.CreateLabel.CreateLabelDataAccessInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class InMemoryCreateLabel implements CreateLabelDataAccessInterface {
    private final Map<String, User> accounts = new HashMap<>();
    private final String currentUser ="Kashish";
    public InMemoryCreateLabel(){
        Planner planner = new Planner(new HashMap<>());
        planner.setLabel(new Label("favorite"),new ArrayList<>());
        User user = new CommonUser("Kashish","123",planner);
        accounts.put("Kashish",user);
    }

    @Override
    public void addLabelToPlanner(String username, Label newLabel) {
        Planner userPlanner = accounts.get(username).getPlanner();
        userPlanner.setLabel(newLabel, new ArrayList<>());
    }

    @Override
    public boolean labelExists(String username, Label label) {
        User user = accounts.get(username);
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
}
