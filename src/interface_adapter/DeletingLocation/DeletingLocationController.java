package interface_adapter.DeletingLocation;

import use_case.DeletingLocation.DeletingLocationInputBoundary;
import use_case.DeletingLocation.DeletingLocationInputData;

public class DeletingLocationController {
    final DeletingLocationInputBoundary userDeletingLocationUseCaseInteractor;
    public DeletingLocationController(DeletingLocationInputBoundary userDeletingLocationUseCaseInteractor) {
        this.userDeletingLocationUseCaseInteractor = userDeletingLocationUseCaseInteractor;
    }

    public void execute() {
        DeletingLocationInputData deleteLocationInputData = new DeletingLocationInputData();
        userDeletingLocationUseCaseInteractor.execute(deleteLocationInputData);
    }
}
