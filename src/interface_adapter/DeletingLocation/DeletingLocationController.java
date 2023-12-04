//package interface_adapter.DeletingLocation;
//
//import use_case.DeletingLocation.DeletingLocationInputBoundary;
//import use_case.DeletingLocation.DeletingLocationInputData;
//
//public class DeletingLocationController {
//    final DeletingLocationInputBoundary userDeletingLocationInteractor;
//    public DeletingLocationController(DeletingLocationInputBoundary userDeletingLocationInteractor) {
//        this.userDeletingLocationInteractor = userDeletingLocationInteractor;
//    }
//
//    public void execute(String locationName) {
//        DeletingLocationInputData deletingLocationInputData = new DeletingLocationInputData(locationName);
//        userDeletingLocationInteractor.execute(deletingLocationInputData);
//    }
//}
