package data_access;

import entity.CommonUserFactory;
import entity.Coordinate;
import entity.Label;
import entity.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.signup.*;

import java.io.IOException;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;
import static org.junit.jupiter.api.Assertions.*;

class JsonDataAccessObjectTest {
    JsonDataAccessObject jsonDataAccessObject;
    @BeforeEach
    void init(){
        try {
            jsonDataAccessObject = new JsonDataAccessObject("DAOTest.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        SignupInputData inputData = new SignupInputData("Kashish", "password");
        SignupUserDataAccessInterface userRepository = jsonDataAccessObject;
        SignupOutputBoundary successPresenter = new SignupOutputBoundary() {
            @Override
            public void prepareSuccessView(SignupOutputData user) {

            }

            @Override
            public void prepareFailView(String error) {

            }
        };
        SignupInputBoundary interactor = new SignupInteractor(userRepository, successPresenter, new CommonUserFactory());
        interactor.execute(inputData);

        jsonDataAccessObject.addLabelToPlanner("Kashish",new Label("Food"));
        jsonDataAccessObject.addLabelToPlanner("Kashish",new Label("shops"));
        jsonDataAccessObject.addLocation("Kashish",new Location("The Abbot Shop",new Coordinate(-90.4134750366211,20.70365524291992),"node/7565662674","foods"),new Label("shops"));
        jsonDataAccessObject.setCurrentUser("Kashish");
    }

    @Test
    void addLocation() {
        jsonDataAccessObject.addLocation("Kashish",new Location("The Abbot",new Coordinate(-79.4134750366211,43.70365524291992),"node/7567822674","foods"),new Label("Food"));
       assertEquals("The Abbot",jsonDataAccessObject.get("Kashish").getPlanner().getLocations(new Label("Food")).get(0).getName());
    }

    @Test
    void locationExists() {
         assertEquals(true,jsonDataAccessObject.locationExists("Kashish",new Location("The Abbot Shop",new Coordinate(-90.4134750366211,20.70365524291992),"node/7565662674","foods")));
         assertEquals(false,jsonDataAccessObject.locationExists("Kashish",new Location("The Alley",new Coordinate(-100.4134750366211,70.70365524291992),"node/7565662674","foods")));
    }

    @Test
    void addLabelToPlanner() {
        jsonDataAccessObject.addLabelToPlanner("Kashish",new Label("Gardens"));
        Label label = null;
        for(Label l: jsonDataAccessObject.get("Kashish").getPlanner().getLabel()){
            if(l.getTitle().equals("Gardens")){
                label = l;
            }
        }
        assertEquals(label.getTitle(),"Gardens");

    }

    @Test
    void getLocationsFromLabel() {
        assertEquals(new ArrayList<>(),jsonDataAccessObject.getLocationsFromLabel("Kashish",new Label("favorite")));
        assertEquals(new ArrayList<>(),jsonDataAccessObject.getLocationsFromLabel("Kashish",new Label("malls")));
    }

    @Test
    void labelExists() {
        assertEquals(true, jsonDataAccessObject.labelExists("Kashish",new Label("favorite")));
        assertEquals(false,jsonDataAccessObject.labelExists("Kashish",new Label("sweets")));
    }

    @Test
    void labelIsEmpty() {
        assertEquals(true,jsonDataAccessObject.labelIsEmpty("Kashish",new Label("favorite")));
        assertEquals(false,jsonDataAccessObject.labelIsEmpty("Kashish",new Label("shops")));
    }

    @Test
    void gerCurrentUser(){
        assertEquals("Kashish",jsonDataAccessObject.getCurrentUser());
    }

}