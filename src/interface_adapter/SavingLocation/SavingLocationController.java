package interface_adapter.SavingLocation;

import use_case.SavingLocation.SavingLocationInputBoundary;
import use_case.SavingLocation.SavingLocationInputData;

public class SavingLocationController {
    final SavingLocationInputBoundary userSavingLocationInteractor;
    public SavingLocationController(SavingLocationInputBoundary userSavingLocationInteractor){
           this.userSavingLocationInteractor=userSavingLocationInteractor;
    }
    public void execute(String username,String password, String chosenLabel, String locationName, double latitude, double longitude, double proximity, String filter){
        SavingLocationInputData savingLocationInputData = new SavingLocationInputData(username,password,chosenLabel,locationName,latitude,longitude,proximity,filter);
        userSavingLocationInteractor.execute(savingLocationInputData);
    }
}
