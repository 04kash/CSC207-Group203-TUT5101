package entity;

import java.util.HashMap;

public class Planner {
    private final HashMap<Label, City[]> planner;

    Planner(HashMap<Label, City[]> planner) {
        this.planner = planner;
    }

    public HashMap<Label, City[]> getPlanner() {
        return planner;
    }
}
