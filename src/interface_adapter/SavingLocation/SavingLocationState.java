package interface_adapter.SavingLocation;

/**
 * Represents the state associated with the saving location functionality.
 * This class holds information such as the display message resulting from a saving location attempt.
 */
public class SavingLocationState {
    private String displayMsg = null;

    /**
     * Constructs a new SavingLocationState by copying the contents of another instance.
     *
     * @param copy the SavingLocationState instance to copy
     */
    public SavingLocationState(SavingLocationState copy) {
        displayMsg = copy.displayMsg;
    }

    /**
     * Default constructor for SavingLocationState.
     */
    SavingLocationState() {}

    /**
     * Gets the display message associated with the saving location functionality.
     *
     * @return the display message
     */
    public String getDisplayMsg() {
        return displayMsg;
    }

    /**
     * Sets the display message associated with the saving location functionality.
     *
     * @param displayMsg the display message to set
     */
    public void setDisplayMsg(String displayMsg) {
        this.displayMsg = displayMsg;
    }
}
