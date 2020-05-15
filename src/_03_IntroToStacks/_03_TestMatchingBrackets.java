package _03_IntroToStacks;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

public class _03_TestMatchingBrackets {

	@Test
	public void testMatchingBrackets() {
		assertTrue(doBracketsMatch("{}"));
		assertTrue(doBracketsMatch("{{}}"));
		assertTrue(doBracketsMatch("{}{}{{}}"));
		assertFalse(doBracketsMatch("{{}"));
		assertFalse(doBracketsMatch("}{"));
	}

	// USE A STACK TO COMPLETE THE METHOD FOR CHECKING IF EVERY OPENING BRACKET HAS A MATCHING CLOSING BRACKET
	private boolean doBracketsMatch(String brackets) {
		String[] bracketArray = brackets.split("");
		Stack<String> stack = new Stack<String>();
		for (String bracket : bracketArray) {
			if (bracket.equals("{")) {
				stack.add("{");
			} else if (bracket.equals("}") && stack.size() > 0) {
				stack.pop();
			} else if (bracket.equals("}")) {
				return false;
			}
		}
		
		if (stack.size() == 0) {return true;} else {return false;}
	}

}