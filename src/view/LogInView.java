package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LogInView extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public LogInView() {
		this.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("username:");
		lblNewLabel.setBounds(51, 81, 76, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("password:");
		lblNewLabel_1.setBounds(51, 125, 76, 14);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(227, 78, 177, 20);
		add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(227, 122, 177, 20);
		add(passwordField);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(168, 174, 89, 23);
		add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("If you do not have an account,");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_2.setBounds(61, 220, 315, 14);
		add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("Sign Up");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(168, 251, 89, 23);
		add(btnNewButton_1);
	}
}
