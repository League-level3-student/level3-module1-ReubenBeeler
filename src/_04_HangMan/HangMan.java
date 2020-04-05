package _04_HangMan;

import java.util.Stack;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JLabel;

public class HangMan {
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	
	int wordCount;
	String dictionaryName = "_04_HangMan_Instructions.html";
	int dictionaryLength = Utilities.getTotalWordsInFile(dictionaryName);
	
	String[] word;
	
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
		
		word = new String[stack.pop().length()];
		for (int i = 0; i < word.length; i++) {word[i] = "_";}
		
	}
	
	void changeLabel() {
		String text = "";
		for (int i = 0; i < word.length; i++) {
			text += word[i] + " ";
		}
		label.setText(text);
		frame.setVisible(true);
	}
	
}