package use_case.displayingLabels;

import data_access.InMemoryDisplayingLabels;
import data_access.JsonDataAccessObject;
import entity.CommonUserFactory;
import entity.Label;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.displayingLabels.*;
import use_case.signup.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;
import static org.junit.Assert.*;

public class DisplayingLabelsInteractorTest {

    DisplayingLabelsUserDataAccessInterface Repository;

    @Test
    void successTest() {
        Repository = new InMemoryDisplayingLabels();
        DisplayingLabelsOutputBoundary successPresenter = new DisplayingLabelsOutputBoundary() {
            @Override
            public void prepareSuccessView(DisplayingLabelsOutputData response) {
                assertNotNull(response.getLabels());
                Set<Label> labels = response.getLabels();
                ArrayList<String> labelString = new ArrayList<>();
                for (Label label : labels) {
                    labelString.add(label.getTitle());
                }
                assertEquals("favorite", labelString.get(0));
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected");
            }
        };
        DisplayingLabelsInputData inputData = new DisplayingLabelsInputData();
        DisplayingLabelsInputBoundary interactor = new DisplayingLabelsInteractor(Repository, successPresenter);
        interactor.execute(inputData);
    }
}
