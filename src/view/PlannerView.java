package view;

import entity.Label;
import interface_adapter.LocationsFromLabel.LocationsFromLabelController;
import interface_adapter.LocationsFromLabel.LocationsFromLabelState;
import interface_adapter.LocationsFromLabel.LocationsFromLabelViewModel;
import interface_adapter.displayingLabels.DisplayingLabelsController;
import interface_adapter.displayingLabels.DisplayingLabelsState;
import interface_adapter.displayingLabels.DisplayingLabelsViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PlannerView extends JPanel implements ActionListener, PropertyChangeListener {
	public static final String viewName = "planner";
	public DisplayingLabelsViewModel displayingLabelsViewModel;
	public DisplayingLabelsController displayingLabelsController;
	public LocationsFromLabelController locationsFromLabelController;
	public LocationsFromLabelViewModel locationsFromLabelViewModel;
	private static final long serialVersionUID = 1L;
	private final List<JButton> buttonList;
	private JComboBox<String> locationComboBox;
	private JPanel centerButtonPanel; // Updated to make it accessible for dynamic updates
  
	public PlannerView(DisplayingLabelsViewModel displayingLabelsViewModel, DisplayingLabelsController displayingLabelsController, LocationsFromLabelViewModel locationsFromLabelViewModel, LocationsFromLabelController locationsFromLabelController) {
		this.displayingLabelsController = displayingLabelsController;
		this.displayingLabelsViewModel = displayingLabelsViewModel;
		this.locationsFromLabelViewModel = locationsFromLabelViewModel;
		this.locationsFromLabelController = locationsFromLabelController;
		this.locationsFromLabelViewModel.addPropertyChangeListener(this);
		this.displayingLabelsViewModel.addPropertyChangeListener(this);
		setLayout(new BorderLayout());
		displayingLabelsController.execute();

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
		//addButton("Favourites");
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
			addButton(newLabelName);
		}
	}

	private void addButton(String label) {
		JButton newButton = new JButton(label);
		newButton.addActionListener(evt -> JOptionPane.showMessageDialog(null, "Button Label: " + newButton.getText()));

		buttonList.add(newButton);
		centerButtonPanel.add(newButton); // Add the button to the centerButtonPanel

		// Revalidate and repaint
		revalidate();
		repaint();
	}

    @Override
	public void actionPerformed(ActionEvent e) {

	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		SwingUtilities.invokeLater(() -> {
			buttonList.clear(); // Clear the existing list

			Set<Label> labels = displayingLabelsViewModel.getState().getLabels();

			ArrayList<String> buttonLabels = new ArrayList<>();
			for (Label label : labels) {
				buttonLabels.add(label.getTitle());
			}

			centerButtonPanel.removeAll(); // Clear existing buttons from the panel

			for (String label : buttonLabels) {
				JButton button = new JButton(label);

				// Add a listener to each button
				button.addActionListener(e -> {
					locationsFromLabelController.execute(button.getText());
					JOptionPane.showMessageDialog(null, "Button Label: " + LocationsFromLabelState.getLocation());
				});

				buttonList.add(button); // Add the button to the list
				centerButtonPanel.add(button); // Add the button to the panel
			}


			for (JButton button : buttonList) {
				button.addActionListener(
						new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								System.out.println(button.getText());
								locationsFromLabelController.execute(button.getText());
								JOptionPane.showMessageDialog(null, locationsFromLabelViewModel.getState().getLocation());
							}
						}
				);
			}


			// Revalidate and repaint the panel
			centerButtonPanel.revalidate();
			centerButtonPanel.repaint();
		});
	}

}

