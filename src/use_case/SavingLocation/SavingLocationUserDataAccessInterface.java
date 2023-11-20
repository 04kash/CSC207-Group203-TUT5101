package use_case.SavingLocation;

import entity.*;

public interface SavingLocationUserDataAccessInterface {
  void updateUserPlanner(User user, Location location, Label newLabel);
  boolean locationExists(User user, Coordinate coordinate);
  User getUser(String username);
}
