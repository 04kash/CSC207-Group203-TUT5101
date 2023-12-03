package view;
import entity.CommonUserFactory;
import entity.Label;
import entity.Planner;
import entity.User;
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
import java.util.Collections;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class PlannerViewTest {

    private PlannerView plannerView;

    CommonUserFactory commonUserFactory;
    @Before
    public void setUp() {
        commonUserFactory = new CommonUserFactory();
        User user = commonUserFactory.create("akshaya", "pwd", new Planner());
        DisplayingLabelsInputBoundary dlabelsib = null;
        LocationsFromLabelInputBoundary lflib = null;
        CreateLabelInputBoundary clib = null;
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
        CreateLabelViewModel createLabelViewModel = plannerView.createLabelViewModel;
        DisplayingLabelsViewModel displayingLabelsViewModel = plannerView.displayingLabelsViewModel;
        LocationsFromLabelViewModel locationsFromLabelViewModel = plannerView.locationsFromLabelViewModel;

        SwingUtilities.invokeLater(() -> {
            JButton favorite = findComponent(JButton.class, "favorite");
            favorite.doClick();
        });

        assertEquals("No locations have been saved under this label", locationsFromLabelViewModel.getState().getDisplayMsg());

        // Trigger the "Create Label" button
        SwingUtilities.invokeLater(() -> {
            JButton createLabelButton = findComponent(JButton.class, "Create Label");
            createLabelButton.doClick();
        });

        // Enter label name in the input dialog
        SwingUtilities.invokeLater(() -> {
            String newLabelName = "TestLabel";
            mockInputDialog(newLabelName);
        });

        SwingUtilities.invokeLater(() -> {
            JButton okButton = findComponent(JButton.class, "OK");
            okButton.doClick();
        });

        // Ensure the controller was executed and the message is correct
        // Ensure the controller was executed and the message is correct
        assertEquals("Label saved successfully", createLabelViewModel.getState().getDisplayMsg());

        // Trigger the displayingLabelsController to refresh labels
//        Set<Label> testLabels = Collections.singleton(new Label("TestLabel"));
//        displayingLabelsViewModel.getState().setLabels(testLabels);
//        SwingUtilities.invokeLater(() -> displayingLabelsViewModel.firePropertyChanged());

        // Ensure the new label button is added
        JButton testLabelButton = findComponent(JButton.class, "TestLabel");
        assertEquals("TestLabel", testLabelButton.getText());

        // Trigger the "TestLabel" button to show locations
        SwingUtilities.invokeLater(() -> testLabelButton.doClick());

        // Ensure the controller was executed and the message is correct
        assertEquals("Locations from TestLabel: [Location1, Location2]", locationsFromLabelViewModel.getState().getDisplayMsg());
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
}

