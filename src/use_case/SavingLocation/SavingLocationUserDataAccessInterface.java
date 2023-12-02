package use_case.SavingLocation;

import entity.*;

public interface SavingLocationUserDataAccessInterface {
  void addLocation(String username, Location location, Label newLabel);
  boolean locationExists(String username, Location location);

  String getCurrentUser();
}
