package src.interface_adapter.CreateLabel;

public class CreateLabelState {

    private String username = "";
    private String password = "";
    private String chosenLabel = "Favorites";
    private String displayMsg = null;

    public CreateLabelState(){
        username = copy.username;
        password = copy.password;
        chosenLabel = copy.chosenLabel;
        displayMsg = copy.displayMsg;
    }

    public String getChosenLabel() {
        return chosenLabel;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDisplayMsg() {
        return displayMsg;
    }

    public void setChosenLabel(String chosenLabel) {
        this.chosenLabel = chosenLabel;
    }

    public void setDisplayMessage(String displayMsg) {
        this.displayMsg = displayMsg;
    }

}
