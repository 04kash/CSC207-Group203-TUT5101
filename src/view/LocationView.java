package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LocationView extends JPanel {
	/**
	 * Create the panel.
	 */
	public LocationView() {
		this.setLayout(null);

		JButton btnNewButton_1 = new JButton("Save A Location");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showSaveLocationDialog();
			}
		});
		btnNewButton_1.setBounds(37, 11, 197, 23);
		add(btnNewButton_1);


		JButton btnNewButton = new JButton("Go to HomePage");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(465, 11, 160, 23);
		add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Suggested Places:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(270, 11, 279, 39);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("1.");
		lblNewLabel_1.setBounds(26, 45, 17, 14);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Location1");
		lblNewLabel_2.setBounds(66, 45, 708, 14);
		add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Location2");
		lblNewLabel_2_1.setBounds(66, 105, 690, 14);
		add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_2 = new JLabel("Link to OpenStreetMap:");
		lblNewLabel_2_2.setBounds(66, 141, 212, 14);
		add(lblNewLabel_2_2);

		JLabel lblNewLabel_1_1 = new JLabel("2.");
		lblNewLabel_1_1.setBounds(26, 105, 17, 14);
		add(lblNewLabel_1_1);

		JLabel lblNewLabel_3 = new JLabel("Link1");
		lblNewLabel_3.setBounds(288, 80, 486, 14);
		add(lblNewLabel_3);

		JLabel lblNewLabel_1_1_1 = new JLabel("7.");
		lblNewLabel_1_1_1.setBounds(26, 438, 17, 14);
		add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("3.");
		lblNewLabel_1_1_1_1.setBounds(26, 166, 17, 14);
		add(lblNewLabel_1_1_1_1);

		JLabel lblNewLabel_1_1_1_2 = new JLabel("4.");
		lblNewLabel_1_1_1_2.setBounds(26, 234, 17, 14);
		add(lblNewLabel_1_1_1_2);

		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("5.");
		lblNewLabel_1_1_1_2_1.setBounds(26, 296, 17, 14);
		add(lblNewLabel_1_1_1_2_1);

		JLabel lblNewLabel_1_1_1_2_2 = new JLabel("6.");
		lblNewLabel_1_1_1_2_2.setBounds(26, 366, 17, 14);
		add(lblNewLabel_1_1_1_2_2);

		JLabel lblNewLabel_2_2_1 = new JLabel("Link to OpenStreetMap:");
		lblNewLabel_2_2_1.setBounds(66, 80, 212, 14);
		add(lblNewLabel_2_2_1);

		JLabel lblNewLabel_1_1_1_3 = new JLabel("8.");
		lblNewLabel_1_1_1_3.setBounds(26, 504, 17, 14);
		add(lblNewLabel_1_1_1_3);

		JLabel lblNewLabel_1_1_1_3_1 = new JLabel("9.");
		lblNewLabel_1_1_1_3_1.setBounds(26, 575, 17, 14);
		add(lblNewLabel_1_1_1_3_1);

		JLabel lblNewLabel_1_1_1_3_2 = new JLabel("10.");
		lblNewLabel_1_1_1_3_2.setBounds(26, 649, 17, 14);
		add(lblNewLabel_1_1_1_3_2);

		JLabel lblNewLabel_2_1_1 = new JLabel("Location3");
		lblNewLabel_2_1_1.setBounds(66, 166, 690, 14);
		add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_2_1_2 = new JLabel("Location4");
		lblNewLabel_2_1_2.setBounds(66, 234, 690, 14);
		add(lblNewLabel_2_1_2);

		JLabel lblNewLabel_2_1_3 = new JLabel("Location5");
		lblNewLabel_2_1_3.setBounds(66, 296, 690, 14);
		add(lblNewLabel_2_1_3);

		JLabel lblNewLabel_2_1_4 = new JLabel("Location6");
		lblNewLabel_2_1_4.setBounds(66, 366, 708, 14);
		add(lblNewLabel_2_1_4);

		JLabel lblNewLabel_2_1_5 = new JLabel("Location7");
		lblNewLabel_2_1_5.setBounds(66, 438, 690, 14);
		add(lblNewLabel_2_1_5);

		JLabel lblNewLabel_2_1_6 = new JLabel("Location8");
		lblNewLabel_2_1_6.setBounds(66, 504, 708, 14);
		add(lblNewLabel_2_1_6);

		JLabel lblNewLabel_2_1_7 = new JLabel("Location9");
		lblNewLabel_2_1_7.setBounds(66, 575, 708, 14);
		add(lblNewLabel_2_1_7);

		JLabel lblNewLabel_2_1_8 = new JLabel("Location10");
		lblNewLabel_2_1_8.setBounds(66, 649, 708, 14);
		add(lblNewLabel_2_1_8);

		JLabel lblNewLabel_2_2_2 = new JLabel("Link to OpenStreetMap:");
		lblNewLabel_2_2_2.setBounds(66, 202, 212, 14);
		add(lblNewLabel_2_2_2);

		JLabel lblNewLabel_2_2_3 = new JLabel("Link to OpenStreetMap:");
		lblNewLabel_2_2_3.setBounds(66, 271, 212, 14);
		add(lblNewLabel_2_2_3);

		JLabel lblNewLabel_2_2_4 = new JLabel("Link to OpenStreetMap:");
		lblNewLabel_2_2_4.setBounds(66, 333, 212, 14);
		add(lblNewLabel_2_2_4);

		JLabel lblNewLabel_2_2_5 = new JLabel("Link to OpenStreetMap:");
		lblNewLabel_2_2_5.setBounds(66, 405, 212, 14);
		add(lblNewLabel_2_2_5);

		JLabel lblNewLabel_2_2_6 = new JLabel("Link to OpenStreetMap:");
		lblNewLabel_2_2_6.setBounds(66, 477, 212, 14);
		add(lblNewLabel_2_2_6);

		JLabel lblNewLabel_2_2_7 = new JLabel("Link to OpenStreetMap:");
		lblNewLabel_2_2_7.setBounds(66, 542, 212, 14);
		add(lblNewLabel_2_2_7);

		JLabel lblNewLabel_2_2_8 = new JLabel("Link to OpenStreetMap:");
		lblNewLabel_2_2_8.setBounds(66, 613, 212, 14);
		add(lblNewLabel_2_2_8);

		JLabel lblNewLabel_2_2_9 = new JLabel("Link to OpenStreetMap:");
		lblNewLabel_2_2_9.setBounds(66, 688, 212, 14);
		add(lblNewLabel_2_2_9);

		JLabel lblNewLabel_3_1 = new JLabel("Link2");
		lblNewLabel_3_1.setBounds(288, 141, 495, 14);
		add(lblNewLabel_3_1);

		JLabel lblNewLabel_3_2 = new JLabel("Link3");
		lblNewLabel_3_2.setBounds(288, 202, 496, 14);
		add(lblNewLabel_3_2);

		JLabel lblNewLabel_3_3 = new JLabel("Link4");
		lblNewLabel_3_3.setBounds(288, 271, 486, 14);
		add(lblNewLabel_3_3);

		JLabel lblNewLabel_3_4 = new JLabel("Link5");
		lblNewLabel_3_4.setBounds(288, 333, 486, 14);
		add(lblNewLabel_3_4);

		JLabel lblNewLabel_3_5 = new JLabel("Link6");
		lblNewLabel_3_5.setBounds(288, 405, 486, 14);
		add(lblNewLabel_3_5);

		JLabel lblNewLabel_3_6 = new JLabel("Link7");
		lblNewLabel_3_6.setBounds(288, 477, 486, 14);
		add(lblNewLabel_3_6);

		JLabel lblNewLabel_3_7 = new JLabel("Link8");
		lblNewLabel_3_7.setBounds(288, 542, 486, 14);
		add(lblNewLabel_3_7);

		JLabel lblNewLabel_3_8 = new JLabel("Link9");
		lblNewLabel_3_8.setBounds(288, 613, 486, 14);
		add(lblNewLabel_3_8);

		JLabel lblNewLabel_3_9 = new JLabel("Link10");
		lblNewLabel_3_9.setBounds(288, 688, 486, 14);
		add(lblNewLabel_3_9);

		JLabel lblNewLabel_4 = new JLabel("Coordinates");
		lblNewLabel_4.setBounds(66, 674, 160, 14);
		add(lblNewLabel_4);

		JLabel lblNewLabel_3_9_1 = new JLabel("C10");
		lblNewLabel_3_9_1.setBounds(288, 674, 486, 14);
		add(lblNewLabel_3_9_1);

		JLabel lblNewLabel_4_1 = new JLabel("Coordinates");
		lblNewLabel_4_1.setBounds(66, 600, 160, 14);
		add(lblNewLabel_4_1);

		JLabel lblNewLabel_4_2 = new JLabel("Coordinates");
		lblNewLabel_4_2.setBounds(66, 529, 160, 14);
		add(lblNewLabel_4_2);

		JLabel lblNewLabel_4_3 = new JLabel("Coordinates");
		lblNewLabel_4_3.setBounds(66, 463, 160, 14);
		add(lblNewLabel_4_3);

		JLabel lblNewLabel_4_4 = new JLabel("Coordinates");
		lblNewLabel_4_4.setBounds(66, 391, 160, 14);
		add(lblNewLabel_4_4);

		JLabel lblNewLabel_4_5 = new JLabel("Coordinates");
		lblNewLabel_4_5.setBounds(66, 321, 160, 14);
		add(lblNewLabel_4_5);

		JLabel lblNewLabel_4_6 = new JLabel("Coordinates");
		lblNewLabel_4_6.setBounds(66, 259, 160, 14);
		add(lblNewLabel_4_6);

		JLabel lblNewLabel_4_7 = new JLabel("Coordinates");
		lblNewLabel_4_7.setBounds(66, 191, 160, 14);
		add(lblNewLabel_4_7);

		JLabel lblNewLabel_4_8 = new JLabel("Coordinates");
		lblNewLabel_4_8.setBounds(66, 130, 160, 14);
		add(lblNewLabel_4_8);

		JLabel lblNewLabel_4_9 = new JLabel("Coordinates");
		lblNewLabel_4_9.setBounds(66, 70, 160, 14);
		add(lblNewLabel_4_9);

		JLabel lblNewLabel_3_9_1_1 = new JLabel("C9");
		lblNewLabel_3_9_1_1.setBounds(288, 600, 486, 14);
		add(lblNewLabel_3_9_1_1);

		JLabel lblNewLabel_3_9_1_2 = new JLabel("C8");
		lblNewLabel_3_9_1_2.setBounds(288, 529, 486, 14);
		add(lblNewLabel_3_9_1_2);

		JLabel lblNewLabel_3_9_1_3 = new JLabel("C7");
		lblNewLabel_3_9_1_3.setBounds(288, 463, 486, 14);
		add(lblNewLabel_3_9_1_3);

		JLabel lblNewLabel_3_9_1_4 = new JLabel("C6");
		lblNewLabel_3_9_1_4.setBounds(288, 391, 486, 14);
		add(lblNewLabel_3_9_1_4);

		JLabel lblNewLabel_3_9_1_5 = new JLabel("C5");
		lblNewLabel_3_9_1_5.setBounds(288, 321, 486, 14);
		add(lblNewLabel_3_9_1_5);

		JLabel lblNewLabel_3_9_1_6 = new JLabel("C4");
		lblNewLabel_3_9_1_6.setBounds(288, 259, 486, 14);
		add(lblNewLabel_3_9_1_6);

		JLabel lblNewLabel_3_9_1_7 = new JLabel("C3");
		lblNewLabel_3_9_1_7.setBounds(288, 191, 486, 14);
		add(lblNewLabel_3_9_1_7);

		JLabel lblNewLabel_3_9_1_8 = new JLabel("C2");
		lblNewLabel_3_9_1_8.setBounds(288, 130, 486, 14);
		add(lblNewLabel_3_9_1_8);

		JLabel lblNewLabel_3_9_1_9 = new JLabel("C1");
		lblNewLabel_3_9_1_9.setBounds(288, 70, 486, 14);
		add(lblNewLabel_3_9_1_9);
	}
	private void showSaveLocationDialog() {
		// Create a JComboBox with some sample items
		String[] locations = {"Location A", "Location B", "Location C"};
		JComboBox<String> comboBox = new JComboBox<>(locations);

		// Show the dialog with the JComboBox
		int result = JOptionPane.showConfirmDialog(
				this,
				comboBox,
				"Select a Location",
				JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE
		);

		// Check if the user clicked OK
		if (result == JOptionPane.OK_OPTION) {
			String selectedLocation = (String) comboBox.getSelectedItem();
			// Do something with the selected location, e.g., save it
			JOptionPane.showMessageDialog(this, "Location saved: " + selectedLocation);
		}
	}
}

