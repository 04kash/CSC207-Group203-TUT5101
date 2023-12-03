package entity;

import java.util.HashMap;

public class CommonUserFactory implements UserFactory {
    @Override
    public User create(String name, String password, Planner planner) {
        return new CommonUser(name, password, planner);
    }
}
