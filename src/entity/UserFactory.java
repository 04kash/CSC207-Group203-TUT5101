package entity;

import java.time.LocalDateTime;

public interface UserFactory {
    public User create(String name, String password, Planner planner);
}
