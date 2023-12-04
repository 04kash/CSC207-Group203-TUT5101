package view;

import interface_adapter.CreateLabel.CreateLabelController;
import interface_adapter.CreateLabel.CreateLabelViewModel;
import interface_adapter.LocationsFromLabel.LocationsFromLabelController;
import interface_adapter.LocationsFromLabel.LocationsFromLabelViewModel;
import interface_adapter.displayingLabels.DisplayingLabelsController;
import interface_adapter.displayingLabels.DisplayingLabelsViewModel;
import org.junit.Before;
import org.junit.Test;
import use_case.CreateLabel.CreateLabelInputBoundary;
import use_case.CreateLabel.CreateLabelInputData;
import use_case.LocationsFromLabel.LocationsFromLabelInputBoundary;
import use_case.LocationsFromLabel.LocationsFromLabelInputData;
import use_case.displayingLabels.DisplayingLabelsInputBoundary;
import use_case.displayingLabels.DisplayingLabelsInputData;

import javax.swing.*;
import java.awt.*;

import static org.junit.Assert.assertEquals;

public class PlannerViewTest {

    private PlannerView plannerView;

    @Before
    public void setUp() {
        DisplayingLabelsInputBoundary dlabelsib = new DisplayingLabelsInputBoundary() {
            @Override
            public void execute(DisplayingLabelsInputData displayingLabelsInputData) {

            }
        };
        LocationsFromLabelInputBoundary lflib = new LocationsFromLabelInputBoundary() {
            @Override
            public void execute(LocationsFromLabelInputData locationsFromLabelInputData) {

            }
        };
        CreateLabelInputBoundary clib = new CreateLabelInputBoundary() {
            @Override
            public void execute(CreateLabelInputData createLabelInputData) {

            }
        };
        DisplayingLabelsViewModel displayingLabelsViewModel = new DisplayingLabelsViewModel();
        DisplayingLabelsController displayingLabelsController = new DisplayingLabelsController(dlabelsib);
        LocationsFromLabelViewModel locationsFromLabelViewModel = new LocationsFromLabelViewModel();
        LocationsFromLabelController locationsFromLabelController = new LocationsFromLabelController(lflib);
        CreateLabelViewModel createLabelViewModel = new CreateLabelViewModel();
        CreateLabelController createLabelController = new CreateLabelController(clib);

        this.plannerView = new PlannerView(
                displayingLabelsViewModel,
                displayingLabelsController,
                locationsFromLabelViewModel,
                locationsFromLabelController,
                createLabelController,
                createLabelViewModel
        );

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(plannerView);
        frame.setSize(500, 300);
        frame.setVisible(true);

        // Ensure the components are properly laid out
        SwingUtilities.invokeLater(() -> {
            frame.pack();
            frame.setLocationRelativeTo(null);
        });
    }

    @Test
    public void testCreateLabelAndShowLocations() {
        // Trigger the "Create Label" button
        JPanel topPanel = (JPanel) plannerView.getComponent(0);
        JButton createLabelButton = (JButton) topPanel.getComponent(0);
        createLabelButton.doClick();

        // Set the input value for the input dialog
        JOptionPaneWrapper.setInputValue("Test Label");

        // Click the "OK" button
        JButton okButton = (JButton) plannerView.getOkButtonReference();
        okButton.doClick();

        // Check if the label was saved successfully
//        assertEquals("Label saved successfully", plannerView.createLabelViewModel.getState().getDisplayMsg());
    }


    // Helper method to find a component by its type and text
    private <T extends Component> T findComponent(Class<T> type, String buttonText) {
        Component[] components = plannerView.getComponents();
        for (Component component : components) {
            if (type.isInstance(component) && component instanceof JComponent) {
                JComponent jComponent = (JComponent) component;
                if (buttonText.equals(jComponent.getClientProperty("AccessibleName"))) {
                    return type.cast(component);
                }
            }
        }
        throw new RuntimeException("Component not found: " + type.getSimpleName() + " with text " + buttonText);
    }

    // Mock the input dialog to simulate user input
    private void mockInputDialog(String input) {
        UIManager.put("OptionPane.showInputDialog", new MockOptionPane(input));
    }

    // MockOptionPane class to simulate user input in showInputDialog
    private static class MockOptionPane extends JOptionPane {
        private final String input;

        MockOptionPane(String input) {
            this.input = input;
        }
    }

    public class JOptionPaneWrapper {
        private static String inputValue;

        public static String showInputDialog(Object message) {
            return inputValue;
        }

        public static void setInputValue(String value) {
            inputValue = value;
        }
    }
}

