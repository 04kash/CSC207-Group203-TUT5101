package entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Planner {
    private final HashMap<Label, ArrayList<Location>> planner;


    public Planner() {
        this.planner = new HashMap<>();
        planner.put(new Label(), new ArrayList<Location>());
    }

    Planner(HashMap<Label, ArrayList<Location>> planner) {
        this.planner = planner;
    }

    public HashMap<Label, ArrayList<Location>> getPlanner() {
        return planner;
    }

    public Set<Label> getLabel() {return planner.keySet();
    }

    public ArrayList<Location> getLocations(Label key) {return planner.get(key);}

    public void setLabel(Label label, ArrayList<Location> locations) {
        planner.put(label, locations);
    }
}
