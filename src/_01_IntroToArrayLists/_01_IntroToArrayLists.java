package _01_IntroToArrayLists;

import java.util.ArrayList;
import java.util.Arrays;

public class _01_IntroToArrayLists {
	public static void main(String[] args) {
		//1. Create an array list of Strings
		//   Don't forget to import the ArrayList class
		ArrayList<String> arraylist = new ArrayList<String>(0);

		//2. Add five Strings to your list
		for (int i = 0; i < 5; i++) {
			arraylist.add(new String[] {"H", "e", "l", "l", "o"}[i]);
		}
		
		//3. Print all the Strings using a standard for-loop
		for (int i = 0; i < arraylist.size(); i++) {
			System.out.print(arraylist.get(i));
		}
		
		System.out.println();
		
		//4. Print all the Strings using a for-each loop
		for (String string : arraylist) {
			System.out.print(string);
		}

		System.out.println();
		
		//5. Print only the even numbered elements in the list.
		for (int i = 0; i < arraylist.size(); i++) {
			if (i % 2 == 1) {System.out.print(arraylist.get(i));}
		}
		
		System.out.println();
		
		//6. Print all the Strings in reverse order.
		for (int i = arraylist.size() - 1; i >= 0; i--) {
			System.out.print(arraylist.get(i));
		}
		
		System.out.println();
		
		//7. Print only the Strings that have the letter 'e' in them.
		for (String string : arraylist) {
			ArrayList<String> split = new ArrayList<String>(Arrays.asList(string.split("")));
			if (split.contains("e")) {System.out.print(string);}
		}
	}
}
