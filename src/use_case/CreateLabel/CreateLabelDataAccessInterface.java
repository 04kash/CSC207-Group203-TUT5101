package src.use_case.CreateLabel;
import entity.Label;
import entity.User;
public interface CreateLabelDataAccessInterface {
    void addLabelToPlanner(User user, Label newLabel);
    boolean labelExists(Label label);
    User getUser(String username);
}
