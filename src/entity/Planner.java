package entity;

import java.util.HashMap;

public class Planner {
    private final HashMap<Label, Location[]> planner;

    Planner(HashMap<Label, Location[]> planner) {
        this.planner = planner;
    }

    public HashMap<Label, Location[]> getPlanner() {
        return planner;
    }
}
