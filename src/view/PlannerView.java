package view;

import entity.Label;
import interface_adapter.CreateLabel.CreateLabelController;
import interface_adapter.CreateLabel.CreateLabelViewModel;
import interface_adapter.LocationsFromLabel.LocationsFromLabelController;
import interface_adapter.LocationsFromLabel.LocationsFromLabelViewModel;
import interface_adapter.displayingLabels.DisplayingLabelsController;
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
	public final CreateLabelViewModel createLabelViewModel;
	public DisplayingLabelsViewModel displayingLabelsViewModel;
	public DisplayingLabelsController displayingLabelsController;
	public LocationsFromLabelController locationsFromLabelController;
	public CreateLabelController createLabelController;
	public LocationsFromLabelViewModel locationsFromLabelViewModel;
	private static final long serialVersionUID = 1L;
	private final List<JButton> buttonList;
	private JComboBox<String> locationComboBox;
	private JPanel centerButtonPanel; // Updated to make it accessible for dynamic updates
	private JButton okButtonReference;
  
	public PlannerView(DisplayingLabelsViewModel displayingLabelsViewModel, DisplayingLabelsController displayingLabelsController, LocationsFromLabelViewModel locationsFromLabelViewModel, LocationsFromLabelController locationsFromLabelController, CreateLabelController createLabelController, CreateLabelViewModel createLabelViewModel) {
		this.displayingLabelsController = displayingLabelsController;
		this.displayingLabelsViewModel = displayingLabelsViewModel;
		this.locationsFromLabelViewModel = locationsFromLabelViewModel;
		this.locationsFromLabelController = locationsFromLabelController;
		this.createLabelViewModel = createLabelViewModel;
		this.createLabelController = createLabelController;
		this.locationsFromLabelViewModel.addPropertyChangeListener(this);
		this.displayingLabelsViewModel.addPropertyChangeListener(this);
		setLayout(new BorderLayout());
		displayingLabelsController.execute();

		// Create a panel for the top buttons with a horizontal layout
		JPanel topButtonPanel = new JPanel();
		topButtonPanel.setBackground(new Color(245, 245, 245));
		topButtonPanel.setLayout(new FlowLayout());

//		// Add the "Delete Location" button
//		JButton deleteLocationButton = new JButton("Delete Location");
//		deleteLocationButton.setBackground(new Color(51, 153, 102));
//		deleteLocationButton.setForeground(new Color(245, 245, 245));
//		deleteLocationButton.addActionListener(e -> showDeleteLocationPopup());
//		topButtonPanel.add(deleteLocationButton);
//
//		// Add the "Delete Label" button
//		JButton deleteLabelButton = new JButton("Delete Label");
//		deleteLabelButton.setBackground(new Color(51, 153, 102));
//		deleteLabelButton.setForeground(new Color(245, 245, 245));
//		deleteLabelButton.addActionListener(e -> showDeleteLabelPopup());
//		topButtonPanel.add(deleteLabelButton);

		// Add the "Create Label" button
		JButton createLabelButton = new JButton("Create Label");
		createLabelButton.setBackground(new Color(51, 153, 102));
		createLabelButton.setForeground(new Color(245, 245, 245));
		createLabelButton.addActionListener(e -> {showCreateLabelPopup();
			revalidate();
			repaint();
		});
		topButtonPanel.add(createLabelButton);

		// Add the "Go to Homepage" button
		JButton goToHomepageButton = new JButton("Go to Homepage");
		goToHomepageButton.setBackground(new Color(51, 153, 102));
		goToHomepageButton.setForeground(new Color(245, 245, 245));
		topButtonPanel.add(goToHomepageButton);
		goToHomepageButton.addActionListener(e->ViewManager.showLoggedinView());

		// Add the top button panel to the NORTH position
		add(topButtonPanel, BorderLayout.NORTH);

		buttonList = new ArrayList<>(); // Initialize the list to store buttons

		// Initialize the center panel with buttons
		initializeCenterPanel();
	}

	private void initializeCenterPanel() {
		// Create a panel for the center buttons with a vertical layout
		centerButtonPanel = new JPanel();
		centerButtonPanel.setBackground(new Color(245, 245, 245));
		centerButtonPanel.setLayout(new BoxLayout(centerButtonPanel, BoxLayout.Y_AXIS));

		// Wrap the center button panel with a JScrollPane
		JScrollPane scrollPane = new JScrollPane(centerButtonPanel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // Set scroll bar policy

		// Add the scroll pane to the CENTER position
		add(scrollPane, BorderLayout.CENTER);

	}

	private void showCreateLabelPopup() {
		// Implement the logic for "Create Label" popup here
		String newLabelName = JOptionPane.showInputDialog(null, "Enter label name:");

		if (newLabelName != null && !newLabelName.isEmpty()) {
			createLabelController.execute(newLabelName);

			// Create a custom dialog with a button
			JDialog dialog = new JDialog();
			dialog.setTitle("Add a New Label");

			JPanel panel = new JPanel();
			JButton okButton = new JButton("OK");
			panel.add(new JLabel(createLabelViewModel.getState().getDisplayMsg()));
			panel.add(okButton);

			okButton.addActionListener(e -> {
				displayingLabelsController.execute();
				dialog.dispose();  // Close the dialog
			});

			this.okButtonReference = okButton;

			dialog.getContentPane().add(panel);
			dialog.pack();
			dialog.setLocationRelativeTo(null);  // Center the dialog on the screen
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);  // Dispose on close, no default close operation

			dialog.setVisible(true);
		}

		revalidate();
		repaint();
	}

    @Override
	public void actionPerformed(ActionEvent e) {

	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		SwingUtilities.invokeLater(() -> {
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
				});
				button.setBackground(new Color(51, 153, 102));
				button.setForeground(new Color(245, 245, 245));

				buttonList.add(button); // Add the button to the list
				centerButtonPanel.add(button); // Add the button to the panel
			}


			for (JButton button : buttonList) {
				button.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						//System.out.println(button.getText());
						locationsFromLabelController.execute(button.getText());

						// Customize the title of the message dialog
						String title = "Your Saved Locations:";

						JOptionPane.showMessageDialog(
								null,
								locationsFromLabelViewModel.getState().getDisplayMsg(),
								title,
								JOptionPane.INFORMATION_MESSAGE
						);
					}
				});
			}



			// Revalidate and repaint the panel
			centerButtonPanel.revalidate();
			centerButtonPanel.repaint();
		});
	}

	public JButton getOkButtonReference() {
		return okButtonReference;
	}
}

