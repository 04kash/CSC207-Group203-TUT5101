package interface_adapter.displayingLabels;

import entity.Planner;
import interface_adapter.ViewManagerModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.displayingLabels.DisplayingLabelsOutputData;

import static org.junit.jupiter.api.Assertions.*;

class DisplayingLabelsPresenterTest {
    DisplayingLabelsPresenter displayingLabelsPresenter;
    DisplayingLabelsViewModel displayingLabelsViewModel;
    @BeforeEach
    void unit(){
        displayingLabelsViewModel = new DisplayingLabelsViewModel();
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        displayingLabelsPresenter = new DisplayingLabelsPresenter(displayingLabelsViewModel,viewManagerModel);
    }

    @Test
    void prepareSuccessView() {
        Planner planner = new Planner();
        DisplayingLabelsOutputData displayingLabelsOutputData = new DisplayingLabelsOutputData(planner.getLabel(),false);
        displayingLabelsPresenter.prepareSuccessView(displayingLabelsOutputData);
        assertEquals(planner.getLabel(), DisplayingLabelsState.getLabels());
    }

    @Test
    void prepareFailView() {
        displayingLabelsPresenter.prepareFailView("Error");
        assertEquals("Error",displayingLabelsViewModel.getState().getLabelError());
    }
}