package use_case.CreateLabel;

/**
 * This class represents the input data for a creating labels use case
 * Instances of this class are used to collect information required
 */
public class CreateLabelInputData {
    private final String chosenLabel;

    /**
     * Constructs a new instance of the output data with the specific label that the users
     * wish to add to their planner
     *
     * @param chosenlabel the label that the user wishes to add
     */
    public CreateLabelInputData(String chosenlabel){
        this.chosenLabel = chosenlabel;
    }

    /**
     * Retrieves the chosen label parameter
     *
     * @return the string value of the label the user wishes to add
     */
    public String getChosenLabel() {
        return chosenLabel;
    }
}

