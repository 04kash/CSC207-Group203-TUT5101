package view;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PlannerView extends JPanel {
	public static final String viewName = "planner";

	private static final long serialVersionUID = 1L;
	private List<JButton> buttonList;
	private JComboBox<String> locationComboBox;
	private JPanel centerButtonPanel; // Updated to make it accessible for dynamic updates

	public PlannerView() {
		setLayout(new BorderLayout()); // Use BorderLayout for the main panel

		// Create a panel for the top buttons with a horizontal layout
		JPanel topButtonPanel = new JPanel();
		topButtonPanel.setLayout(new FlowLayout());

		// Add the "Delete Location" button
		JButton deleteLocationButton = new JButton("Delete Location");
		deleteLocationButton.addActionListener(e -> showDeleteLocationPopup());
		topButtonPanel.add(deleteLocationButton);

		// Add the "Delete Label" button
		JButton deleteLabelButton = new JButton("Delete Label");
		deleteLabelButton.addActionListener(e -> showDeleteLabelPopup());
		topButtonPanel.add(deleteLabelButton);

		// Add the "Create Label" button
		JButton createLabelButton = new JButton("Create Label");
		createLabelButton.addActionListener(e -> showCreateLabelPopup());
		topButtonPanel.add(createLabelButton);

		// Add the "Go to Homepage" button
		JButton goToHomepageButton = new JButton("Go to Homepage");
		topButtonPanel.add(goToHomepageButton);

		// Add the top button panel to the NORTH position
		add(topButtonPanel, BorderLayout.NORTH);

		buttonList = new ArrayList<>(); // Initialize the list to store buttons

		// Initialize the center panel with buttons
		initializeCenterPanel();
	}

	private void initializeCenterPanel() {
		// Create a panel for the center buttons with a vertical layout
		centerButtonPanel = new JPanel();
		centerButtonPanel.setLayout(new BoxLayout(centerButtonPanel, BoxLayout.Y_AXIS));

		// Wrap the center button panel with a JScrollPane
		JScrollPane scrollPane = new JScrollPane(centerButtonPanel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // Set scroll bar policy

		// Add the scroll pane to the CENTER position
		add(scrollPane, BorderLayout.CENTER);

		// Add the "Favourites" button initially
		addButton("Favourites", "Hi");
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
					centerButtonPanel.remove(button); // Remove the button from centerButtonPanel
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

	private void showCreateLabelPopup() {
		// Implement the logic for "Create Label" popup here
		String newLabelName = JOptionPane.showInputDialog(null, "Enter label name:");
		if (newLabelName != null && !newLabelName.isEmpty()) {
			addButton(newLabelName, newLabelName);
		}
	}

	private void addButton(String label, String message) {
		JButton newButton = new JButton(label);
		newButton.addActionListener(evt -> JOptionPane.showMessageDialog(null, message));

		buttonList.add(newButton);
		centerButtonPanel.add(newButton); // Add the button to the centerButtonPanel

		// Revalidate and repaint
		revalidate();
		repaint();
	}}