//package use_case.DeletingLocation;
//
//import java.util.ArrayList;
//
//public class DeletingLocationInteractor implements DeletingLocationInputBoundary {
//    final DeletingLocationUserDataAccessInterface userDataAccessObject;
//    final DeletingLocationOutputBoundary deletingLocationOutputBoundary;
//
//    public DeletingLocationInteractor(DeletingLocationUserDataAccessInterface deletingLocationDataAccessInterface, DeletingLocationOutputBoundary deletingLocationOutputBoundary) {
//        this.userDataAccessObject = deletingLocationDataAccessInterface;
//        this.deletingLocationOutputBoundary = deletingLocationOutputBoundary;
//    }
//
//
//    //@Override
//    public void execute(DeletingLocationInputData deletingLocationInputData) {
//        ArrayList<String> location = userDataAccessObject.getLocation();
//        DeletingLocationOutputData data = new DeletingLocationOutputData(location);
//        userDataAccessObject.clear();
//        deletingLocationOutputBoundary.prepareSuccessView(data);
//
//    }
//}
