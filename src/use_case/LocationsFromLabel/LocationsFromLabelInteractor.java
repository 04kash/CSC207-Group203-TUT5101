package use_case.LocationsFromLabel;

import entity.Label;
import entity.UserFactory;
import use_case.SavingLocation.SavingLocationOutputBoundary;
import use_case.SavingLocation.SavingLocationUserDataAccessInterface;

public class LocationsFromLabelInteractor implements LocationsFromLabelInputBoundary {

    final LocationsFromLabelUserDataAccessInterface userDataAccessObject;
    final LocationsFromLabelOutputBoundary userPresenter;
//    final UserFactory userFactory;
    public LocationsFromLabelInteractor(LocationsFromLabelUserDataAccessInterface locationsFromLabelUserDataAccessInterface,
                                    LocationsFromLabelOutputBoundary locationsFromLabelOutputBoundary) {
        this.userDataAccessObject = locationsFromLabelUserDataAccessInterface;
        this.userPresenter = locationsFromLabelOutputBoundary;
    }
    @Override
    public void execute(LocationsFromLabelInputData locationsFromLabelInputData) {
        String username = userDataAccessObject.getCurrentUser();
//        System.out.println(userDataAccessObject.labelExists(username,new Label(locationsFromLabelInputData.getLabel())));
        if(userDataAccessObject.labelExists(username,new Label(locationsFromLabelInputData.getLabel()))){
            LocationsFromLabelOutputData outputData;
            outputData = new LocationsFromLabelOutputData(userDataAccessObject.getLocationsFromLabel(username,new Label(locationsFromLabelInputData.getLabel())),false);
            System.out.println(outputData);
            userPresenter.prepareSuccessView(outputData);
        }else{
            userPresenter.prepareFailView("Locations could not be found.");
        }

    }
}
