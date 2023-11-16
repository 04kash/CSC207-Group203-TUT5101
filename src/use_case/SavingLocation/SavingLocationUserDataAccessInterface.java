package use_case.SavingLocation;

import entity.Label;
import entity.Location;
import entity.User;

public interface SavingLocationUserDataAccessInterface {
  void updateUserPlanner(User user, Location newLocation, Label newLabel);
  boolean locationExists(User user, Location location);
  User getUser(String username);
}
