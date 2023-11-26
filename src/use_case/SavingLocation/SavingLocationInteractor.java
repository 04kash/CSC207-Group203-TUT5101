package use_case.SavingLocation;

import entity.*;

public class SavingLocationInteractor {
    final SavingLocationUserDataAccessInterface userDataAccessObject;
    final SavingLocationOutputBoundary userPresenter;
    final UserFactory userFactory;
    public SavingLocationInteractor(SavingLocationUserDataAccessInterface savingLocationDataAccessInterface,
                                    SavingLocationOutputBoundary savingLocationOutputBoundary,
                                    UserFactory userFactory) {
        this.userDataAccessObject = savingLocationDataAccessInterface;
        this.userPresenter = savingLocationOutputBoundary;
        this.userFactory = userFactory;
    }
    public void execute(SavingLocationInputData savingLocationInputData){
        Coordinate coordinate = new Coordinate(savingLocationInputData.getLatitude(), savingLocationInputData.getLongitude());
        Location chosenLocation = new Location(savingLocationInputData.getLocationName(),coordinate, savingLocationInputData.getLink(), savingLocationInputData.getFilters());
        Label chosenLabel = new Label(savingLocationInputData.getChosenLabel());
        if(userDataAccessObject.locationExists(savingLocationInputData.getUsername(),coordinate)){
            userPresenter.prepareFailView("Location is already saved.");
        }else{
            userDataAccessObject.addLocation(savingLocationInputData.getUsername(),chosenLocation,chosenLabel);
            if(userDataAccessObject.locationExists(savingLocationInputData.getUsername(), coordinate)){
                userPresenter.prepareSuccessView("Location saved successfully");
            }else{
                userPresenter.prepareFailView("Location was not saved.Please try again.");
            }
        }
    }
}
