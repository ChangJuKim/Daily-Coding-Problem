/*
  Error in the fundamental solution. Thrown out
 */

public class createPalindromeFirstAttempt {

    // insert(word, 1, 'X') = wXord
    public static String insert(String string, int index, char toBeInserted) {
	if (index == 0) { return "" + toBeInserted + string; }
	if (index == string.length()) { return string + toBeInserted; }
	return string.substring(0, index) + toBeInserted + string.substring(index);
    }

    // insert(word, 1, 'X') = wXorXd
    public static String insertBothWays(String word, int index, char toBeInserted) {
	if (index == 0 || index == word.length()) { return "" + toBeInserted + word + toBeInserted; }
	// insert right side first
	String result = word.substring(0, word.length() - index) + toBeInserted + word.substring(word.length() - index);
	// insert left side
	result = result.substring(0, index) + toBeInserted + result.substring(index);
	return result;
    }

    // Makes a palindrome using ith index as the middle. Makes alphanumerically first one
    // If i is part of a pair, then uses the middle of pair as middle
    // E.g. case 1: (abz, 1). Returns azbza.
    //      case 2: (abbz, 1). Returns azbbza. NOT abzbzba
    // Will assume word is lower case. Will handle upper case later
    // Can't handle words with 3+ identical letters in a row
    public static String makePalindrome(String word, int middle) {
	// Edge cases
	if (word.length() <= 1) {
	    return word;
	}
	if (middle < 0 || middle >= word.length()) {
	    System.out.println("Invalid index. Error.");
	}

	// result = middle character(s) and builds up from there
	String result = "" + word.charAt(middle);
	// if middle is not part of a pair (e.g. 'abc'), middle2 = middle
	// Otherwise, (e.g. 'abbc') middle2 = middle + 1
	int middle2 = middle;
	
	// See if the middle is part of a pair
	while (middle > 0 && word.charAt(middle) == word.charAt(middle - 1)) {
	    result += word.charAt(middle); // 2 characters long
	    middle -= 1;
	}
	while (middle2 < word.length() - 1 && word.charAt(middle2) == word.charAt(middle2 + 1)) {
	    result += word.charAt(middle2);
	    middle2 += 1;
	}

	// append other characters around result
	int lIndex = 0;
	int rIndex = word.length() - 1;
	int resultIndex = 0;
	//System.out.println("(middle, middle2): (" + middle + ", " + middle2 + ")");
	while (lIndex < middle || rIndex > middle2) {
	    //System.out.println("  Result is currently: " + result);
	    //System.out.println("  (lIndex, rIndex): (" + lIndex + ", " + rIndex + ")");
	    if (lIndex != middle && rIndex != middle2 && word.charAt(lIndex) == word.charAt(rIndex)) {
		// Adding same letter (add both indicies)
		System.out.println("CASE 1");
		result = insertBothWays(result, resultIndex, word.charAt(lIndex));
		lIndex += 1;
		rIndex -= 1;
	    } else if (lIndex == middle || (rIndex != middle2 && word.charAt(lIndex) > word.charAt(rIndex))) {
		// Add the right index
	        System.out.println("CASE 2");
		result = insertBothWays(result, resultIndex, word.charAt(rIndex));
		rIndex -= 1;
	    } else if (rIndex == middle2 || word.charAt(lIndex) < word.charAt(rIndex)) {
		// Add the left index
		System.out.println("CASE 3");
		result = insertBothWays(result, resultIndex, word.charAt(lIndex));
		lIndex += 1;
	    }
	    resultIndex += 1;
	}
	return result;
    }

    public static String shortestPalindrome(String word) {
	String shortest = makePalindrome(word, 0);
	for (int i = 1; i < word.length(); i++) {
	    String temp = makePalindrome(word, i);
	    // compare length
	    if (temp.length() < shortest.length()) {
		shortest = temp;
	    } else if (temp.length() == shortest.length()) {
		System.out.println("Shortest: " + shortest + " - temp: " + temp);
		// compare alphanumerically
		if (shortest.compareTo(temp) > 0) {
		    shortest = temp;
		}
	    }
	}
	return shortest;
    }

    public static void main(String[] args) {
	String word = "gaoogle";
	System.out.println("word: " + word);
	System.out.println("Shortest palinrome: " + shortestPalindrome(word));
	
    }
}
