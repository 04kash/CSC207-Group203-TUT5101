package view;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;

public class LocationView extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public LocationView() {
		this.setLayout(null);
		
		JButton btnNewButton = new JButton("Go to Planner");
		btnNewButton.setBounds(596, 11, 160, 23);
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Suggested Places:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(37, -3, 279, 39);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("1.");
		lblNewLabel_1.setBounds(39, 40, 17, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Location1");
		lblNewLabel_2.setBounds(66, 40, 708, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Location1");
		lblNewLabel_2_1.setBounds(66, 83, 690, 14);
		add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Link to OpenStreetMap:");
		lblNewLabel_2_2.setBounds(66, 108, 212, 14);
		add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("2.");
		lblNewLabel_1_1.setBounds(39, 83, 17, 14);
		add(lblNewLabel_1_1);
		
		JButton btnNewButton_1 = new JButton("Save Selected Location");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(208, 689, 197, 23);
		add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(288, 58, 486, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("7.");
		lblNewLabel_1_1_1.setBounds(39, 347, 17, 14);
		add(lblNewLabel_1_1_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"L1", "L2", "L3", "L4", "L5", "L6", "L7", "L8", "L9", "L10"}));
		comboBox.setBounds(353, 600, 351, 28);
		add(comboBox);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("3.");
		lblNewLabel_1_1_1_1.setBounds(39, 129, 17, 14);
		add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("4.");
		lblNewLabel_1_1_1_2.setBounds(39, 181, 17, 14);
		add(lblNewLabel_1_1_1_2);
		
		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("5.");
		lblNewLabel_1_1_1_2_1.setBounds(39, 238, 17, 14);
		add(lblNewLabel_1_1_1_2_1);
		
		JLabel lblNewLabel_1_1_1_2_2 = new JLabel("6.");
		lblNewLabel_1_1_1_2_2.setBounds(39, 294, 17, 14);
		add(lblNewLabel_1_1_1_2_2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Link to OpenStreetMap:");
		lblNewLabel_2_2_1.setBounds(66, 58, 212, 14);
		add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_1_1_1_3 = new JLabel("8.");
		lblNewLabel_1_1_1_3.setBounds(39, 396, 17, 14);
		add(lblNewLabel_1_1_1_3);
		
		JLabel lblNewLabel_1_1_1_3_1 = new JLabel("9.");
		lblNewLabel_1_1_1_3_1.setBounds(39, 454, 17, 14);
		add(lblNewLabel_1_1_1_3_1);
		
		JLabel lblNewLabel_1_1_1_3_2 = new JLabel("10.");
		lblNewLabel_1_1_1_3_2.setBounds(39, 519, 17, 14);
		add(lblNewLabel_1_1_1_3_2);
		
		JLabel lblNewLabel_4 = new JLabel("Choose a Location:");
		lblNewLabel_4.setBounds(93, 607, 117, 14);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Enter a Label Name:");
		lblNewLabel_5.setBounds(93, 651, 136, 14);
		add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setBounds(353, 648, 351, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Location1");
		lblNewLabel_2_1_1.setBounds(66, 133, 690, 14);
		add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Location1");
		lblNewLabel_2_1_2.setBounds(66, 181, 690, 14);
		add(lblNewLabel_2_1_2);
		
		JLabel lblNewLabel_2_1_3 = new JLabel("Location1");
		lblNewLabel_2_1_3.setBounds(66, 238, 690, 14);
		add(lblNewLabel_2_1_3);
		
		JLabel lblNewLabel_2_1_4 = new JLabel("Location1");
		lblNewLabel_2_1_4.setBounds(66, 294, 708, 14);
		add(lblNewLabel_2_1_4);
		
		JLabel lblNewLabel_2_1_5 = new JLabel("Location1");
		lblNewLabel_2_1_5.setBounds(66, 347, 690, 14);
		add(lblNewLabel_2_1_5);
		
		JLabel lblNewLabel_2_1_6 = new JLabel("Location1");
		lblNewLabel_2_1_6.setBounds(66, 396, 708, 14);
		add(lblNewLabel_2_1_6);
		
		JLabel lblNewLabel_2_1_7 = new JLabel("Location1");
		lblNewLabel_2_1_7.setBounds(66, 454, 708, 14);
		add(lblNewLabel_2_1_7);
		
		JLabel lblNewLabel_2_1_8 = new JLabel("Location1");
		lblNewLabel_2_1_8.setBounds(66, 519, 708, 14);
		add(lblNewLabel_2_1_8);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("Link to OpenStreetMap:");
		lblNewLabel_2_2_2.setBounds(66, 158, 212, 14);
		add(lblNewLabel_2_2_2);
		
		JLabel lblNewLabel_2_2_3 = new JLabel("Link to OpenStreetMap:");
		lblNewLabel_2_2_3.setBounds(66, 206, 212, 14);
		add(lblNewLabel_2_2_3);
		
		JLabel lblNewLabel_2_2_4 = new JLabel("Link to OpenStreetMap:");
		lblNewLabel_2_2_4.setBounds(66, 263, 212, 14);
		add(lblNewLabel_2_2_4);
		
		JLabel lblNewLabel_2_2_5 = new JLabel("Link to OpenStreetMap:");
		lblNewLabel_2_2_5.setBounds(66, 319, 212, 14);
		add(lblNewLabel_2_2_5);
		
		JLabel lblNewLabel_2_2_6 = new JLabel("Link to OpenStreetMap:");
		lblNewLabel_2_2_6.setBounds(66, 371, 212, 14);
		add(lblNewLabel_2_2_6);
		
		JLabel lblNewLabel_2_2_7 = new JLabel("Link to OpenStreetMap:");
		lblNewLabel_2_2_7.setBounds(66, 421, 212, 14);
		add(lblNewLabel_2_2_7);
		
		JLabel lblNewLabel_2_2_8 = new JLabel("Link to OpenStreetMap:");
		lblNewLabel_2_2_8.setBounds(66, 479, 212, 14);
		add(lblNewLabel_2_2_8);
		
		JLabel lblNewLabel_2_2_9 = new JLabel("Link to OpenStreetMap:");
		lblNewLabel_2_2_9.setBounds(66, 544, 212, 14);
		add(lblNewLabel_2_2_9);
		
		JLabel lblNewLabel_3_1 = new JLabel("New label");
		lblNewLabel_3_1.setBounds(289, 106, 495, 14);
		add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("New label");
		lblNewLabel_3_2.setBounds(288, 158, 496, 14);
		add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("New label");
		lblNewLabel_3_3.setBounds(288, 206, 486, 14);
		add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_4 = new JLabel("New label");
		lblNewLabel_3_4.setBounds(288, 263, 486, 14);
		add(lblNewLabel_3_4);
		
		JLabel lblNewLabel_3_5 = new JLabel("New label");
		lblNewLabel_3_5.setBounds(288, 319, 486, 14);
		add(lblNewLabel_3_5);
		
		JLabel lblNewLabel_3_6 = new JLabel("New label");
		lblNewLabel_3_6.setBounds(288, 371, 486, 14);
		add(lblNewLabel_3_6);
		
		JLabel lblNewLabel_3_7 = new JLabel("New label");
		lblNewLabel_3_7.setBounds(288, 421, 486, 14);
		add(lblNewLabel_3_7);
		
		JLabel lblNewLabel_3_8 = new JLabel("New label");
		lblNewLabel_3_8.setBounds(288, 479, 486, 14);
		add(lblNewLabel_3_8);
		
		JLabel lblNewLabel_3_9 = new JLabel("New label");
		lblNewLabel_3_9.setBounds(288, 544, 486, 14);
		add(lblNewLabel_3_9);

	}
}
