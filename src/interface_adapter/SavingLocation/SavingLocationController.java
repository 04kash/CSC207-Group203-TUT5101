package interface_adapter.SavingLocation;

import use_case.SavingLocation.SavingLocationInputBoundary;
import use_case.SavingLocation.SavingLocationInputData;

public class SavingLocationController {
    final SavingLocationInputBoundary userSavingLocationInteractor;
    public SavingLocationController(SavingLocationInputBoundary userSavingLocationInteractor){
           this.userSavingLocationInteractor=userSavingLocationInteractor;
    }
    public void execute(String chosenLabel, String locationName, double latitude, double longitude, String mapLink, String filter){
        SavingLocationInputData savingLocationInputData = new SavingLocationInputData(chosenLabel,locationName,latitude,longitude,mapLink,filter);
        userSavingLocationInteractor.execute(savingLocationInputData);
    }
}
