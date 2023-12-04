package view;

import interface_adapter.displayingLabels.DisplayingLabelsController;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.Color;

public class LoggedInView extends JPanel implements ActionListener, PropertyChangeListener {

	public static final String viewName = "logged in";
	private static final long serialVersionUID = 1L;
	public final DisplayingLabelsController displayingLabelsController;

	private boolean changeInView;

	/**
	 * Create the panel.
	 */
	public LoggedInView(DisplayingLabelsController displayingLabelsController) {
		setBackground(new Color(245, 245, 245));
		this.displayingLabelsController=displayingLabelsController;
		this.setLayout(null);
		this.changeInView = false;

		JButton locationSearch = new JButton("Search New Locations");
		locationSearch.setForeground(new Color(245, 245, 245));
		locationSearch.setBackground(new Color(51, 153, 102));
		locationSearch.setBounds(93, 78, 272, 23);
		add(locationSearch);

		locationSearch.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						ViewManager.showSearchView();
						changeInView = true;
					}
				}
		);

		JButton planner = new JButton("View Your Planner");
		planner.setForeground(new Color(245, 245, 245));
		planner.setBackground(new Color(51, 153, 102));
		planner.setBounds(93, 139, 272, 23);
		add(planner);
		planner.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						ViewManager.showPlannerView();
						displayingLabelsController.execute();
						changeInView = true;
					}
				}
		);

		JButton logOut = new JButton("Log out");
		logOut.setForeground(new Color(245, 245, 245));
		logOut.setBackground(new Color(51, 153, 102));
		logOut.setBounds(93, 192, 272, 23);
		add(logOut);
		logOut.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						ViewManager.showLoginView();
						changeInView = true;
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

	public boolean isChangeInView() {
		return changeInView;
	}
}
