package _04_HangMan;

import java.util.Stack;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JLabel;

public class HangMan implements KeyListener {
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	
	int wordCount;
	String dictionaryName = "dictionary.txt";
	int dictionaryLength = Utilities.getTotalWordsInFile(dictionaryName);
	
	ArrayList<String> alphabet = new ArrayList<String>(Arrays.asList(new String[] {"a", "b", "c", "c", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"}));
	ArrayList<String> answer;
	String[] letters;
	boolean dead = false;
	boolean end = false;
	
	ArrayList<String> arrayList = new ArrayList<String>();
	Stack<String> stack = new Stack<String>();
	
	Random random = new Random();
	static HangMan hangman = new HangMan();
	
	public static void main(String[] args) {
		hangman.setup();
		hangman.start();
	}
	
	void setup() {
		frame.setSize(1000, 1000);
		frame.addKeyListener(this);
		frame.add(panel);
		panel.add(label);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void start() {
		boolean ask = true;
		while(ask) {
			wordCount = Integer.parseInt(JOptionPane.showInputDialog("Enter an integer between 1 and " + dictionaryLength + " inclusive:\n"));
			if (1 <= wordCount && wordCount <= 266) {ask = false;}
		}
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(dictionaryName));
			for (int i = 0; i < dictionaryLength; i++) {
				arrayList.add(br.readLine());
			}	br.close();

		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Could not find file.", "ERROR", 1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < wordCount; i++) {
			stack.push(arrayList.get(random.nextInt(arrayList.size())));
			arrayList.remove(stack.get(stack.size() - 1));
		}
		
		answer = new ArrayList<String>(Arrays.asList(stack.pop().split("")));
		for (int i = 0; i < answer.size(); i++) {letters[i] = "_";}
		
		setLabel();
		
		/*
		if (dead) {JOptionPane.showMessageDialog(frame, "You Lose");}
		else {JOptionPane.showMessageDialog(frame, "YOU WIN");}
		*/
	}
	
	void finish() {
		
	}
	
	void update(String letter) {
		
		int change = 0;
		while (answer.contains(letter)) {
			letters[answer.indexOf(letter)] = letter;
			change += 1;
		}
		if (change == 0) {/*Take off one life*/}
		
		//Show letters guessed on a separate JLabel
		
		if (!setLabel().contains("_") || dead) {
			end = true;
			finish();
		}
	}
	
	String setLabel() {
		String word = "";
		for (String letter : letters) {word += letter + " ";}
		label.setText(word);
		frame.setVisible(true);
		return word;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (!end) {
			String letter = KeyEvent.getKeyText(e.getKeyCode()).toLowerCase();
			if (alphabet.contains(letter)) {update(letter);}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}