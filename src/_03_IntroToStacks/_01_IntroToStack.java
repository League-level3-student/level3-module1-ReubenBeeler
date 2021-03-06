package _03_IntroToStacks;

import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class _01_IntroToStack {
	public static void main(String[] args) {
		
		Random random = new Random();
		
		//1. Create a Stack of Doubles
		//   Don't forget to import the Stack class
		
		Stack<Double> stack = new Stack<Double>();
		
		//2. Use a loop to push 100 random doubles between 0 and 100 to the Stack.
		for (int i = 0; i < 100; i++) {
			stack.push(100 * random.nextDouble());
		}
		
		//3. Ask the user to enter in two numbers between 0 and 100, inclusive. 
		double num1 = Double.parseDouble(JOptionPane.showInputDialog("Enter a number within [0, 100)"));
		double num2 = Double.parseDouble(JOptionPane.showInputDialog("Enter a 2nd number within [0, 100)"));
		
		
		//4. Pop all the elements off of the Stack. Every time a double is popped that is
		//   between the two numbers entered by the user, print it to the screen.
		
		
		//   EXAMPLE:
		//   NUM 1: 65
		//   NUM 2: 75
		
		//   Popping elements off stack...
		//   Elements between 65 and 75:
		//   66.66876846
		//   74.51651681
		//   70.05110654
		//   69.21350456
		//   71.54506465
		//   66.47984807
		//   74.12121224
		
		for (int i = stack.size() - 1; i >= 0; i--) {
			if ((num1 <= stack.get(i) && stack.get(i) <= num2) || (num2 <= stack.get(i) && stack.get(i) <= num1)) {System.out.println(stack.pop());}
			else {stack.pop();}
		}
		
	}
}
