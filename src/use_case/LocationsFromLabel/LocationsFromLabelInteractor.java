package use_case.LocationsFromLabel;

import entity.Label;

/**
 * This class represents the interactor for handling the locations from label use case.
 * It implements the interface, defining the logic for processing location from labels input data.
 */
public class LocationsFromLabelInteractor implements LocationsFromLabelInputBoundary {
    final LocationsFromLabelUserDataAccessInterface userDataAccessObject;
    final LocationsFromLabelOutputBoundary userPresenter;

    /**
     * Constructs a new instance of the locations from label interactor with specified data access object and output
     * boundary
     *
     * @param locationsFromLabelUserDataAccessInterface the data access object for the locations from label use case
     *                                                 data operations
     * @param locationsFromLabelOutputBoundary the output boundary for presenting location from label use case related
     *                                         output data
     */
    public LocationsFromLabelInteractor(LocationsFromLabelUserDataAccessInterface locationsFromLabelUserDataAccessInterface,
                                    LocationsFromLabelOutputBoundary locationsFromLabelOutputBoundary) {
        this.userDataAccessObject = locationsFromLabelUserDataAccessInterface;
        this.userPresenter = locationsFromLabelOutputBoundary;
    }

    /**
     * Executes the location from label use case based on the provided input data
     *
     * @param locationsFromLabelInputData the input data for the use case operation
     */
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
