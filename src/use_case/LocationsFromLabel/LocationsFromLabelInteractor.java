package use_case.LocationsFromLabel;

import entity.Label;

public class LocationsFromLabelInteractor implements LocationsFromLabelInputBoundary {

    final LocationsFromLabelUserDataAccessInterface userDataAccessObject;
    final LocationsFromLabelOutputBoundary userPresenter;
    public LocationsFromLabelInteractor(LocationsFromLabelUserDataAccessInterface locationsFromLabelUserDataAccessInterface,
                                    LocationsFromLabelOutputBoundary locationsFromLabelOutputBoundary) {
        this.userDataAccessObject = locationsFromLabelUserDataAccessInterface;
        this.userPresenter = locationsFromLabelOutputBoundary;
    }
    @Override
    public void execute(LocationsFromLabelInputData locationsFromLabelInputData) {
        String username = userDataAccessObject.getCurrentUser();
        if(userDataAccessObject.labelExists(username,new Label(locationsFromLabelInputData.getLabel())) && !userDataAccessObject.labelIsEmpty(username,new Label(locationsFromLabelInputData.getLabel()))){
            LocationsFromLabelOutputData outputData;
            outputData = new LocationsFromLabelOutputData(userDataAccessObject.getLocationsFromLabel(username,new Label(locationsFromLabelInputData.getLabel())),false);
            userPresenter.prepareSuccessView(outputData);
        }else if(!userDataAccessObject.labelExists(username,new Label(locationsFromLabelInputData.getLabel()))){
            userPresenter.prepareFailView("This Label does not exist");
        }else{
            userPresenter.prepareFailView("No locations have been saved under this Label.");
        }
    }
}
