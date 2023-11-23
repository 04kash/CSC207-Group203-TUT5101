package view;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoggedInView extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public LoggedInView() {
		this.setLayout(null);
		
		JButton btnNewButton = new JButton("Search New Locations");
		btnNewButton.setBounds(93, 78, 272, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View Your Planner");
		btnNewButton_1.setBounds(93, 139, 272, 23);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Log out");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(93, 192, 272, 23);
		add(btnNewButton_2);

	}
}
