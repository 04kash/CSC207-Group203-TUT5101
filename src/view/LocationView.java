package view;

import entity.Label;
import entity.Location;
import interface_adapter.SavingLocation.SavingLocationController;
import interface_adapter.SavingLocation.SavingLocationViewModel;
import interface_adapter.displayingLabels.DisplayingLabelsViewModel;
import interface_adapter.displayingLocations.DisplayingLocationsController;
import interface_adapter.displayingLocations.DisplayingLocationsViewModel;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Objects;

public class LocationView extends JPanel implements ActionListener, PropertyChangeListener {

	private final SavingLocationViewModel savingLocationViewModel;
	public DisplayingLocationsViewModel displayingLocationsViewModel;
	public DisplayingLabelsViewModel displayingLabelsViewModel;
	public DisplayingLocationsController displayingLocationsController;

	public SavingLocationController savingLocationController;
	public static final String viewName = "location view";
	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	private static JLabel location1;
	private static JLabel coordinate1;

	private static JLabel link1;

	private static JLabel location2;
	private static JLabel coordinate2;

	private static JLabel link2;
	private static JLabel location3;
	private static JLabel coordinate3;

	private static JLabel link3;

	private static JLabel location4;
	private static JLabel coordinate4;

	private static JLabel link4;

	private static JLabel location5;
	private static JLabel coordinate5;

	private static JLabel link5;
	private static JLabel location6;
	private static JLabel coordinate6;

	private static JLabel link6;
	private static JLabel location7;
	private static JLabel coordinate7;

	private static JLabel link7;
	private static JLabel location8;
	private static JLabel coordinate8;

	private static JLabel link8;
	private static JLabel location9;
	private static JLabel coordinate9;

	private static JLabel link9;
	private static JLabel location10;
	private static JLabel coordinate10;

	private static JLabel link10;

	private static JButton save;

	/**
	 * Create the panel.
	 */
	public LocationView(DisplayingLocationsViewModel displayingLocationsViewModel, DisplayingLocationsController displayingLocationsController, SavingLocationController savingLocationController, DisplayingLabelsViewModel displayingLabelsViewModel, SavingLocationViewModel savingLocationViewModel){
		setBackground(new Color(245, 245, 245));
		this.setLayout(null);
		this.displayingLocationsController = displayingLocationsController;
		this.displayingLocationsViewModel = displayingLocationsViewModel;
		this.displayingLabelsViewModel = displayingLabelsViewModel;
		this.savingLocationController = savingLocationController;
		this.savingLocationViewModel = savingLocationViewModel;
		this.displayingLocationsViewModel.addPropertyChangeListener(this);
		displayingLocationsController.execute();

		save = new JButton("Save A Location");
		save.setForeground(new Color(245, 245, 245));
		save.setBackground(new Color(0, 153, 102));
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showSaveLocationDialog(displayingLocationsViewModel.getState().getLocations(),new ArrayList<>(displayingLabelsViewModel.getState().getLabels()));
			}
		});
		save.setBounds(37, 11, 197, 23);
		add(save);
		save.repaint();


		JButton home = new JButton("Go to HomePage");
		home.setBackground(new Color(0, 153, 102));
		home.setForeground(new Color(245, 245, 245));
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewManager.showLoggedinView();
			}
		});
		home.setBounds(465, 11, 160, 23);
		add(home);

		JLabel heading = new JLabel("Suggested Places");
		heading.setForeground(new Color(0, 153, 102));
		heading.setFont(new Font("Arial Black", Font.PLAIN, 18));
		heading.setBounds(259, 11, 279, 39);
		add(heading);

		JLabel location1Label = new JLabel("1.");
		location1Label.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		location1Label.setForeground(new Color(0, 153, 102));
		location1Label.setBounds(26, 45, 17, 14);
		add(location1Label);


		location1 = new JLabel("Location1");
		location1.setForeground(new Color(0, 153, 102));
		location1.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		location1.setBounds(66, 45, 708, 14);
		add(location1);


		JLabel location1coordinate = new JLabel("Coordinates");
		location1coordinate.setForeground(new Color(51, 153, 102));
		location1coordinate.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		location1coordinate.setBounds(66, 70, 160, 14);
		add(location1coordinate);

		coordinate1 = new JLabel("C1");
		coordinate1.setForeground(new Color(0, 153, 102));
		coordinate1.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		coordinate1.setBounds(288, 70, 486, 14);
		add(coordinate1);

		JLabel location1link = new JLabel("Link to OpenStreetMap:");
		location1link.setForeground(new Color(0, 153, 102));
		location1link.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		location1link.setBounds(66, 80, 212, 14);
		add(location1link);

		link1 = new JLabel("Link1");
		link1.setForeground(new Color(0, 153, 102));
		link1.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		link1.setBounds(288, 80, 486, 14);
		add(link1);

		JLabel location2label = new JLabel("2.");
		location2label.setForeground(new Color(51, 153, 102));
		location2label.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		location2label.setBounds(26, 105, 17, 14);
		add(location2label);

		location2 = new JLabel("Location2");
		location2.setForeground(new Color(51, 153, 102));
		location2.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		location2.setBounds(66, 105, 690, 14);
		add(location2);

		JLabel location2coordinate = new JLabel("Coordinates");
		location2coordinate.setForeground(new Color(51, 153, 102));
		location2coordinate.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		location2coordinate.setBounds(66, 130, 160, 14);
		add(location2coordinate);

		coordinate2 = new JLabel("C2");
		coordinate2.setForeground(new Color(51, 153, 102));
		coordinate2.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		coordinate2.setBounds(288, 130, 486, 14);
		add(coordinate2);

		JLabel location2Link = new JLabel("Link to OpenStreetMap:");
		location2Link.setForeground(new Color(51, 153, 102));
		location2Link.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		location2Link.setBounds(66, 141, 212, 14);
		add(location2Link);

		link2 = new JLabel("Link2");
		link2.setForeground(new Color(51, 153, 102));
		link2.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		link2.setBounds(288, 141, 495, 14);
		add(link2);

		JLabel location3label = new JLabel("3.");
		location3label.setForeground(new Color(51, 153, 102));
		location3label.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		location3label.setBounds(26, 166, 17, 14);
		add(location3label);

		location3 = new JLabel("Location3");
		location3.setForeground(new Color(51, 153, 102));
		location3.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		location3.setBounds(66, 166, 690, 14);
		add(location3);

		JLabel location3coordinate = new JLabel("Coordinates");
		location3coordinate.setForeground(new Color(51, 153, 102));
		location3coordinate.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		location3coordinate.setBounds(66, 191, 160, 14);
		add(location3coordinate);

		coordinate3 = new JLabel("C3");
		coordinate3.setForeground(new Color(51, 153, 102));
		coordinate3.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		coordinate3.setBounds(288, 191, 486, 14);
		add(coordinate3);

		JLabel location3link = new JLabel("Link to OpenStreetMap:");
		location3link.setForeground(new Color(51, 153, 102));
		location3link.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		location3link.setBounds(66, 202, 212, 14);
		add(location3link);

		link3 = new JLabel("Link3");
		link3.setForeground(new Color(51, 153, 102));
		link3.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		link3.setBounds(288, 202, 496, 14);
		add(link3);

		JLabel location4label = new JLabel("4.");
		location4label.setForeground(new Color(51, 153, 102));
		location4label.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		location4label.setBounds(26, 234, 17, 14);
		add(location4label);

		location4 = new JLabel("Location4");
		location4.setForeground(new Color(51, 153, 102));
		location4.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		location4.setBounds(66, 234, 690, 14);
		add(location4);

		JLabel location4coordinate = new JLabel("Coordinates");
		location4coordinate.setForeground(new Color(51, 153, 102));
		location4coordinate.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		location4coordinate.setBounds(66, 259, 160, 14);
		add(location4coordinate);

		coordinate4 = new JLabel("C4");
		coordinate4.setForeground(new Color(51, 153, 102));
		coordinate4.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		coordinate4.setBounds(288, 259, 486, 14);
		add(coordinate4);

		JLabel location4link = new JLabel("Link to OpenStreetMap:");
		location4link.setForeground(new Color(51, 153, 102));
		location4link.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		location4link.setBounds(66, 271, 212, 14);
		add(location4link);

		link4 = new JLabel("Link4");
		link4.setForeground(new Color(51, 153, 102));
		link4.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		link4.setBounds(288, 271, 486, 14);
		add(link4);

		JLabel location5label = new JLabel("5.");
		location5label.setForeground(new Color(51, 153, 102));
		location5label.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		location5label.setBounds(26, 296, 17, 14);
		add(location5label);

		location5 = new JLabel("Location5");
		location5.setForeground(new Color(51, 153, 102));
		location5.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		location5.setBounds(66, 296, 690, 14);
		add(location5);

		JLabel location5coordinate = new JLabel("Coordinates");
		location5coordinate.setForeground(new Color(51, 153, 102));
		location5coordinate.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		location5coordinate.setBounds(66, 321, 160, 14);
		add(location5coordinate);

		coordinate5 = new JLabel("C5");
		coordinate5.setForeground(new Color(51, 153, 102));
		coordinate5.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		coordinate5.setBounds(288, 321, 486, 14);
		add(coordinate5);

		JLabel location5link = new JLabel("Link to OpenStreetMap:");
		location5link.setForeground(new Color(51, 153, 102));
		location5link.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		location5link.setBounds(66, 333, 212, 14);
		add(location5link);

		link5 = new JLabel("Link5");
		link5.setForeground(new Color(51, 153, 102));
		link5.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		link5.setBounds(288, 333, 486, 14);
		add(link5);

		JLabel location6label = new JLabel("6.");
		location6label.setForeground(new Color(51, 153, 102));
		location6label.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		location6label.setBounds(26, 366, 17, 14);
		add(location6label);

		location6 = new JLabel("Location6");
		location6.setForeground(new Color(51, 153, 102));
		location6.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		location6.setBounds(66, 366, 708, 14);
		add(location6);

		JLabel location6coordinate = new JLabel("Coordinates");
		location6coordinate.setForeground(new Color(51, 153, 102));
		location6coordinate.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		location6coordinate.setBounds(66, 391, 160, 14);
		add(location6coordinate);

		coordinate6 = new JLabel("C6");
		coordinate6.setForeground(new Color(51, 153, 102));
		coordinate6.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		coordinate6.setBounds(288, 391, 486, 14);
		add(coordinate6);

		JLabel location6link = new JLabel("Link to OpenStreetMap:");
		location6link.setForeground(new Color(51, 153, 102));
		location6link.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		location6link.setBounds(66, 405, 212, 14);
		add(location6link);

		link6 = new JLabel("Link6");
		link6.setForeground(new Color(51, 153, 102));
		link6.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		link6.setBounds(288, 405, 486, 14);
		add(link6);

		JLabel location7label = new JLabel("7.");
		location7label.setForeground(new Color(51, 153, 102));
		location7label.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		location7label.setBounds(26, 438, 17, 14);
		add(location7label);

		location7 = new JLabel("Location7");
		location7.setForeground(new Color(51, 153, 102));
		location7.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		location7.setBounds(66, 438, 690, 14);
		add(location7);

		JLabel location7coordinate = new JLabel("Coordinates");
		location7coordinate.setForeground(new Color(51, 153, 102));
		location7coordinate.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		location7coordinate.setBounds(66, 463, 160, 14);
		add(location7coordinate);

		coordinate7 = new JLabel("C7");
		coordinate7.setForeground(new Color(51, 153, 102));
		coordinate7.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		coordinate7.setBounds(288, 463, 486, 14);
		add(coordinate7);

		JLabel location7link = new JLabel("Link to OpenStreetMap:");
		location7link.setForeground(new Color(51, 153, 102));
		location7link.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		location7link.setBounds(66, 477, 212, 14);
		add(location7link);

		link7 = new JLabel("Link7");
		link7.setForeground(new Color(51, 153, 102));
		link7.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		link7.setBounds(288, 477, 486, 14);
		add(link7);

		JLabel location8label = new JLabel("8.");
		location8label.setForeground(new Color(51, 153, 102));
		location8label.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		location8label.setBounds(26, 504, 17, 14);
		add(location8label);

		location8 = new JLabel("Location8");
		location8.setForeground(new Color(51, 153, 102));
		location8.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		location8.setBounds(66, 504, 708, 14);
		add(location8);

		JLabel location8coordinate = new JLabel("Coordinates");
		location8coordinate.setForeground(new Color(51, 153, 102));
		location8coordinate.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		location8coordinate.setBounds(66, 529, 160, 14);
		add(location8coordinate);

		coordinate8 = new JLabel("C8");
		coordinate8.setForeground(new Color(51, 153, 102));
		coordinate8.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		coordinate8.setBounds(288, 529, 486, 14);
		add(coordinate8);

		JLabel location8link = new JLabel("Link to OpenStreetMap:");
		location8link.setForeground(new Color(51, 153, 102));
		location8link.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		location8link.setBounds(66, 542, 212, 14);
		add(location8link);

		link8 = new JLabel("Link8");
		link8.setForeground(new Color(51, 153, 102));
		link8.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		link8.setBounds(288, 542, 486, 14);
		add(link8);

		JLabel location9label = new JLabel("9.");
		location9label.setForeground(new Color(51, 153, 102));
		location9label.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		location9label.setBounds(26, 575, 17, 14);
		add(location9label);

		location9 = new JLabel("Location9");
		location9.setForeground(new Color(51, 153, 102));
		location9.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		location9.setBounds(66, 575, 708, 14);
		add(location9);

		JLabel location9coordinate = new JLabel("Coordinates");
		location9coordinate.setForeground(new Color(51, 153, 102));
		location9coordinate.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		location9coordinate.setBounds(66, 600, 160, 14);
		add(location9coordinate);

		coordinate9 = new JLabel("C9");
		coordinate9.setForeground(new Color(51, 153, 102));
		coordinate9.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		coordinate9.setBounds(288, 600, 486, 14);
		add(coordinate9);

		JLabel location9link = new JLabel("Link to OpenStreetMap:");
		location9link.setForeground(new Color(51, 153, 102));
		location9link.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		location9link.setBounds(66, 613, 212, 14);
		add(location9link);

		link9 = new JLabel("Link9");
		link9.setForeground(new Color(51, 153, 102));
		link9.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		link9.setBounds(288, 613, 486, 14);
		add(link9);

		JLabel location10label = new JLabel("10.");
		location10label.setForeground(new Color(51, 153, 102));
		location10label.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		location10label.setBounds(26, 649, 17, 14);
		add(location10label);

		location10 = new JLabel("Location10");
		location10.setForeground(new Color(51, 153, 102));
		location10.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		location10.setBounds(66, 649, 708, 14);
		add(location10);

		JLabel location10coordinate = new JLabel("Coordinates");
		location10coordinate.setForeground(new Color(51, 153, 102));
		location10coordinate.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		location10coordinate.setBounds(66, 674, 160, 14);
		add(location10coordinate);

		coordinate10 = new JLabel("C10");
		coordinate10.setForeground(new Color(51, 153, 102));
		coordinate10.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		coordinate10.setBounds(288, 674, 486, 14);
		add(coordinate10);

		JLabel location10link = new JLabel("Link to OpenStreetMap:");
		location10link.setForeground(new Color(51, 153, 102));
		location10link.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		location10link.setBounds(66, 688, 212, 14);
		add(location10link);

		link10 = new JLabel("Link10");
		link10.setForeground(new Color(51, 153, 102));
		link10.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		link10.setBounds(288, 688, 486, 14);
		add(link10);
	}

	private ArrayList<Object> showSaveLocationDialog(ArrayList<Location> locations, ArrayList<Label> labels) {
		// Create JComboBox for locations
		String[] locationString = new String[locations.size()];
		for (int i = 0; i < locations.size(); i++) {
			locationString[i] = locations.get(i).getName();
		}
		JComboBox<String> locationComboBox = new JComboBox<>(locationString);

		// Create JComboBox for labels (assuming labels are strings)
		String[] labelString = new String[labels.size()];
		for (int i = 0; i < labels.size(); i++) {
			labelString[i] = labels.get(i).getTitle();
		}
		JComboBox<String> labelComboBox = new JComboBox<>(labelString);

		// Create JPanel to hold JComboBox components
		JPanel panel = new JPanel(new GridLayout(2, 2));
		panel.add(new JLabel("Select a Location:"));
		panel.add(locationComboBox);
		panel.add(new JLabel("Select a Label:"));
		panel.add(labelComboBox);

		// Show the dialog with the JComboBox components
		int result = JOptionPane.showConfirmDialog(
				this,
				panel,
				"Select Location and Label",
				JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE
		);

		// Check if the user clicked OK
		if (result == JOptionPane.OK_OPTION) {
			String selectedLocationName = Objects.requireNonNull(locationComboBox.getSelectedItem()).toString();
			String selectedLabelTitle = Objects.requireNonNull(labelComboBox.getSelectedItem()).toString();

			// Find the selected Location object
			Location selectedLocation = null;
			for (Location location : locations) {
				if (location.getName().equals(selectedLocationName)) {
					selectedLocation = location;
					break;
				}
			}

			// Find the selected Label object
			Label selectedLabel = null;
			for (Label label : labels) {
				if (label.getTitle().equals(selectedLabelTitle)) {
					selectedLabel = label;
					break;
				}
			}

			// Create an ArrayList with selected Location and Label
			ArrayList<Object> selectedData = new ArrayList<>();
			selectedData.add(selectedLocation);
			selectedData.add(selectedLabel);

			// Do something with the selected Location and Label

			return selectedData;
		}

		return new ArrayList<>(); // Return an empty list if the user canceled
	}

	public void actionPerformed(ActionEvent evt) {
		System.out.println("Click " + evt.getActionCommand());
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		ArrayList<Location> locations = new ArrayList<>();
		if (!displayingLocationsViewModel.getState().getLocations().isEmpty()) {
			locations = displayingLocationsViewModel.getState().getLocations();

			remove(location1);
			remove(coordinate1);
			remove(link1);
			if (locations.size() >= 1) {
				location1 = new JLabel(locations.get(0).getName());
				location1.setForeground(new Color(0, 153, 102));
				location1.setFont(new Font("Arial Narrow", Font.BOLD, 13));
				location1.setBounds(66, 45, 708, 14);
				add(location1);

				coordinate1 = new JLabel("(" + locations.get(0).getCoordinate().getLatitude() + ", " + locations.get(0).getCoordinate().getLongitude() + ")");
				coordinate1.setForeground(new Color(0, 153, 102));
				coordinate1.setFont(new Font("Arial Narrow", Font.BOLD, 13));
				coordinate1.setBounds(288, 70, 486, 14);
				add(coordinate1);

				link1 = new JLabel("<html><a href='#'>Link</a></html>");
				String link = locations.get(0).getOsmLink();
				link1.addMouseListener(
						new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								openWebPage("https://www.openstreetmap.org/" + link);
							}
						}
				);
				link1.setBounds(288, 80, 486, 14);
				add(link1);
			}

			remove(location2);
			remove(coordinate2);
			remove(link2);
			if (locations.size() >= 2) {
				location2 = new JLabel(locations.get(1).getName());
				location2.setBounds(66, 105, 690, 14);
				location2.setForeground(new Color(0, 153, 102));
				location2.setFont(new Font("Arial Narrow", Font.BOLD, 13));
				add(location2);

				coordinate2 = new JLabel("(" + locations.get(1).getCoordinate().getLatitude() + ", " + locations.get(1).getCoordinate().getLongitude() + ")");
				coordinate2.setBounds(288, 130, 486, 14);
				coordinate2.setForeground(new Color(0, 153, 102));
				coordinate2.setFont(new Font("Arial Narrow", Font.BOLD, 13));
				add(coordinate2);

				link2 = new JLabel("<html><a href='#'>Link</a></html>");
				String links2 = locations.get(1).getOsmLink();
				link2.addMouseListener(
						new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								openWebPage("https://www.openstreetmap.org/" + links2);
							}
						}
				);
				link2.setBounds(288, 141, 495, 14);
				add(link2);
			}

			remove(location3);
			remove(coordinate3);
			remove(link3);
			if (locations.size() >= 3) {
				location3 = new JLabel(locations.get(2).getName());
				location3.setBounds(66, 166, 690, 14);
				location3.setForeground(new Color(0, 153, 102));
				location3.setFont(new Font("Arial Narrow", Font.BOLD, 13));
				add(location3);

				coordinate3 = new JLabel("(" + locations.get(2).getCoordinate().getLatitude() + ", " + locations.get(2).getCoordinate().getLongitude() + ")");
				coordinate3.setBounds(288, 191, 486, 14);
				coordinate3.setForeground(new Color(0, 153, 102));
				coordinate3.setFont(new Font("Arial Narrow", Font.BOLD, 13));
				add(coordinate3);

				link3 = new JLabel("<html><a href='#'>Link</a></html>");
				String links3 = locations.get(2).getOsmLink();
				link3.addMouseListener(
						new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								openWebPage("https://www.openstreetmap.org/" + links3);
							}
						}
				);
				link3.setBounds(288, 202, 496, 14);
				add(link3);
			}
			remove(location4);
			remove(coordinate4);
			remove(link4);
			if (locations.size() >= 4) {
				location4 = new JLabel(locations.get(3).getName());
				location4.setBounds(66, 234, 690, 14);
				location4.setForeground(new Color(0, 153, 102));
				location4.setFont(new Font("Arial Narrow", Font.BOLD, 13));
				add(location4);

				coordinate4 = new JLabel("(" + locations.get(3).getCoordinate().getLatitude() + ", " + locations.get(3).getCoordinate().getLongitude() + ")");
				coordinate4.setBounds(288, 259, 486, 14);
				coordinate4.setForeground(new Color(0, 153, 102));
				coordinate4.setFont(new Font("Arial Narrow", Font.BOLD, 13));
				add(coordinate4);

				link4 = new JLabel("<html><a href='#'>Link</a></html>");
				String links4 = locations.get(3).getOsmLink();
				link4.addMouseListener(
						new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								openWebPage("https://www.openstreetmap.org/" + links4);
							}
						}
				);
				link4.setBounds(288, 271, 486, 14);
				add(link4);
			}

			remove(location5);
			remove(coordinate5);
			remove(link5);
			if (locations.size() >= 5) {
				location5 = new JLabel(locations.get(4).getName());
				location5.setBounds(66, 296, 690, 14);
				location5.setForeground(new Color(0, 153, 102));
				location5.setFont(new Font("Arial Narrow", Font.BOLD, 13));
				add(location5);


				coordinate5 = new JLabel("(" + locations.get(4).getCoordinate().getLatitude() + ", " + locations.get(4).getCoordinate().getLongitude() + ")");
				coordinate5.setBounds(288, 321, 486, 14);
				coordinate5.setForeground(new Color(0, 153, 102));
				coordinate5.setFont(new Font("Arial Narrow", Font.BOLD, 13));
				add(coordinate5);

				link5 = new JLabel("<html><a href='#'>Link</a></html>");
				String links5 = locations.get(4).getOsmLink();
				link5.addMouseListener(
						new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								openWebPage("https://www.openstreetmap.org/" + links5);
							}
						}
				);
				link5.setBounds(288, 333, 486, 14);
				add(link5);
			}

			remove(location6);
			remove(coordinate6);
			remove(link6);
			if (locations.size() >= 6) {
				location6 = new JLabel(locations.get(5).getName());
				location6.setBounds(66, 366, 708, 14);
				location6.setForeground(new Color(0, 153, 102));
				location6.setFont(new Font("Arial Narrow", Font.BOLD, 13));
				add(location6);

				coordinate6 = new JLabel("(" + locations.get(5).getCoordinate().getLatitude() + ", " + locations.get(5).getCoordinate().getLongitude() + ")");
				coordinate6.setBounds(288, 391, 486, 14);
				coordinate6.setForeground(new Color(0, 153, 102));
				coordinate6.setFont(new Font("Arial Narrow", Font.BOLD, 13));
				add(coordinate6);

				link6 = new JLabel("<html><a href='#'>Link</a></html>");
				String links6 = locations.get(5).getOsmLink();
				link6.addMouseListener(
						new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								openWebPage("https://www.openstreetmap.org/" + links6);
							}
						}
				);
				link6.setBounds(288, 405, 486, 14);
				add(link6);
			}

			remove(location7);
			remove(coordinate7);
			remove(link7);
			if (locations.size() >= 7) {
				location7 = new JLabel(locations.get(6).getName());
				location7.setBounds(66, 438, 690, 14);
				location7.setForeground(new Color(0, 153, 102));
				location7.setFont(new Font("Arial Narrow", Font.BOLD, 13));
				add(location7);

				coordinate7 = new JLabel("(" + locations.get(6).getCoordinate().getLatitude() + ", " + locations.get(6).getCoordinate().getLongitude() + ")");
				coordinate7.setBounds(288, 463, 486, 14);
				coordinate7.setForeground(new Color(0, 153, 102));
				coordinate7.setFont(new Font("Arial Narrow", Font.BOLD, 13));
				add(coordinate7);

				link7 = new JLabel("<html><a href='#'>Link</a></html>");
				String links7 = locations.get(6).getOsmLink();
				link7.addMouseListener(
						new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								openWebPage("https://www.openstreetmap.org/" + links7);
							}
						}
				);
				link7.setBounds(288, 477, 486, 14);
				add(link7);
			}

			remove(location8);
			remove(coordinate8);
			remove(link8);
			if (locations.size() >= 8) {
				location8 = new JLabel(locations.get(7).getName());
				location8.setBounds(66, 504, 708, 14);
				location8.setForeground(new Color(0, 153, 102));
				location8.setFont(new Font("Arial Narrow", Font.BOLD, 13));
				add(location8);

				coordinate8 = new JLabel("(" + locations.get(7).getCoordinate().getLatitude() + ", " + locations.get(7).getCoordinate().getLongitude() + ")");
				coordinate8.setBounds(288, 529, 486, 14);
				coordinate8.setForeground(new Color(0, 153, 102));
				coordinate8.setFont(new Font("Arial Narrow", Font.BOLD, 13));
				add(coordinate8);

				link8 = new JLabel("<html><a href='#'>Link</a></html>");
				String links8 = locations.get(7).getOsmLink();
				link8.addMouseListener(
						new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								openWebPage("https://www.openstreetmap.org/" + links8);
							}
						}
				);
				link8.setBounds(288, 542, 486, 14);
				add(link8);
			}

			remove(location9);
			remove(coordinate9);
			remove(link9);
			if (locations.size() >= 9) {
				location9 = new JLabel(locations.get(8).getName());
				location9.setBounds(66, 575, 708, 14);
				location9.setForeground(new Color(0, 153, 102));
				location9.setFont(new Font("Arial Narrow", Font.BOLD, 13));
				add(location9);

				coordinate9 = new JLabel("(" + locations.get(8).getCoordinate().getLatitude() + ", " + locations.get(8).getCoordinate().getLongitude() + ")");
				coordinate9.setBounds(288, 600, 486, 14);
				coordinate9.setForeground(new Color(0, 153, 102));
				coordinate9.setFont(new Font("Arial Narrow", Font.BOLD, 13));
				add(coordinate9);

				link9 = new JLabel("<html><a href='#'>Link</a></html>");
				String links9 = locations.get(8).getOsmLink();
				link9.addMouseListener(
						new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								openWebPage("https://www.openstreetmap.org/" + links9);
							}
						}
				);
				link9.setBounds(288, 613, 486, 14);
				add(link9);
			}

			remove(location10);
			remove(coordinate10);
			remove(link10);
			if (locations.size() >= 10) {
				location10 = new JLabel(locations.get(9).getName());
				location10.setBounds(66, 649, 708, 14);
				location10.setForeground(new Color(0, 153, 102));
				location10.setFont(new Font("Arial Narrow", Font.BOLD, 13));
				add(location10);

				coordinate10 = new JLabel("(" + locations.get(9).getCoordinate().getLatitude() + ", " + locations.get(9).getCoordinate().getLongitude() + ")");
				coordinate10.setBounds(288, 674, 486, 14);
				coordinate10.setForeground(new Color(0, 153, 102));
				coordinate10.setFont(new Font("Arial Narrow", Font.BOLD, 13));
				add(coordinate10);

				link10 = new JLabel("<html><a href='#'>Link</a></html>");
				String links10 = locations.get(9).getOsmLink();
				link10.addMouseListener(
						new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								openWebPage("https://www.openstreetmap.org/" + links10);
							}
						}
				);
				link10.setBounds(288, 688, 486, 14);
				add(link10);
			}
			remove(save);

			save = new JButton("Save A Location");
			save.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ArrayList<Object> userChoice = showSaveLocationDialog(displayingLocationsViewModel.getState().getLocations(), new ArrayList<>(displayingLabelsViewModel.getState().getLabels()));
					Location saved = (Location) userChoice.get(0);
					Label chosenLabel = (Label) userChoice.get(1);
					System.out.println(chosenLabel.getTitle());
					savingLocationController.execute(chosenLabel.getTitle(), saved.getName(), saved.getCoordinate().getLatitude(), saved.getCoordinate().getLongitude(), saved.getOsmLink(), saved.getFilter());
					JOptionPane.showMessageDialog(null, savingLocationViewModel.getState().getDisplayMsg());
				}
			});
			save.setBounds(37, 11, 197, 23);
			add(save);
			repaint();
		}
	}

	private static void openWebPage(String url) {
		try {
			Desktop.getDesktop().browse(new URI(url));
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
	}
}