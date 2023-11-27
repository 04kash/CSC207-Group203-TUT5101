package use_case.displayingLocations;

import entity.Location;

import java.util.ArrayList;
import java.util.HashMap;

public class DisplayingLocationsInteractor implements DisplayingLocationsInputBoundary {
    final DisplayingLocationsUserDataAccessInterface userDataAccessObject;
    final DisplayingLocationsOutputBoundary displayingLocationsPresenter;
    public DisplayingLocationsInteractor(DisplayingLocationsUserDataAccessInterface userDataAccessObject, DisplayingLocationsOutputBoundary displayingLocationsPresenter) {
        this.displayingLocationsPresenter = displayingLocationsPresenter;
        this.userDataAccessObject = userDataAccessObject;
    }

    @Override
    public void execute(DisplayingLocationsInputData displayingLocationsInputData) {
        HashMap<String, Location> locationHashMap = userDataAccessObject.getAccounts();
        ArrayList<Location> locations = new ArrayList<>();
        for (String key : locationHashMap.keySet()) {
            locations.add(locationHashMap.get(key));
        }
        DisplayingLocationsOutputData displayingLocationsOutputData = new DisplayingLocationsOutputData(locations, false);
        displayingLocationsPresenter.prepareSuccessView(displayingLocationsOutputData);
    }
}
