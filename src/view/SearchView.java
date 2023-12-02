package view;

import interface_adapter.api_returns.ApiController;
import interface_adapter.api_returns.ApiState;
import interface_adapter.api_returns.ApiViewModel;
import interface_adapter.displayingLabels.DisplayingLabelsController;
import interface_adapter.displayingLocations.DisplayingLocationsController;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SearchView extends JPanel implements ActionListener, PropertyChangeListener {

	public static final String viewName = "search";
	public final ApiViewModel apiViewModel;
	public final ApiController apiController;
	public final DisplayingLocationsController displayingLocationsController;
	public final DisplayingLabelsController displayingLabelsController;
	private static final long serialVersionUID = 1L;
	private JTextField cityField;
	private String selectedFilter;

	/**
	 * Create the panel.
	 */
	public SearchView(ApiViewModel apiViewModel, ApiController apiController, DisplayingLocationsController displayingLocationsController, DisplayingLabelsController displayingLabelsController) {
		setBackground(new Color(204, 255, 255));
		this.setLayout(null);
		this.apiViewModel = apiViewModel;
		this.apiController = apiController;
		this.displayingLocationsController = displayingLocationsController;
		this.displayingLabelsController = displayingLabelsController;
		this.apiViewModel.addPropertyChangeListener(this);
		
		JButton home = new JButton("Go to Homepage");
		home.setForeground(new Color(0, 0, 0));
		home.setBackground(new Color(0, 0, 0));
		home.setBounds(289, 11, 151, 23);
		add(home);
		home.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						ViewManager.showLoggedinView();
					}
				}
		);
		
		JLabel lblNewLabel = new JLabel("Enter city name:");
		lblNewLabel.setBounds(10, 114, 189, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Choose a filter:");
		lblNewLabel_1.setBounds(10, 163, 123, 14);
		add(lblNewLabel_1);

		cityField = new JTextField();
		cityField.setBounds(229, 111, 172, 20);
		add(cityField);
		cityField.setColumns(10);
		
		JList list = new JList();
		list.setBounds(199, 131, 0, 0);
		add(list);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"interesting_places", "banks ", "foods", "shops", "transport"}));
		comboBox.setBounds(229, 159, 172, 22);
		add(comboBox);
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Update the selected filter when the user makes a selection
				selectedFilter = (String) comboBox.getSelectedItem();
			}
		});
		
		JButton enter = new JButton("Enter");
		enter.setBounds(188, 227, 89, 23);
		add(enter);
		enter.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent evt) {
						if (evt.getSource().equals(enter)) {
							ApiState currentState = apiViewModel.getState();

							apiController.execute(
									cityField.getText(), selectedFilter
							);
							displayingLocationsController.execute();
							displayingLabelsController.execute();
						}
					}
				}
		);
	}
	public void actionPerformed(ActionEvent evt) {
		System.out.println("Click " + evt.getActionCommand());
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	}

	public ApiViewModel getCurrentViewModel() {
		return apiViewModel;
	}
}
