package entity;

import org.json.JSONObject;

public class Label {
    private String title = "favorite";

    public Label() {
    }

    public Label(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

