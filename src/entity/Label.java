package entity;

import org.json.JSONObject;

public class Label {
    private String title = "favorite";

    /**
     * initializes an empty Label object to just store the value of the title as favorite
     */
    public Label() {}

    /**
     * This method create a label object with a custom title
     *
     * @param title a string that represents the title of the label
     */
    public Label(String title) {
        this.title = title;
    }

    /**
     * This method returns back the value of the private variable title
     *
     * @return a string that represents the value of title
     */
    public String getTitle() {
        return title;
    }
}
