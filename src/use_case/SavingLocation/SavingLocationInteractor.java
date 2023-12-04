package use_case.SavingLocation;

import entity.*;

/**
 * This class represents the interactor for handling the saving of locations use case.
 * It implements the interface, defining the logic for processing saving locations input data.
 */
public class SavingLocationInteractor implements SavingLocationInputBoundary{
    final SavingLocationUserDataAccessInterface userDataAccessObject;
    final SavingLocationOutputBoundary userPresenter;

    /**
     * Constructs a new instance of the display locations interactor with specified data access object and output
     * boundary
     *
     * @param savingLocationDataAccessInterface the data access object for the saving locations use case data operations
     * @param savingLocationOutputBoundary the output boundary for the saving locations use case related output data
     */
    public SavingLocationInteractor(SavingLocationUserDataAccessInterface savingLocationDataAccessInterface,
                                    SavingLocationOutputBoundary savingLocationOutputBoundary) {
        this.userDataAccessObject = savingLocationDataAccessInterface;
        this.userPresenter = savingLocationOutputBoundary;
    }

    /**
     * Executes the saving location use case based on the provided input data
     *
     * @param savingLocationInputData the input data for the use case operation
     */
    public void execute(SavingLocationInputData savingLocationInputData){
        Coordinate coordinate = new Coordinate(savingLocationInputData.getLatitude(), savingLocationInputData.getLongitude());
        String currentUser = userDataAccessObject.getCurrentUser();
        Location chosenLocation = new Location(savingLocationInputData.getLocationName(),coordinate, savingLocationInputData.getLink(), savingLocationInputData.getFilters());
        Label chosenLabel = new Label(savingLocationInputData.getChosenLabel());
        if(userDataAccessObject.locationExists(currentUser,chosenLocation)){
            userPresenter.prepareFailView("Location is already saved.");
        }else{
            userDataAccessObject.addLocation(currentUser, chosenLocation, chosenLabel);
            if(userDataAccessObject.locationExists(currentUser, chosenLocation)){
                userPresenter.prepareSuccessView("Location saved successfully");
            }
        }
    }
}
