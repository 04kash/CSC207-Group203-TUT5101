package use_case.SavingLocation;

import entity.*;

public class SavingLocationInteractor implements SavingLocationInputBoundary{
    final SavingLocationUserDataAccessInterface userDataAccessObject;
    final SavingLocationOutputBoundary userPresenter;
    public SavingLocationInteractor(SavingLocationUserDataAccessInterface savingLocationDataAccessInterface,
                                    SavingLocationOutputBoundary savingLocationOutputBoundary) {
        this.userDataAccessObject = savingLocationDataAccessInterface;
        this.userPresenter = savingLocationOutputBoundary;
    }
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
