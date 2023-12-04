package interface_adapter.LocationsFromLabel;

import entity.Coordinate;
import interface_adapter.SavingLocation.SavingLocationPresenter;
import interface_adapter.SavingLocation.SavingLocationViewModel;
import interface_adapter.ViewManagerModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.LocationsFromLabel.LocationsFromLabelOutputData;
import entity.Location;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LocationsFromLabelPresenterTest {
    LocationsFromLabelPresenter locationsFromLabelPresenter;
    LocationsFromLabelViewModel locationsFromLabelViewModel;
    @BeforeEach
    void unit(){
        locationsFromLabelViewModel = new LocationsFromLabelViewModel();
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        locationsFromLabelPresenter = new LocationsFromLabelPresenter(locationsFromLabelViewModel,viewManagerModel);
    }

    @Test
    void prepareSuccessView() {
        ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location("The Abbot",new Coordinate(-79.4134750366211,43.70365524291992),"node/7567822674","foods"));
        LocationsFromLabelOutputData locationsFromLabelOutputData = new LocationsFromLabelOutputData(locations,false);
        locationsFromLabelPresenter.prepareSuccessView(locationsFromLabelOutputData);
        assertEquals("The Abbot\nhttps://www.openstreetmap.org/node/7567822674\n\n", LocationsFromLabelState.getDisplayMsg());
    }

    @Test
    void prepareFailView() {
        locationsFromLabelPresenter.prepareFailView("Error");
        assertEquals("Error", LocationsFromLabelState.getDisplayMsg());
    }
}