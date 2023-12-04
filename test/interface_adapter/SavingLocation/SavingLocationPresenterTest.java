package interface_adapter.SavingLocation;

import interface_adapter.ViewManagerModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SavingLocationPresenterTest {
    SavingLocationPresenter savingLocationPresenter;
    SavingLocationViewModel savingLocationViewModel;
   @BeforeEach
   void unit(){
       savingLocationViewModel = new SavingLocationViewModel();
       ViewManagerModel viewManagerModel = new ViewManagerModel();
       savingLocationPresenter = new SavingLocationPresenter(savingLocationViewModel,viewManagerModel);
   }
    @Test
    void prepareSuccessView() {
       savingLocationPresenter.prepareSuccessView("Location saved.");
       assertEquals("Location saved.",savingLocationViewModel.getState().getDisplayMsg());
    }

    @Test
    void prepareFailView() {
        savingLocationPresenter.prepareFailView("Location not saved.");
        assertEquals("Location not saved.",savingLocationViewModel.getState().getDisplayMsg());
    }
}