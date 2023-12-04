package view;

import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupState;
import interface_adapter.signup.SignupViewModel;

import javax.swing.*;
import java.awt.*;
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
		setForeground(UIManager.getColor("ColorChooser.swatchesDefaultRecentColor"));
		//setBackground(new Color(245, 245, 245));
		this.setLayout(null);
		this.signupViewModel = signupViewModel;
		this.signupController = controller;
		signupViewModel.addPropertyChangeListener(this);

		JLabel discoverLabel = new JLabel("<html><center><b>Discover City</b></center></html>");
		discoverLabel.setForeground(new Color(51, 153, 102));
		discoverLabel.setFont(new Font("Arial Black", Font.BOLD, 25));
		discoverLabel.setBounds(150, 10, 300, 50); // Adjust the bounds as needed
		add(discoverLabel);

		JLabel descriptionLabel = new JLabel("<html><center>Unlock your city's secrets with Discover City – your pocket-sized guide to hidden gems and local favorites. Explore effortlessly, live adventurously.</center></html>");
		descriptionLabel.setFont(new Font("Tahoma", Font.ITALIC, 14));
		descriptionLabel.setForeground(new Color(51, 153, 102));
		descriptionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		descriptionLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		descriptionLabel.setBounds(20, 30, 460, 60); // Adjust the bounds as needed
		add(descriptionLabel);
		
		JLabel username = new JLabel("Username:");
		username.setForeground(new Color(51, 153, 102));
		username.setFont(new Font("Arial Narrow", Font.PLAIN, 15));
		username.setBounds(81, 129, 97, 14);
		add(username);
		
		JLabel password = new JLabel("Password:");
		password.setFont(new Font("Arial Narrow", Font.PLAIN, 15));
		password.setForeground(new Color(51, 153, 102));
		password.setBounds(81, 182, 97, 14);
		add(password);
		
		usernameField = new JTextField();
		usernameField.setBounds(200, 126, 140, 20);
		add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(200, 179, 140, 20);
		add(passwordField);
		
		JButton signUp = new JButton("Sign Up");
		signUp.setBackground(new Color(51, 153, 102));
		//signUp.setForeground(new Color(245, 245, 245));
		signUp.setBounds(60, 230, 139, 23);
		add(signUp);

		JButton back = new JButton("Back to LogIn");
		//back.setForeground(new Color(245, 245, 245));
		back.setBackground(new Color(51, 153, 102));
		back.setBounds(250, 230, 139, 23);
		add(back);
		back.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if(e.getSource().equals(back)){
							ViewManager.showLoginView();
						}
					}
				}

		);

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
