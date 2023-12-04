package entity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

public class Planner {
    private final HashMap<Label, ArrayList<Location>> planner;


    /**
     * Initializes an empty planner which sets the label to "favorite" and its associated values as an empty array list
     * of locations
     */
    public Planner() {
        this.planner = new HashMap<>();
        planner.put(new Label(), new ArrayList<Location>());
    }

    /**
     * This method takes in specific values of the input to create a planner object
     *
     * @param planner a hashmap with a label as its key and an array list of locations as its associated values which
     *               is then set to as a planner object
     */
    public Planner(HashMap<Label, ArrayList<Location>> planner) {
        this.planner = planner;
    }

    /**
     * This method returns back the value of the private variable planner
     *
     * @return a planner object that represents the value of the planner
     */
    public HashMap<Label, ArrayList<Location>> getPlanner() {
        return planner;
    }

    /**
     * This method returns back the value of the all the keys of the planner which are all Labels
     *
     * @return a set of labels that are contained in the planner
     */
    public Set<Label> getLabel() {return planner.keySet();
    }

    /**
     * This method returns back the value of the locations that are associated with a particular label (key)
     *
     * @return a array list of locations
     */
    public ArrayList<Location> getLocations(Label key) {
        //return planner.get(key);
        ArrayList<Location> locations = new ArrayList<>();
        String labelTitle = key.getTitle();
        for (Label l : getLabel()) {
            if (Objects.equals(l.getTitle(), labelTitle)) {
                locations=planner.get(l);
            }
        }
        return locations;
    }

    /**
     * This method allows us to create a new label and associated values for that label
     *
     * @param label a label object that represents the new label we would like to create
     * @param locations the array list of locations that we would like to be associated with the label
     */
    public void setLabel(Label label, ArrayList<Location> locations) {
        planner.put(label, locations);
    }

}