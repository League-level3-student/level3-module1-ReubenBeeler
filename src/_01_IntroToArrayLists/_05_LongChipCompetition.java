package _01_IntroToArrayLists;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class _05_LongChipCompetition {
	/**
	 * The Beatles are eating lunch and playing a game to see who has the longest
	 * chip. (In England, french fries are called "chips".) * Find the Beatle with
	 * the longest chip. You may not edit the Chip or Beatle classes. Make sure to
	 * initialize The Beatles before you start your search. *
	 **/
	private ArrayList<Beatle> theBeatles = new ArrayList<Beatle>();

	public static void main(String[] args) {
		_05_LongChipCompetition lcc = new _05_LongChipCompetition();
		lcc.initializeBeatles();
		float longestLength = (float) 0.0;
		String beatleName = "John Cena";
		for (Beatle beatle : lcc.getTheBand()) {
			for (Chip chip : beatle.getChips()) {
				if (chip.getLength() > longestLength) {
					longestLength = (float) chip.getLength();
					beatleName = beatle.getName();
				}
			}
		}
		System.out.printf("The Beatle with the longest chip is " + beatleName + ". A total length of %.3f mm.", longestLength);
	}
	
	private void initializeBeatles() {
		theBeatles.add(new Beatle("George"));
		theBeatles.add(new Beatle("John"));
		theBeatles.add(new Beatle("Paul"));
		theBeatles.add(new Beatle("Ringo"));
	}
	
	public ArrayList<Beatle> getTheBand(){
		return theBeatles;
	}
}

class Beatle {
	private String name;
	private ArrayList<Chip> chips = new ArrayList<Chip>();

	public Beatle(String name) {
		this.name = name;
		initializePlateOfChips();
	}

	private void initializePlateOfChips() {
		int numberOfChips = new Random().nextInt(10);
		for (int i = 0; i < numberOfChips; i++) {
			chips.add(new Chip(new Random().nextDouble() * 10));
		}
	}

	public ArrayList<Chip> getChips() {
		return this.chips;
	}

	public String getName() {
		return this.name;
	}
}

class Chip {
	private double length;

	public double getLength() {
		return length;
	}

	Chip(double d) {
		this.length = d;
	}
}
