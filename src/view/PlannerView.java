package view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PlannerView extends JPanel {
	public static final String viewName = "planner";

	private static final long serialVersionUID = 1L;
	private List<JButton> buttonList;
	private JComboBox<String> comboBox;
	private JComboBox<String> locationComboBox;

	public PlannerView() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		// Create a panel for the top buttons with a horizontal flow layout
		JPanel topButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		// Add the "Delete Location" button
		JButton deleteLocationButton = new JButton("Delete Location");
		deleteLocationButton.addActionListener(e -> showDeleteLocationPopup());
		topButtonPanel.add(deleteLocationButton);

		// Add the "Delete Label" button
		JButton deleteLabelButton = new JButton("Delete Label");
		deleteLabelButton.addActionListener(e -> showDeleteLabelPopup());
		topButtonPanel.add(deleteLabelButton);

		// Add the "Go to Homepage" button
		JButton goToHomepageButton = new JButton("Go to Homepage");
		topButtonPanel.add(goToHomepageButton);

		// Add the "Add a new Label" button
		JButton addNewLabelButton = new JButton("Add a new Label");
		addNewLabelButton.addActionListener(e -> showAddNewLabelPopup());
		topButtonPanel.add(addNewLabelButton);

		// Add the top button panel to the main panel
		add(topButtonPanel);

		JLabel lblNewLabel = new JLabel("Your Labels:");
		add(lblNewLabel);

		buttonList = new ArrayList<>(); // Initialize the list to store buttons

		String[] buttonLabels = {"Button 1", "Button 2", "Button 3", "Button 4", "Button 5"};

		for (String label : buttonLabels) {
			JButton button = new JButton(label);
			button.addActionListener(e -> JOptionPane.showMessageDialog(null, "Hi"));

			buttonList.add(button); // Add the button to the list
			add(button);
		}
	}

	private void showDeleteLabelPopup() {
		// Show a popup to choose a label to delete
		String[] labelOptions = buttonList.stream()
				.map(AbstractButton::getText)
				.toArray(String[]::new);

		String selectedLabel = (String) JOptionPane.showInputDialog(
				null,
				"Choose a label to delete:",
				"Delete Label",
				JOptionPane.QUESTION_MESSAGE,
				null,
				labelOptions,
				labelOptions[0]);

		// Remove the selected label button
		if (selectedLabel != null) {
			for (JButton button : buttonList) {
				if (button.getText().equals(selectedLabel)) {
					buttonList.remove(button);
					remove(button);

					// Revalidate and repaint
					revalidate();
					repaint();
					break;
				}
			}
		}
	}

	private void showDeleteLocationPopup() {
		JPanel popupPanel = new JPanel(new BorderLayout());

		JLabel popupLabel = new JLabel("Choose a location to delete:");
		popupPanel.add(popupLabel, BorderLayout.NORTH);

		// Replace the below array with your actual location options
		String[] locationOptions = {"Location 1", "Location 2", "Location 3"};
		locationComboBox = new JComboBox<>(locationOptions);
		popupPanel.add(locationComboBox, BorderLayout.CENTER);

		int result = JOptionPane.showConfirmDialog(null, popupPanel, "Delete Location", JOptionPane.OK_CANCEL_OPTION);

		if (result == JOptionPane.OK_OPTION) {
			String selectedLocation = (String) locationComboBox.getSelectedItem();
			JOptionPane.showMessageDialog(null, "Selected location to delete: " + selectedLocation);
		}
	}

	private void showAddNewLabelPopup() {
		// Implement the logic for "Add a new Label" popup here
		String newLabelName = JOptionPane.showInputDialog(null, "Enter label name:");
		if (newLabelName != null && !newLabelName.isEmpty()) {
			JButton newButton = new JButton(newLabelName);
			newButton.addActionListener(evt -> JOptionPane.showMessageDialog(null, newLabelName));

			buttonList.add(newButton);
			add(newButton);

			// Revalidate and repaint
			revalidate();
			repaint();
		}
	}
}
