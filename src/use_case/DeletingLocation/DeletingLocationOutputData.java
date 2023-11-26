package use_case.DeletingLocation;

import java.util.ArrayList;

public class DeletingLocationOutputData {
    private final ArrayList<String> deletedLocation;

    public DeletingLocationOutputData(ArrayList<String> deletedUsers) {
        this.deletedLocation = deletedLocation;
    }

    public ArrayList<String> getDeletedUsers() {
        return deletedLocation;
    }

}
