package view;

import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupState;
import interface_adapter.signup.SignupViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SignUp extends JPanel implements ActionListener, PropertyChangeListener {

	public static final String viewName = "sign up";

	private final SignupViewModel signupViewModel;
	private final SignupController signupController;
	private static final long serialVersionUID = 1L;
	private JTextField usernameField;
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public SignUp(SignupController controller, SignupViewModel signupViewModel) {
		this.setLayout(null);
		this.signupViewModel = signupViewModel;
		this.signupController = controller;
		signupViewModel.addPropertyChangeListener(this);
		
		JLabel lblNewLabel = new JLabel("username:");
		lblNewLabel.setBounds(81, 79, 97, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("password:");
		lblNewLabel_1.setBounds(81, 132, 97, 14);
		add(lblNewLabel_1);
		
		usernameField = new JTextField();
		usernameField.setBounds(200, 76, 140, 20);
		add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(200, 129, 140, 20);
		add(passwordField);
		
		JButton signUp = new JButton("Sign Up");
		signUp.setBounds(177, 209, 89, 23);
		add(signUp);

		signUp.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent evt) {
						if (evt.getSource().equals(signUp)) {
							SignupState currentState = signupViewModel.getState();

							signupController.execute(
									currentState.getUsername(),
									currentState.getPassword()
							);
						}
					}
				}
		);

		usernameField.addKeyListener(
				new KeyListener() {
					@Override
					public void keyTyped(KeyEvent e) {
						SignupState currentState = signupViewModel.getState();
						String text = usernameField.getText() + e.getKeyChar();
						currentState.setUsername(text);
						signupViewModel.setState(currentState);
					}

					@Override
					public void keyPressed(KeyEvent e) {

					}

					@Override
					public void keyReleased(KeyEvent e) {

					}
				}
		);

		passwordField.addKeyListener(
				new KeyListener() {
					@Override
					public void keyTyped(KeyEvent e) {
						SignupState currentState = signupViewModel.getState();
						currentState.setPassword(passwordField.getText() + e.getKeyChar());
						signupViewModel.setState(currentState);
					}

					@Override
					public void keyPressed(KeyEvent e) {

					}

					@Override
					public void keyReleased(KeyEvent e) {

					}
				}
		);

	}

	public void actionPerformed(ActionEvent evt) {
		JOptionPane.showConfirmDialog(this, "Cancel not implemented yet.");
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		SignupState state = (SignupState) evt.getNewValue();
		if (state.getUsernameError() != null) {
			JOptionPane.showMessageDialog(this, state.getUsernameError());
		}
	}
}
