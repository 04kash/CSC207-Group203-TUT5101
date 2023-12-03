package interface_adapter.SavingLocation;

public class SavingLocationState {
    private String displayMsg=null;
    public SavingLocationState(SavingLocationState copy){
        displayMsg = copy.displayMsg;
    }
    SavingLocationState(){};

   public String getDisplayMsg() {
        return displayMsg;
}

    public void setDisplayMsg(String displayMsg) {
        this.displayMsg = displayMsg;
    }
}
