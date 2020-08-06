import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class ShortestSubstringContainsChars {
    /* This is a really long name */
    private static HashMap<Character, Integer> charMap;
    private static int numContains; // <= set.size
    private static int left, right;

    // Initialize global variables
    public static String shortestSubstring(String s, HashSet<Character> charSet) {
	charMap = new HashMap<Character, Integer>();
	Iterator<Character> itr = charSet.iterator();
	while (itr.hasNext()) {
	    charMap.put(itr.next(), 0);
	}
	numContains = 0;
	left = 0;
	right = 0;
	return shortestSubstring(s);
    }

    /*
      Increment left if:
        1. leftChar isn't in set or
	2. leftChar is the same as rightChar (and char is desired) or
	3. we found a potential substring

      Increment left until:
        1. Conditions 1 and 2 are false
     */
    private static void incrementLeft(String s) {
	if (left == s.length() || right == s.length()) {
	    return;
	}
	char leftChar = s.charAt(left);
	char rightChar = s.charAt(right);
	if (charMap.containsKey(leftChar)) {
	    if (!(left != right && leftChar == rightChar)) {
		return;
	    }
	}
	
	// If statements too long so I made a while true statement
	while (true) {
	    if (left == s.length() || right == s.length()) {
		break;
	    }
	    leftChar = s.charAt(left);
	    rightChar = s.charAt(right);
	    if (charMap.containsKey(leftChar)) {
		if (!(left != right && leftChar == rightChar)) {
		    break;
		}
	    }

     	    left += 1;
	    if (left > right) right += 1;
	}
	if (charMap.get(leftChar) == 0) {
	    numContains += 1;
	}
	charMap.put(leftChar, charMap.get(leftChar) + 1);
    }

    private static String shortestSubstring(String s) {
        String shortest = null;
	while (right < s.length()) {
	    System.out.println(charMap);
	    System.out.println("left, right: " + left + ", " + right);
	    char rightChar = s.charAt(right);
	    char leftChar = s.charAt(left);

	    incrementLeft(s);

	    if (charMap.containsKey(rightChar)) {
		// Update HashMap and numContains
		int numChars = charMap.get(rightChar);
		if (numChars == 0) numContains += 1;
		charMap.put(rightChar, numChars + 1);

		// Case 2: All chracters in set found
		if (numContains == charMap.size()) {
		    System.out.println("numContains: " + numContains);
		    if (shortest == null || shortest.length() > right - left + 1) {
			shortest = s.substring(left, right+1);
		    }
		    // Increment left
		    charMap.put(leftChar, charMap.get(leftChar) - 1);
		    if (charMap.get(leftChar) == 0) {
			numContains -= 1;
		    }
		    left += 1;
		    if (left > right) right += 1;
		    continue;
		}
		
	    }
	    right += 1;
	}
	return shortest;
    }

    /* Testing */

    public static void main(String[] args) {
	String s = "figehaeci";
	System.out.println(s);
	HashSet<Character> chars = new HashSet<>();
	chars.add('a');
	chars.add('e');
	chars.add('i');
	System.out.println(shortestSubstring(s, chars));
    }
    
}
