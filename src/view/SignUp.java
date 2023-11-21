package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class SignUp extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public SignUp() {
		this.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("username:");
		lblNewLabel.setBounds(81, 79, 97, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("password:");
		lblNewLabel_1.setBounds(81, 132, 97, 14);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(200, 76, 140, 20);
		add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(200, 129, 140, 20);
		add(passwordField);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.setBounds(177, 209, 89, 23);
		add(btnNewButton);

	}
}
