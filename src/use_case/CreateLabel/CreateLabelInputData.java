package use_case.CreateLabel;

public class CreateLabelInputData {
    private final String username;
    private final String password;
    private final String chosenLabel;

    public CreateLabelInputData(String username, String password, String chosenlabel){
        this.username = username;
        this.password = password;
        this.chosenLabel = chosenlabel;
    }

    public String getChosenLabel() {
        return chosenLabel;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}

