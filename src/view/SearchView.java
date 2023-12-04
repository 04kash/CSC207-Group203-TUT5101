package view;

import interface_adapter.apiReturns.ApiController;
import interface_adapter.apiReturns.ApiState;
import interface_adapter.apiReturns.ApiViewModel;
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
import java.awt.Font;

public class SearchView extends JPanel implements ActionListener, PropertyChangeListener {

	public static final String viewName = "search";
	public final ApiViewModel apiViewModel;
	public final ApiController apiController;
	public final DisplayingLocationsController displayingLocationsController;
	public final DisplayingLabelsController displayingLabelsController;
	private static final long serialVersionUID = 1L;
	private JTextField cityField;
	private String selectedFilter;
	private boolean apiControllerExecuted;
	private boolean displayingLocationsControllerExecuted;
	private boolean displayingLabelsControllerExecuted;

	/**
	 * Create the panel.
	 */
	public SearchView(ApiViewModel apiViewModel, ApiController apiController, DisplayingLocationsController displayingLocationsController, DisplayingLabelsController displayingLabelsController) {
		setBackground(new Color(245, 245, 245));
		this.setLayout(null);
		this.apiViewModel = apiViewModel;
		this.apiController = apiController;
		this.displayingLocationsController = displayingLocationsController;
		this.displayingLabelsController = displayingLabelsController;
		this.apiViewModel.addPropertyChangeListener(this);
		
		JButton home = new JButton("Go to Homepage");
		home.setForeground(new Color(245, 245, 245));
		home.setBackground(new Color(51, 153, 102));
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
		lblNewLabel.setForeground(new Color(51, 153, 102));
		lblNewLabel.setFont(new Font("Arial Narrow", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 114, 189, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Choose a filter:");
		lblNewLabel_1.setForeground(new Color(51, 153, 102));
		lblNewLabel_1.setFont(new Font("Arial Narrow", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 163, 123, 14);
		add(lblNewLabel_1);

		cityField = new JTextField("Search a location");
		cityField.setBounds(229, 111, 172, 20);
		add(cityField);
		cityField.setColumns(10);
		
		JList list = new JList();
		list.setBounds(199, 131, 0, 0);
		add(list);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(51, 153, 102));
		comboBox.setForeground(new Color(245, 245, 245));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"foods", "shops", "transport"}));
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
		enter.setBackground(new Color(51, 153, 102));
		enter.setForeground(new Color(245, 245, 245));
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
							apiControllerExecuted = true;

							displayingLocationsController.execute();
							displayingLocationsControllerExecuted = true;

							displayingLabelsController.execute();
							displayingLabelsControllerExecuted = true;
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

	public boolean isApiControllerExecuted() {
		return apiControllerExecuted;
	}

	public boolean isDisplayingLocationsControllerExecuted() {
		return displayingLocationsControllerExecuted;
	}

	public boolean isDisplayingLabelsControllerExecuted() {
		return displayingLabelsControllerExecuted;
	}
}
