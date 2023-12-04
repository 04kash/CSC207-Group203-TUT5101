package entity;

import org.json.JSONObject;

public class CommonUser implements User {
    private final String username;
    private final String password;
    private final Planner planner;

    /**
     * This method creates a Common User object in which a users username, password, and their specific planner with
     * saved locations and labels are saved
     *
     * @param username a string which represents the users username
     * @param password a string to represent the users password
     * @param planner a planner object in which all the users locations and labels are stored
     */
    public CommonUser(String username, String password, Planner planner) {
        this.username = username;
        this.password = password;
        this.planner = planner;
    }

    /**
     * This method allows us to access the private variable username
     * @return a string that represents the users' username
     */
    public String getUsername() {return username;}

    /**
     * This method allows us to access the private variable password
     * @return a string that represents the users' password
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method allows us to access the private variable planner
     * @return a planner object that represents the users' planner
     */
    public Planner getPlanner() {
        return planner;
    }
}
