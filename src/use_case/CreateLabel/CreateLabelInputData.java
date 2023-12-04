package use_case.CreateLabel;

public class CreateLabelInputData {
    private final String chosenLabel;

    public CreateLabelInputData(String chosenlabel){
        this.chosenLabel = chosenlabel;
    }

    public String getChosenLabel() {
        return chosenLabel;
    }
}

