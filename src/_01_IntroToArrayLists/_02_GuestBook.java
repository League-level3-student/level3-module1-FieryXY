package _01_IntroToArrayLists;

import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener {
	// Create a GUI with two buttons. One button reads "Add Name" and the other button reads "View Names". 
	// When the add name button is clicked, display an input dialog that asks the user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners
	
	JFrame window;
	JPanel panel;
	JButton viewNames;
	JButton addName;
	ArrayList<String> names;
	
	public void run() {
		window = new JFrame();
		panel = new JPanel();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		names = new ArrayList<String>();
		defaultNames();
		window.add(panel);
		viewNames = new JButton();
		viewNames.setText("View Names");
		panel.add(viewNames);
		viewNames.addActionListener(this);
		addName = new JButton();
		addName.setText("Add Name");
		panel.add(addName);
		addName.addActionListener(this);
		window.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();
		if(source == viewNames) {
			displayNames();
		}
		else if(source == addName) {
			addElement();
		}
	}
	void defaultNames() {
		names.clear();
		names.add("Bob Banders");
		names.add("Sandy Summers");
		names.add("Greg Ganders");
		names.add("Donny Doners");
	}
	void displayNames() {
		String fullDisplay = "";
		for(int j = 0; j < names.size(); j++) {
			fullDisplay = fullDisplay + names.get(j) + "\n";
		}
		JOptionPane.showMessageDialog(null, fullDisplay);
	}
	void addElement() {
		String newName = JOptionPane.showInputDialog("What is the name of the guest?");
		names.add(newName);
		displayNames();
	}
	
}
