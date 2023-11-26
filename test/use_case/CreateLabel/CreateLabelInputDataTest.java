package use_case.CreateLabel;

import entity.Planner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import entity.User;
import entity.Label;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CreateLabelInputDataTest {
    private User user;
    private Planner planner;
    private Label label;

    @BeforeEach
    void init(){
        ArrayList locations = new ArrayList();
        locations.add("McDon");
        planner.setLabel(label,locations);
        Planner planner = new Planner();
        User user = new User("rileyfewer", "1234riley4321", planner);
    }

    @Test
    void getChosenLabel() {
        assertEquals(label, planner.getLabel());
    }

    @Test
    void getPassword() {
        assertEquals("1234riley4321", user.getPassword());
    }

    @Test
    void getUsername() {
        assertEquals("rileyfewer", user.getUsername());
    }
}