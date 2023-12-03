package entity;

import entity.Label;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LabelTest {
    private Label label;

    @BeforeEach
    void init() {
        Label label = new Label("Hotels");
        this.label = label;
    }

    @Test
    void getTitle() {
        assertEquals("Hotels", label.getTitle());
    }
}