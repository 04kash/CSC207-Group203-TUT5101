package use_case.CreateLabel;
import entity.Label;
import entity.User;
public interface CreateLabelDataAccessInterface {
    void addLabelToPlanner(String username, Label newLabel);
    boolean labelExists(String username,Label label);
    String getCurrentUser();
}
