package _03_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class _02_TextUndoRedo implements KeyListener {
	/* 
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character is erased from the JLabel.
	 * Save that deleted character onto a Stack of Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed, the top Character is popped 
	 * off the Stack and added back to the JLabel.
	 * 
	 * */
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	
	Stack<Character> stack = new Stack<Character>();
	
	public static void main(String[] args) {
		new _02_TextUndoRedo().setup();
	}
	
	void setup() {
		frame.setSize(500, 500);
		frame.addKeyListener(this);
		frame.add(panel);
		panel.add(label);
		
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void delete() {
		stack.push(label.getText().charAt(label.getText().length() - 1));
		label.setText(label.getText().substring(0, label.getText().length() - 2));
	}
	
	void undo() {
		if (stack.size() > 0) {
			label.setText(label.getText() + stack.pop());
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			delete();
			System.out.println("Delete");
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			undo();
			System.out.println("Undo");
		} else {
			label.setText(label.getText() + e.getKeyChar());
		}	frame.setVisible(true);
	}
	
}
