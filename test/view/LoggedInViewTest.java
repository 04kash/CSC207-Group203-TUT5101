package view;

import interface_adapter.ViewManagerModel;
import interface_adapter.ViewModel;
import interface_adapter.displayingLabels.DisplayingLabelsController;
import org.junit.Assert;
import org.junit.Test;
import use_case.displayingLabels.DisplayingLabelsInputBoundary;
import use_case.displayingLabels.DisplayingLabelsInputData;
import javax.swing.*;
import java.awt.event.KeyEvent;
import static java.lang.Thread.sleep;
public class LoggedInViewTest {
    @Test
    public void testLoggedInView() {
        DisplayingLabelsInputBoundary dlib = new DisplayingLabelsInputBoundary() {
            @Override
            public void execute(DisplayingLabelsInputData displayingLabelsInputData) {
            }
        };
        DisplayingLabelsController dlc = new DisplayingLabelsController(dlib);
        ViewManagerModel vmm = new ViewManagerModel();
        LoggedInView loggedInView = new LoggedInView(dlc);
        JFrame jf = new JFrame();
        jf.setSize(800, 900);
        jf.setContentPane(loggedInView);
        // jf.pack();

        jf.setVisible(true);
        // JPasswordField pwdField = (JPasswordField) loggedInView.getComponent(5);

        JButton locationSearchButton = (JButton) loggedInView.getComponent(0);
        JButton plannerButton = (JButton) loggedInView.getComponent(1);
        JButton logOutButton = (JButton) loggedInView.getComponent(2);

        // Simulate a click on the "Search New Locations" button
//        locationSearchButton.doClick();

        // Assert that the expected view change occurred
//        Assert.assertTrue(loggedInView.isChangeInView());
//        Assert.assertEquals(vmm.getActiveView(), "search");
//        Assert.assertEquals(vmm.getActiveView(), "search");

        // Simulate a click on the "View Your Planner" button
//        plannerButton.doClick();
        // Assert that the expected view change occurred
//        Assert.assertTrue(loggedInView.isChangeInView());
//        Assert.assertEquals(vmm.getActiveView(), "planner");

        // Simulate a click on the "Log out" button
//        logOutButton.doClick();
        // Assert that the expected view change occurred
//        Assert.assertTrue(loggedInView.isChangeInView());
//        Assert.assertEquals(vmm.getActiveView(), "log in");
    }
}