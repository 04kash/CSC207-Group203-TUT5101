package data_access;

import entity.CommonUser;
import entity.Planner;
import entity.User;
import use_case.displayingLabels.DisplayingLabelsUserDataAccessInterface;

import java.util.HashMap;
import java.util.Map;

public class InMemoryDisplayingLabels implements DisplayingLabelsUserDataAccessInterface {
    private final Map<String, User> accounts = new HashMap<>();
    private final String currentUser;
    public InMemoryDisplayingLabels(){
        Planner planner = new Planner();
        this.currentUser="Kashish";
       User user = new CommonUser("Kashish","123",planner);
       accounts.put("Kashish",user);
   }
    @Override
    public User get(String username) {
        return accounts.get(username);
}

    @Override
    public String getCurrentUser() {
        return currentUser;
    }
}
