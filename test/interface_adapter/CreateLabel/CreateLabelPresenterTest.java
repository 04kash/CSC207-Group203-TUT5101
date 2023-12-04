package interface_adapter.CreateLabel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateLabelPresenterTest {
    CreateLabelPresenter createLabelPresenter;
    CreateLabelViewModel createLabelViewModel;

    @Test
    void prepareSuccessView() {
        createLabelViewModel = new CreateLabelViewModel();
        createLabelPresenter= new CreateLabelPresenter(createLabelViewModel);
        createLabelPresenter.prepareSuccessView("Label saved");
        assertEquals("Label saved",createLabelViewModel.getState().getDisplayMsg());
    }

    @Test
    void prepareFailView() {
        createLabelViewModel = new CreateLabelViewModel();
        createLabelPresenter= new CreateLabelPresenter(createLabelViewModel);
        createLabelPresenter.prepareFailView("Error");
        assertEquals("Error",createLabelViewModel.getState().getDisplayMsg());
    }
}