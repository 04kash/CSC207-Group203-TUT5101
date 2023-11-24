package view;

import interface_adapter.api_returns.ApiState;
import interface_adapter.login.LoginState;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LoggedInView extends JPanel {

	public static final String viewName = "logged in";
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public LoggedInView() {
		this.setLayout(null);

		JButton locationSearch = new JButton("Search New Locations");
		locationSearch.setBounds(93, 78, 272, 23);
		add(locationSearch);

		locationSearch.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						ViewManager.showSearchView();
					}
				}
		);

		JButton planner = new JButton("View Your Planner");
		planner.setBounds(93, 139, 272, 23);
		add(planner);
//		planner.addActionListener(
//				new ActionListener() {
//					@Override
//					public void actionPerformed(ActionEvent e) {
//						ViewManager.showPlannerView();
//					}
//				}
//		);

		JButton logOut = new JButton("Log out");
		logOut.setBounds(93, 192, 272, 23);
		add(logOut);
		logOut.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						ViewManager.showLoginView();
					}
				}
		);
	}
}
