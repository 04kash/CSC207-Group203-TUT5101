package view;

import interface_adapter.apiReturns.ApiController;
import interface_adapter.apiReturns.ApiViewModel;
import interface_adapter.displayingLabels.DisplayingLabelsController;
import interface_adapter.displayingLocations.DisplayingLocationsController;
import org.junit.Before;
import org.junit.Test;
import use_case.apiReturns.ApiInputBoundary;
import use_case.apiReturns.ApiInputData;
import use_case.displayingLabels.DisplayingLabelsInputBoundary;
import use_case.displayingLabels.DisplayingLabelsInputData;
import use_case.displayingLocations.DisplayingLocationsInputBoundary;
import use_case.displayingLocations.DisplayingLocationsInputData;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.assertEquals;

public class SearchViewTest {

    private SearchView searchView;

    private DisplayingLocationsController displayingLocationsController;
    private DisplayingLabelsController displayingLabelsController;
    @Before
    public void setUp() {
        ApiInputBoundary aib = new ApiInputBoundary() {
            @Override
            public void execute(ApiInputData apiInputData) {

            }
        };
        ApiViewModel apiViewModel = new ApiViewModel();
        ApiController apiController = new ApiController(aib);
        DisplayingLocationsInputBoundary dlib = new DisplayingLocationsInputBoundary() {
            @Override
            public void execute(DisplayingLocationsInputData displayingLocationsInputData) {

            }
        };
        DisplayingLabelsInputBoundary dlabelsib = new DisplayingLabelsInputBoundary() {
            @Override
            public void execute(DisplayingLabelsInputData displayingLabelsInputData) {

            }
        };
        this.displayingLocationsController = new DisplayingLocationsController(dlib);
        this.displayingLabelsController = new DisplayingLabelsController(dlabelsib);

        this.searchView = new SearchView(apiViewModel, apiController, displayingLocationsController, displayingLabelsController);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(searchView);
        frame.setSize(500, 300);
        frame.setVisible(true);

        // Ensure the components are properly laid out
        SwingUtilities.invokeLater(() -> {
            frame.pack();
            frame.setLocationRelativeTo(null);
        });
    }

    @Test
    public void testSearchFlow() throws InterruptedException, InvocationTargetException {
        JTextField cityField = findComponent(JTextField.class, "Search a location");
        JButton enterButton = findComponent(JButton.class, "Enter");

        // Set city name and select a filter
        cityField.setText("toronto");

        // Trigger the Enter button
        enterButton.doClick();

        // Check if the controllers were executed
        assertEquals(true, searchView.isApiControllerExecuted());
        assertEquals(true, searchView.isDisplayingLocationsControllerExecuted());
        assertEquals(true, searchView.isDisplayingLabelsControllerExecuted());
    }

    // Helper method to find a component by its type and text
    private <T extends Component> T findComponent(Class<T> type, String text) {
        Component[] components = searchView.getComponents();
        for (Component component : components) {
            if (type.isInstance(component) && component instanceof JComponent) {
                if (component instanceof JLabel && text.equals(((JLabel) component).getText())) {
                    return type.cast(component);
                } else if (component instanceof JButton && text.equals(((JButton) component).getText())) {
                    return type.cast(component);
                } else if (component instanceof JTextField && text.equals(((JTextField) component).getText())) {
                    return type.cast(component);
                } else if (component instanceof JPasswordField && text.equals(new String(((JPasswordField) component).getPassword()))) {
                    return type.cast(component);
                }
            }
        }
        throw new RuntimeException("Component not found: " + type.getSimpleName() + " with text " + text);
    }
}

