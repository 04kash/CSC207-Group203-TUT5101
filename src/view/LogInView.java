package view;

import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LogInView extends JPanel implements ActionListener, PropertyChangeListener {

	public static final String viewName = "log in";
	public SignUp signUp;
	private final LoginViewModel loginViewModel;
	private final LoginController loginController;

	private static final long serialVersionUID = 1L;
	private JTextField usernameField;
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public LogInView(LoginViewModel loginViewModel, LoginController controller) {
		setBackground(new Color(245, 245, 245));
		this.setLayout(null);
		this.loginController = controller;
		this.loginViewModel = loginViewModel;
		this.loginViewModel.addPropertyChangeListener(this);

		JLabel discoverLabel = new JLabel("<html><center><b>Discover City</b></center></html>");
		discoverLabel.setForeground(new Color(0, 153, 102));
		discoverLabel.setFont(new Font("Arial Black", Font.BOLD, 25));
		discoverLabel.setBounds(150, 10, 300, 50); // Adjust the bounds as needed
		add(discoverLabel);

		JLabel descriptionLabel = new JLabel("<html><center>Unlock your city's secrets with Discover City – your pocket-sized guide to hidden gems and local favorites. Explore effortlessly, live adventurously.</center></html>");
		descriptionLabel.setForeground(new Color(51, 153, 102));
		descriptionLabel.setFont(new Font("Tahoma", Font.ITALIC, 14));
		descriptionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		descriptionLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		descriptionLabel.setBounds(20, 30, 460, 60); // Adjust the bounds as needed
		add(descriptionLabel);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setForeground(new Color(51, 153, 102));
		lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel.setBounds(51, 150, 76, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setForeground(new Color(51, 153, 102));
		lblNewLabel_1.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel_1.setBounds(51, 194, 76, 14);
		add(lblNewLabel_1);
		
		usernameField = new JTextField();
		usernameField.setBounds(227, 147, 177, 20);
		add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(227, 191, 177, 20);
		add(passwordField);
		
		JButton logIn = new JButton("Log In");
		logIn.setBackground(new Color(51, 153, 102));
		logIn.setForeground(new Color(245, 245, 245));
		logIn.setBounds(168, 243, 89, 23);
		add(logIn);
		
		JLabel lblNewLabel_2 = new JLabel("If you do not have an account,");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setForeground(new Color(51, 153, 102));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_2.setBounds(61, 289, 315, 14);
		add(lblNewLabel_2);
		
		JButton signUp = new JButton("Sign Up");
		signUp.setBackground(new Color(51, 153, 102));
		signUp.setForeground(new Color(245, 245, 245));
		signUp.setBounds(168, 320, 89, 23);
		add(signUp);

		logIn.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent evt) {
						if (evt.getSource().equals(logIn)) {
							LoginState currentState = loginViewModel.getState();

							loginController.execute(
									currentState.getUsername(),
									currentState.getPassword()
							);

//							ViewManager.showLoggedinView();
						}
					}
				}
		);

		signUp.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						ViewManager.showSignUpView();
					}
				}
		);

		passwordField.addKeyListener(
				new KeyListener() {
					@Override
					public void keyTyped(KeyEvent e) {
						LoginState currentState = loginViewModel.getState();
						currentState.setPassword(passwordField.getText() + e.getKeyChar());
						loginViewModel.setState(currentState);
					}

					@Override
					public void keyPressed(KeyEvent e) {

					}

					@Override
					public void keyReleased(KeyEvent e) {

					}
				}
		);

		usernameField.addKeyListener(
				new KeyListener() {
					@Override
					public void keyTyped(KeyEvent e) {
						LoginState currentState = loginViewModel.getState();
						currentState.setUsername(usernameField.getText() + e.getKeyChar());
						loginViewModel.setState(currentState);
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
		System.out.println("Click " + evt.getActionCommand());
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		LoginState state = (LoginState) evt.getNewValue();
		setFields(state);
	}

	private void setFields(LoginState state) {
		usernameField.setText(state.getUsername());
	}

}
