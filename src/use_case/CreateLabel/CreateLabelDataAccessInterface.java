package use_case.CreateLabel;

import entity.Label;

/**
 * This interface defines methods for accessing user data related to the labels created by the user
 */
public interface CreateLabelDataAccessInterface {
    /**
     * Add the label to the users planner
     *
     * @param username the username of the user currently using the program
     * @param newLabel the name of the label that user wishes to add to their planner
     */
    void addLabelToPlanner(String username, Label newLabel);

    /**
     * This method informs whether or the label that is wanting to be added already exists or not
     *
     * @param username the username of the user currently using the program
     * @param label the name of the label that user wishes to add to their planner
     * @return a boolean which is true if the label already exists, false otherwise
     */
    boolean labelExists(String username,Label label);

    /**
     * Gets back the username of the user currently running the program
     *
     * @return a string value that represents the username of the user
     */
    String getCurrentUser();
}
