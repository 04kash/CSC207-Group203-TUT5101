package use_case.displayingLabels;

import entity.User;

public interface DisplayingLabelsUserDataAccessInterface {
    public User get(String username);

    public String getCurrentUser();
}
