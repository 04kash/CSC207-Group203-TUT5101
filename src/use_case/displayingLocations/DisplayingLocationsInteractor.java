package use_case.displayingLocations;

import entity.Location;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class represents the interactor for handling the displaying of locations use case.
 * It implements the interface, defining the logic for processing display locations input data.
 */
public class DisplayingLocationsInteractor implements DisplayingLocationsInputBoundary {
    final DisplayingLocationsUserDataAccessInterface userDataAccessObject;
    final DisplayingLocationsOutputBoundary displayingLocationsPresenter;

    /**
     * Constructs a new instance of the display locations interactor with specified data access object and output
     * boundary
     *
     * @param userDataAccessObject the data access object for the display locations use case data operations
     * @param displayingLocationsPresenter the output boundary for presenting display locations use case related output
     *                                    data
     */
    public DisplayingLocationsInteractor(DisplayingLocationsUserDataAccessInterface userDataAccessObject,
                                         DisplayingLocationsOutputBoundary displayingLocationsPresenter) {
        this.displayingLocationsPresenter = displayingLocationsPresenter;
        this.userDataAccessObject = userDataAccessObject;
    }

    /**
     * Executes the display location use case based on the provided input data
     *
     * @param displayingLocationsInputData the input data for the use case operation
     */
    @Override
    public void execute(DisplayingLocationsInputData displayingLocationsInputData) {
        HashMap<String, Location> locationHashMap = userDataAccessObject.getAccounts();
        ArrayList<Location> locations = new ArrayList<>();
        for (String key : locationHashMap.keySet()) {
            locations.add(locationHashMap.get(key));
        }
        DisplayingLocationsOutputData displayingLocationsOutputData =
                new DisplayingLocationsOutputData(locations, false);
        displayingLocationsPresenter.prepareSuccessView(displayingLocationsOutputData);
    }
}
