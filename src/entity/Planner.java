package entity;

import java.util.HashMap;
import java.util.Set;

public class Planner {
    private final HashMap<Label, Location[]> planner;


    public Planner() {this.planner = new HashMap<>();}

    Planner(HashMap<Label, Location[]> planner) {
        this.planner = planner;
    }

    public HashMap<Label, Location[]> getPlanner() {
        return planner;
    }

    public Set<Label> getLabel() {return planner.keySet();}

    public Location[] getLocations(Label key) {return planner.get(key);}

    public void setLabel(Label label, Location[] locations) {
        planner.put(label, locations);
    }
}
