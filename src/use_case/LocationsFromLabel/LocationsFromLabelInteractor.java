package use_case.LocationsFromLabel;

import entity.Label;
import entity.UserFactory;
import use_case.SavingLocation.SavingLocationOutputBoundary;
import use_case.SavingLocation.SavingLocationUserDataAccessInterface;

public class LocationsFromLabelInteractor implements LocationsFromLabelInputBoundary {

    final LocationsFromLabelUserDataAccessInterface userDataAccessObject;
    final LocationsFromLabelOutputBoundary userPresenter;
    final UserFactory userFactory;
    public LocationsFromLabelInteractor(LocationsFromLabelUserDataAccessInterface locationsFromLabelUserDataAccessInterface,
                                    LocationsFromLabelOutputBoundary locationsFromLabelOutputBoundary,
                                    UserFactory userFactory) {
        this.userDataAccessObject = locationsFromLabelUserDataAccessInterface;
        this.userPresenter = locationsFromLabelOutputBoundary;
        this.userFactory = userFactory;
    }
    @Override
    public static void execute(LocationsFromLabelInputData locationsFromLabelInputData) {
        String username = userDataAccessObject.getCurrentUser();
        if(userDataAccessObject.labelExists(username,new Label(locationsFromLabelInputData.getLabel()))){
            LocationsFromLabelOutputData outputData;
            outputData = new LocationsFromLabelOutputData(userDataAccessObject.getLocationsFromLabel(username,new Label(locationsFromLabelInputData.getLabel())),false);
            userPresenter.prepareSuccessView(outputData);
        }else{
            userPresenter.prepareFailView("Locations could not be found.");
        }

    }
}
