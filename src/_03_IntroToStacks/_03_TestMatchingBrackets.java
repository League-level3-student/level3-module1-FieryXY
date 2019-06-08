package _03_IntroToStacks;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Arrays;
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
	private boolean doBracketsMatch(String b) {
		
		char[] temp = b.toCharArray();
		Stack<Character> characters = new Stack<Character>();
		int needed = 0;
		
		for(int j = 0; j < b.length(); j++) {
			characters.push(temp[j]);
		}
		for(int i = 0; i < b.length(); i++) {
			char poppedValue = characters.pop();
			 if(poppedValue == '{') {		 
				 if(needed > 0) {
					 needed--;
				 }
				 else {
					 return false;
				 }
			}
			if(poppedValue == '}') {
					needed++;
			}
	
		}
		if(needed <= 0) {
			return true;
		}
		else {
			return false;
		}
		
		
		
	}

}