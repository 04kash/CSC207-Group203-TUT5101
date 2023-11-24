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

public class SearchView extends JPanel {

	public static final String viewName = "search";
	private static final long serialVersionUID = 1L;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public SearchView() {
		setBackground(new Color(204, 255, 255));
		this.setLayout(null);
		
		JButton btnNewButton = new JButton("Go to Homepage");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setBounds(289, 11, 151, 23);
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Enter the City you want to explore:");
		lblNewLabel.setBounds(10, 114, 189, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Choose a filter:");
		lblNewLabel_1.setBounds(10, 163, 123, 14);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(229, 111, 172, 20);
		add(textField);
		textField.setColumns(10);
		
		JList list = new JList();
		list.setBounds(199, 131, 0, 0);
		add(list);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"interesting_places", "banks ", "foods", "shops", "transport"}));
		comboBox.setBounds(229, 159, 172, 22);
		add(comboBox);
		
		JButton btnNewButton_1 = new JButton("Enter");
		btnNewButton_1.setBounds(188, 227, 89, 23);
		add(btnNewButton_1);
	}
}
