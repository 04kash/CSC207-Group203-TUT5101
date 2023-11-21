package view;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;

public class LoggedInView extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public LoggedInView() {
		setBackground(new Color(204, 255, 255));
		this.setLayout(null);
		
		JButton btnNewButton = new JButton("Saved Locations");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(289, 11, 151, 23);
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Location:");
		lblNewLabel.setBounds(76, 74, 80, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Filter:");
		lblNewLabel_1.setBounds(76, 116, 48, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Proximity:");
		lblNewLabel_3.setBounds(76, 154, 59, 14);
		add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(154, 71, 96, 20);
		add(textField);
		textField.setColumns(10);
		
		JList list = new JList();
		list.setBounds(199, 131, 0, 0);
		add(list);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"banks ", "foods", "shops", "transport"}));
		comboBox.setBounds(154, 112, 96, 22);
		add(comboBox);
		
		textField_1 = new JTextField();
		textField_1.setBounds(154, 151, 96, 20);
		add(textField_1);
		textField_1.setColumns(10);
	}
}
