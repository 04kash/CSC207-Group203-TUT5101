package view;
import entity.Location;
import interface_adapter.api_returns.ApiViewModel;
import interface_adapter.displayingLocations.DisplayingLocationsController;
import interface_adapter.displayingLocations.DisplayingLocationsViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class LocationView extends JPanel implements ActionListener, PropertyChangeListener {

	public DisplayingLocationsViewModel displayingLocationsViewModel;
	public DisplayingLocationsController displayingLocationsController;
	public static final String viewName = "location view";
//	public static ApiViewModel displayingLocationsViewModel;
	private static final long serialVersionUID = 1L;
//	private static JLabel location1;

	/**
	 * Create the panel.
	 */
	public LocationView(DisplayingLocationsViewModel displayingLocationsViewModel, DisplayingLocationsController displayingLocationsController){
		this.setLayout(null);
		this.displayingLocationsController = displayingLocationsController;
		this.displayingLocationsViewModel = displayingLocationsViewModel;
		this.displayingLocationsViewModel.addPropertyChangeListener(this);
		ArrayList<Location> locations = new ArrayList<>();
		if (!displayingLocationsViewModel.getState().getLocations().isEmpty()) {
			locations = displayingLocationsViewModel.getState().getLocations();
			System.out.println(locations);
			System.out.println(locations.get(0).getName());

			JLabel location1 = new JLabel(locations.get(0).getName());
			location1.setBounds(66, 45, 708, 14);
			add(location1);
			repaint();
		}
		else {
			JLabel location1 = new JLabel("Location1");
			location1.setBounds(66, 45, 708, 14);
			add(location1);
		}

		JButton save = new JButton("Save A Location");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showSaveLocationDialog();
			}
		});
		save.setBounds(37, 11, 197, 23);
		add(save);


		JButton home = new JButton("Go to HomePage");
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewManager.showLoggedinView();
			}
		});
		home.setBounds(465, 11, 160, 23);
		add(home);

		JLabel heading = new JLabel("Suggested Places");
		heading.setFont(new Font("Tahoma", Font.PLAIN, 18));
		heading.setBounds(270, 11, 279, 39);
		add(heading);


		JLabel location1Label = new JLabel("1.");
		location1Label.setBounds(26, 45, 17, 14);
		add(location1Label);


//		location1 = new JLabel("Location1");
//		location1.setBounds(66, 45, 708, 14);
//		add(location1);


		JLabel location1coordinate = new JLabel("Coordinates");
		location1coordinate.setBounds(66, 70, 160, 14);
		add(location1coordinate);

		JLabel coordinate1 = new JLabel("C1");
		coordinate1.setBounds(288, 70, 486, 14);
		add(coordinate1);

		JLabel location1link = new JLabel("Link to OpenStreetMap:");
		location1link.setBounds(66, 80, 212, 14);
		add(location1link);

		JLabel link1 = new JLabel("Link1");
		link1.setBounds(288, 80, 486, 14);
		add(link1);

		JLabel location2label = new JLabel("2.");
		location2label.setBounds(26, 105, 17, 14);
		add(location2label);

		JLabel location2 = new JLabel("Location2");
		location2.setBounds(66, 105, 690, 14);
		add(location2);

		JLabel location2coordinate = new JLabel("Coordinates");
		location2coordinate.setBounds(66, 130, 160, 14);
		add(location2coordinate);

		JLabel coordinate2 = new JLabel("C2");
		coordinate2.setBounds(288, 130, 486, 14);
		add(coordinate2);

		JLabel location2Link = new JLabel("Link to OpenStreetMap:");
		location2Link.setBounds(66, 141, 212, 14);
		add(location2Link);

		JLabel link2 = new JLabel("Link2");
		link2.setBounds(288, 141, 495, 14);
		add(link2);

		JLabel location3label = new JLabel("3.");
		location3label.setBounds(26, 166, 17, 14);
		add(location3label);

		JLabel location3 = new JLabel("Location3");
		location3.setBounds(66, 166, 690, 14);
		add(location3);

		JLabel location3coordinate = new JLabel("Coordinates");
		location3coordinate.setBounds(66, 191, 160, 14);
		add(location3coordinate);

		JLabel coordinate3 = new JLabel("C3");
		coordinate3.setBounds(288, 191, 486, 14);
		add(coordinate3);

		JLabel location3link = new JLabel("Link to OpenStreetMap:");
		location3link.setBounds(66, 202, 212, 14);
		add(location3link);

		JLabel link3 = new JLabel("Link3");
		link3.setBounds(288, 202, 496, 14);
		add(link3);

		JLabel location4label = new JLabel("4.");
		location4label.setBounds(26, 234, 17, 14);
		add(location4label);

		JLabel location4 = new JLabel("Location4");
		location4.setBounds(66, 234, 690, 14);
		add(location4);

		JLabel location4coordinate = new JLabel("Coordinates");
		location4coordinate.setBounds(66, 259, 160, 14);
		add(location4coordinate);

		JLabel coordinate4 = new JLabel("C4");
		coordinate4.setBounds(288, 259, 486, 14);
		add(coordinate4);

		JLabel location4link = new JLabel("Link to OpenStreetMap:");
		location4link.setBounds(66, 271, 212, 14);
		add(location4link);

		JLabel link4 = new JLabel("Link4");
		link4.setBounds(288, 271, 486, 14);
		add(link4);

		JLabel location5label = new JLabel("5.");
		location5label.setBounds(26, 296, 17, 14);
		add(location5label);

		JLabel location5 = new JLabel("Location5");
		location5.setBounds(66, 296, 690, 14);
		add(location5);

		JLabel location5coordinate = new JLabel("Coordinates");
		location5coordinate.setBounds(66, 321, 160, 14);
		add(location5coordinate);

		JLabel coordinate5 = new JLabel("C5");
		coordinate5.setBounds(288, 321, 486, 14);
		add(coordinate5);

		JLabel location5link = new JLabel("Link to OpenStreetMap:");
		location5link.setBounds(66, 333, 212, 14);
		add(location5link);

		JLabel link5 = new JLabel("Link5");
		link5.setBounds(288, 333, 486, 14);
		add(link5);

		JLabel location6label = new JLabel("6.");
		location6label.setBounds(26, 366, 17, 14);
		add(location6label);

		JLabel location6 = new JLabel("Location6");
		location6.setBounds(66, 366, 708, 14);
		add(location6);

		JLabel location6coordinate = new JLabel("Coordinates");
		location6coordinate.setBounds(66, 391, 160, 14);
		add(location6coordinate);

		JLabel coordinate6 = new JLabel("C6");
		coordinate6.setBounds(288, 391, 486, 14);
		add(coordinate6);

		JLabel location6link = new JLabel("Link to OpenStreetMap:");
		location6link.setBounds(66, 405, 212, 14);
		add(location6link);

		JLabel link6 = new JLabel("Link6");
		link6.setBounds(288, 405, 486, 14);
		add(link6);

		JLabel location7label = new JLabel("7.");
		location7label.setBounds(26, 438, 17, 14);
		add(location7label);

		JLabel location7 = new JLabel("Location7");
		location7.setBounds(66, 438, 690, 14);
		add(location7);

		JLabel location7coordinate = new JLabel("Coordinates");
		location7coordinate.setBounds(66, 463, 160, 14);
		add(location7coordinate);

		JLabel coordinate7 = new JLabel("C7");
		coordinate7.setBounds(288, 463, 486, 14);
		add(coordinate7);

		JLabel location7link = new JLabel("Link to OpenStreetMap:");
		location7link.setBounds(66, 477, 212, 14);
		add(location7link);

		JLabel link7 = new JLabel("Link7");
		link7.setBounds(288, 477, 486, 14);
		add(link7);

		JLabel location8label = new JLabel("8.");
		location8label.setBounds(26, 504, 17, 14);
		add(location8label);

		JLabel location8 = new JLabel("Location8");
		location8.setBounds(66, 504, 708, 14);
		add(location8);

		JLabel location8coordinate = new JLabel("Coordinates");
		location8coordinate.setBounds(66, 529, 160, 14);
		add(location8coordinate);

		JLabel coordinate8 = new JLabel("C8");
		coordinate8.setBounds(288, 529, 486, 14);
		add(coordinate8);

		JLabel location8link = new JLabel("Link to OpenStreetMap:");
		location8link.setBounds(66, 542, 212, 14);
		add(location8link);

		JLabel link8 = new JLabel("Link8");
		link8.setBounds(288, 542, 486, 14);
		add(link8);

		JLabel location9label = new JLabel("9.");
		location9label.setBounds(26, 575, 17, 14);
		add(location9label);

		JLabel location9 = new JLabel("Location9");
		location9.setBounds(66, 575, 708, 14);
		add(location9);

		JLabel location9coordinate = new JLabel("Coordinates");
		location9coordinate.setBounds(66, 600, 160, 14);
		add(location9coordinate);

		JLabel coordinate9 = new JLabel("C9");
		coordinate9.setBounds(288, 600, 486, 14);
		add(coordinate9);

		JLabel location9link = new JLabel("Link to OpenStreetMap:");
		location9link.setBounds(66, 613, 212, 14);
		add(location9link);

		JLabel link9 = new JLabel("Link9");
		link9.setBounds(288, 613, 486, 14);
		add(link9);

		JLabel location10label = new JLabel("10.");
		location10label.setBounds(26, 649, 17, 14);
		add(location10label);

		JLabel location10 = new JLabel("Location10");
		location10.setBounds(66, 649, 708, 14);
		add(location10);

		JLabel location10coordinate = new JLabel("Coordinates");
		location10coordinate.setBounds(66, 674, 160, 14);
		add(location10coordinate);

		JLabel coordinate10 = new JLabel("C10");
		coordinate10.setBounds(288, 674, 486, 14);
		add(coordinate10);

		JLabel location10link = new JLabel("Link to OpenStreetMap:");
		location10link.setBounds(66, 688, 212, 14);
		add(location10link);

		JLabel link10 = new JLabel("Link10");
		link10.setBounds(288, 688, 486, 14);
		add(link10);
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

	public void actionPerformed(ActionEvent evt) {
		System.out.println("Click " + evt.getActionCommand());
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	}
}



