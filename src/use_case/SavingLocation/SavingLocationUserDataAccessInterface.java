package use_case.SavingLocation;

import entity.City;
import entity.Label;
import entity.User;

public interface SavingLocationUserDataAccessInterface {
  void updateUserPlanner(User user, City newCity, Label newLabel);
  boolean locationExists(User user, City city);
  User getUser(String username);
}
