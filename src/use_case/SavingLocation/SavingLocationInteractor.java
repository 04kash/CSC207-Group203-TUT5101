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
        City chosenCity = new City(savingLocationInputData.getLocationName(),coordinate,savingLocationInputData.getProximity(),savingLocationInputData.getFilters());
        User currentUser = userDataAccessObject.getUser(savingLocationInputData.getUsername());
        Label chosenLabel = new Label(savingLocationInputData.getChosenLabel());
        if(userDataAccessObject.locationExists(currentUser, chosenCity)){
            userPresenter.prepareFailView("Location is already saved.");
        }else{
            userDataAccessObject.updateUserPlanner(currentUser, chosenCity,chosenLabel);
            if(userDataAccessObject.locationExists(currentUser, chosenCity)){
                userPresenter.prepareSuccessView("Location saved successfully");
            }else{
                userPresenter.prepareFailView("Location was not saved.Please try again.");
            }
        }
    }
}
