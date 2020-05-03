package _04_HangMan;

import java.util.Stack;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JLabel;

public class HangMan implements KeyListener {
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel tank = new JLabel();
	JLabel usedLettersLabel = new JLabel();
	JLabel lifeCounter = new JLabel();
	
	int wordCount;
	String dictionaryName = "dictionary.txt";
	int dictionaryLength = Utilities.getTotalWordsInFile(dictionaryName);
	
	ArrayList<String> alphabet;
	String answer;
	ArrayList<String> answerSplit;
	ArrayList<String> usedLetters;
	String[] letters;
	boolean end;
	int lives;
	
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
		panel.add(tank);
		panel.add(usedLettersLabel);
		panel.add(lifeCounter);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
	}
	
	void start() {
		end = false;
		lives = 8;
		alphabet = new ArrayList<String>(Arrays.asList(new String[] {"a", "b", "c", "c", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"}));
		usedLetters = new ArrayList<String>();
		
		answer = stack.pop();
		answerSplit = new ArrayList<String>(Arrays.asList(answer.split("")));
		letters = new String[answerSplit.size()];
		for (int i = 0; i < answerSplit.size(); i++) {letters[i] = "_";}
		
		setTank();
		setLifeCounter();
		setUsedLetters();
	}
	
	void finish() {
		if (lives == 0) {JOptionPane.showMessageDialog(frame, "You lose. The word is \"" + answer + "\"");}
		else {JOptionPane.showMessageDialog(frame, "You win! Nice");}
		start();
	}
	
	void update(String letter) {
		
		boolean correct = false;
		while (answerSplit.contains(letter)) {
			letters[answerSplit.indexOf(letter)] = letter;
			answerSplit.set(answerSplit.indexOf(letter), "_");
			correct = true;
		}
		if (correct) {setTank();}
		else {lives -= 1; setLifeCounter();}
		setUsedLetters();
		
		if (!setTank().contains("_") || lives == 0) {
			end = true;
			finish();
		}
	}
	
	String setTank() {
		String word = "";
		for (String letter : letters) {word += letter + " ";}
		tank.setText(word);
		frame.setVisible(true);
		return word;
	}
	
	void setLifeCounter() {
		String string = "";
		for (int i = 0; i < lives; i++) {string += " O";}
		lifeCounter.setText("\t\tLives:" + string);
		frame.setVisible(true);
	}
	
	void setUsedLetters() {
		String list = "";
		for (String usedLetter : usedLetters) {list += " " + usedLetter;}
		usedLettersLabel.setText("\t\tUsed Letters:" + list);
		frame.setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (!end) {
			String letter = KeyEvent.getKeyText(e.getExtendedKeyCode()).toLowerCase();
			if (alphabet.contains(letter)) {alphabet.remove(letter); usedLetters.add(letter); update(letter);}
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