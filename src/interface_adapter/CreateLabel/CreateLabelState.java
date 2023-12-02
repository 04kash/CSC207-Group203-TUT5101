package interface_adapter.CreateLabel;

public class CreateLabelState {
    private String chosenLabel;
    private String displayMsg = null;

    public CreateLabelState(CreateLabelState copy){
        chosenLabel = copy.chosenLabel;
        displayMsg = copy.displayMsg;
    }
    CreateLabelState(){}
    public String getChosenLabel() {
        return chosenLabel;
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
