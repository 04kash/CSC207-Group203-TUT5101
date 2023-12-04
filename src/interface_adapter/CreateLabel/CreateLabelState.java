package interface_adapter.CreateLabel;

/**
 * Represents the state associated with the creation of a label.
 * This class holds information such as the chosen label and display messages.
 */
public class CreateLabelState {


    private String chosenLabel;

    private String displayMsg = null;

    /**
     * Constructs a new CreateLabelState by copying the contents of another instance.
     *
     * @param copy the CreateLabelState instance to copy
     */
    public CreateLabelState(CreateLabelState copy){
        chosenLabel = copy.chosenLabel;
        displayMsg = copy.displayMsg;
    }

    /**
     * Default constructor for CreateLabelState.
     */
    CreateLabelState(){}

    /**
     * Gets the chosen label.
     *
     * @return the chosen label
     */
    public String getChosenLabel() {
        return chosenLabel;
    }

    /**
     * Gets the display message associated with the label creation process.
     *
     * @return the display message
     */
    public String getDisplayMsg() {
        return displayMsg;
    }

    /**
     * Sets the chosen label.
     *
     * @param chosenLabel the chosen label to set
     */
    public void setChosenLabel(String chosenLabel) {
        this.chosenLabel = chosenLabel;
    }

    /**
     * Sets the display message associated with the label creation process.
     *
     * @param displayMsg the display message to set
     */
    public void setDisplayMessage(String displayMsg) {
        this.displayMsg = displayMsg;
    }
}