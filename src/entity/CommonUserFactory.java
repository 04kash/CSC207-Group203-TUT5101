package entity;
import java.util.HashMap;
import java.time.LocalDateTime;

public class CommonUserFactory implements UserFactory{
    private final Planner initialPlanner = new Planner(new HashMap<>());
    @Override
    public User create(String name, String password) {
        return new User(name, password,initialPlanner);
    }

}
