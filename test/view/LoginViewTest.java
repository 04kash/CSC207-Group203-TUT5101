package view;

import interface_adapter.login.LoginController;
import interface_adapter.login.LoginViewModel;
import org.junit.Assert;
import use_case.login.LoginInputBoundary;

import javax.swing.*;
import java.awt.event.KeyEvent;

import static java.lang.Thread.sleep;

public class LoginViewTest {
    @org.junit.Test
    public void testLoginView() {

        // create the UI; note, we don't make a real LoginInputBoundary,
        // since we don't need it for this test.
        LoginInputBoundary lib = null;
        LoginController controller = new LoginController(lib);
        LoginViewModel viewModel = new LoginViewModel();
        JPanel loginView = new LogInView(viewModel, controller);
        JFrame jf = new JFrame();
        jf.setContentPane(loginView);
        jf.pack();
        jf.setVisible(true);

        // get a reference to the first password field
//        JLabel panel = (JLabel) loginView.getComponent(2);
        JPasswordField pwdField = (JPasswordField) loginView.getComponent(5);

        // create and dispatch KeyEvents to the UI
        KeyEvent event1 = new KeyEvent(
                pwdField,
                KeyEvent.KEY_TYPED,
                System.currentTimeMillis(),
                0,
                KeyEvent.VK_UNDEFINED,
                'p');
        pwdField.dispatchEvent(event1);

        /*
        // pause execution for a second
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // print the current values the password field and view-model hold
        System.out.println("field 1: " + new String(pwdField.getPassword()));
        System.out.println("view-model: " + viewModel.getState().getPassword());
        */
        // move to the right in the password field, otherwise the event
        // will type the character as the first character instead of the last!
        KeyEvent eventRight = new KeyEvent(
                pwdField,
                KeyEvent.KEY_PRESSED,
                System.currentTimeMillis(),
                0,
                KeyEvent.VK_RIGHT,
                KeyEvent.CHAR_UNDEFINED
        );
        pwdField.dispatchEvent(eventRight);

        // type a second character
        KeyEvent event2 = new KeyEvent(
                pwdField,
                KeyEvent.KEY_TYPED,
                System.currentTimeMillis(),
                0,
                KeyEvent.VK_UNDEFINED,
                'a');
        pwdField.dispatchEvent(event2);


        // pause execution for a seconds
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // print the current values the password field and view-model hold
        System.out.println("field 1: " + new String(pwdField.getPassword()));
        System.out.println("view-model: " + viewModel.getState().getPassword());

        // assert that the values are as expected.
        Assert.assertEquals("pa", new String(pwdField.getPassword()));
        Assert.assertEquals("pa", viewModel.getState().getPassword());
    }
}
