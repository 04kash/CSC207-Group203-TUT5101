package entity;

public class CommonUser implements User{
    private final String username;
    private final String password;
    private final Planner planner;

    public CommonUser(String username, String password, Planner planner) {
        this.username = username;
        this.password = password;
        this.planner = planner;
    }

    public String getUsername() {return username;}

    public String getPassword() {
        return password;
    }

    public Planner getPlanner() {
        return planner;
    }
}
