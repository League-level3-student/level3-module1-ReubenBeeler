package _01_IntroToArrayLists;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class _02_GuestBook implements ActionListener {
	// Create a GUI with two buttons. One button reads "Add Name" and the other button reads "View Names". 
	// When the add name button is clicked, display an input dialog that asks the user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners

	JFrame frame = new JFrame("Guest Book Version 2.0");
	JPanel panel = new JPanel();
	
	JButton left = new JButton("Add Name");
	JButton right = new JButton("View Names");
	
	ArrayList<String> guests = new ArrayList<String>(0);
	ArrayList<JLabel> labels = new ArrayList<JLabel>(0);
	
	int guestCount = 0;
	
	public static void main(String[] args) {
		new _02_GuestBook().setup();
	}
	
	void setup() {
		frame.setSize(300, 400);
		frame.add(panel);
		
		left.addActionListener(this);
		right.addActionListener(this);
		
		panel.add(left);
		panel.add(right);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void addLabels() {
		for (JLabel label : labels) {panel.add(label);}
		frame.setVisible(true);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == left) {
			String name = JOptionPane.showInputDialog("Enter Name: ");
			guests.add(name);
			guestCount++;
			labels.add(new JLabel("Guest #" + guestCount + ": " + name));
		} else if (e.getSource() == right) {
			addLabels();
			if (labels.size() == 0) {
				panel.add(new JLabel("There are no guests on the Guest List"));
				frame.setVisible(true);
			}
		}
	}
}
