package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class PlannerTest {
    private Planner planner;
    private Label label;
    private Coordinate coordinate;
    private Coordinate coordinate1;


    @BeforeEach
    void init() {
        this.planner = planner;
        planner = new Planner();
        coordinate = new Coordinate(1.234, 5.678);
        coordinate1 = new Coordinate(1.357, 2.468);
        label = new Label("Restaurants");
        ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location("KFC", coordinate, "link","Fast Food"));
        locations.add(new Location("AP Sushi", coordinate1, "link1", "Dinner"));
        planner.setLabel(label, locations);
    }
    PlannerTest(HashMap<Label, ArrayList<Location>> planner) {
        planner.put(label, new ArrayList<Location>());
}
    @Test
    void getPlanner() {
        assertNotNull(planner.getPlanner());
        assertTrue(planner.getPlanner().isEmpty());
    }

    @Test
    void getLabel() {

        assertTrue(planner.getLabel().contains(label));
    }

    @Test
    void getLocations() {
        planner = new Planner();
        coordinate = new Coordinate(1.234, 5.678);
        coordinate1 = new Coordinate(1.357, 2.468);
        Label label = new Label("Restaurants");
        ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location("KFC", coordinate, "link","Fast Food"));
        locations.add(new Location("AP Sushi", coordinate1, "link1", "Dinner"));
        planner.setLabel(label, locations);
        assertEquals(locations, planner.getLocations(label));
    }

    @Test
    void setLabel() {
        Planner planner = new Planner();
        Label label = new Label("Museums");
        ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location("AGO", coordinate1, "link3", "Art"));
        planner.setLabel(label, locations);
        assertTrue(planner.getPlanner().containsKey(label));
        assertEquals(locations, planner.getLocations(label));
    }
}