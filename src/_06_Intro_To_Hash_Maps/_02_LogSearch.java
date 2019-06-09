package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
  /* 
	 * Crate a HashMap of Integers for the keys and Strings for the values.
	 * Create a GUI with three buttons. 
	 * Button 1: Add Entry
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				After an ID is entered, use another input dialog to ask the user to enter a name.
	 * 				Add this information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				If that ID exists, display that name to the user.
	 * 				Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List
	 * 				When this button is clicked, display the entire list in a message dialog in the following format:
	 * 				ID: 123  Name: Harry Howard
	 * 				ID: 245  Name: Polly Powers
	 * 				ID: 433  Name: Oliver Ortega
	 * 				etc...
	 * 
	 * When this is complete, add a fourth button to your window.
	 * Button 4: Remove Entry
	 * 				When this button is clicked, prompt the user to enter an ID using an input dialog.
	 * 				If this ID exists in the HashMap, remove it. Otherwise, notify the user that the ID
	 * 				is not in the list. 
	 *
	 * */
	
	JFrame frame;
	JPanel panel;
	JButton addEntry;
	JButton searchID;
	JButton viewList;
	JButton removeEntry;
	HashMap<Long, String> information = new HashMap<Long, String>();
	
	public static void main(String[] args) {
		_02_LogSearch ls = new _02_LogSearch();
		ls.setup();
	}
	
	void setup() {
		frame = new JFrame();
		panel = new JPanel();
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addEntry = new JButton();
		addEntry.setText("Add Entry");
		addEntry.addActionListener(this);
		panel.add(addEntry);
		searchID = new JButton();
		searchID.setText("Search by ID");
		searchID.addActionListener(this);
		panel.add(searchID);
		viewList = new JButton();
		viewList.setText("View List");
		viewList.addActionListener(this);
		panel.add(viewList);
		removeEntry = new JButton();
		removeEntry.setText("Remove Entry");
		removeEntry.addActionListener(this);
		panel.add(removeEntry);
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton source = (JButton) e.getSource();
		if(source == addEntry) {
			enterEntry();
		}
		else if(source == searchID) {
			searchInformation();
		}
		else if(source == viewList) {
			printInformation();
		}
		else if(source == removeEntry) {
			removeFromInformation();
		}
	}
	
	void enterEntry() {
		String newIDStr = JOptionPane.showInputDialog("Enter the ID.");
		String name = JOptionPane.showInputDialog("Enter the name.");
		long newID;
		try {
			newID = Long.valueOf(newIDStr);
			
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(frame, "The ID couldn't be read as a number");
			return;
		}
		if(information.containsKey(newID)) {
			int continueAnswer = JOptionPane.showConfirmDialog(frame, "The ID already exists. Click Yes if you want to continue by changing the name of the existing ID.");
			System.out.println(continueAnswer);
			if(continueAnswer != 0) {
				return;
			}
		}
		information.put(newID, name);
		JOptionPane.showMessageDialog(frame, "The ID "+newID+" has been set to the name "+name);
	}
	
	void searchInformation() {
		String searchStr = JOptionPane.showInputDialog("Enter the ID you want to search for.");
		long idSearch;
		try {
			idSearch = Long.valueOf(searchStr);
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(frame, "The ID couldn't be read");
			return;
		}
		if(information.containsKey(idSearch)) {
			JOptionPane.showMessageDialog(frame, "ID: "+idSearch+"\n"+"Name: "+information.get(idSearch));
		}
		else {
			JOptionPane.showMessageDialog(frame, "The ID doesn't exist");
			return;
		}
	}
	
	void printInformation() {
		if(information.isEmpty() == true) {
			JOptionPane.showMessageDialog(frame, "There are no entries.");
			return;
		}
		String toPrint = "";
		for(int j = 0; j < information.size(); j++) {
			long anID = (long) information.keySet().toArray()[j];	
			String aName = information.get(anID);
			toPrint = toPrint + "ID: "+anID+" Name: "+aName+"\n";
		}
		JOptionPane.showMessageDialog(frame, toPrint);
	}
	
	void removeFromInformation() {
		String idStr = JOptionPane.showInputDialog("What is the ID of the name you want to remove?");
		long removeID;
		try {
			removeID = Long.valueOf(idStr);
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(frame, "The ID couldn't be read.");
			return;
		}
		if(information.containsKey(removeID)) {
			String name = information.get(removeID);
			information.remove(removeID);
			JOptionPane.showMessageDialog(frame, "The ID "+removeID+" (with the name of "+name+") has been removed.");
		}
		else {
			JOptionPane.showMessageDialog(frame, "The ID doesn't exist.");
		}
	}
	
	
}
