package entity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

public class Planner {
    private final HashMap<Label, ArrayList<Location>> planner;

    public Planner() {
        this.planner = new HashMap<>();
        planner.put(new Label(), new ArrayList<Location>());
    }

    public Planner(HashMap<Label, ArrayList<Location>> planner) {
        this.planner = planner;
    }

    public HashMap<Label, ArrayList<Location>> getPlanner() {
        return planner;
    }

    public Set<Label> getLabel() {
        return planner.keySet();
    }

    public ArrayList<Location> getLocations(Label key) {
        //return planner.get(key);
        String labelTitle = key.getTitle();
        for (Label l: getLabel()){
            if(Objects.equals(l.getTitle(), labelTitle)){
                return planner.get(l);
            }
        }
        return null;
    }

    public void setLabel(Label label, ArrayList<Location> locations) {
        planner.put(label, locations);
    }

    public JSONObject toJSON() {
        JSONObject json = new JSONObject();

        JSONArray labelsArray = new JSONArray();
        for (Label label : planner.keySet()) {
//            JSONObject labelObject = new JSONObject();
//            labelObject.put("title", label.getTitle());

            JSONArray locationsArray = new JSONArray();
            for (Location location : planner.get(label)) {
                locationsArray.put(location.toJSON());
            }

            json.put(label.getTitle(), locationsArray);
            //labelsArray.put(labelObject);
        }

        //json.put("labels", labelsArray);
        return json;
    }
}