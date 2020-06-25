import java.util.ArrayList;
import java.util.HashSet;

public class StringToSentence {
    private static boolean[] alreadyLookedThrough; // size = length of message
    private static HashSet<String> dictionary;
    

    // Looks to see if the rest of the message (message.substring(startIndex)) is a word.
    // If you find a subword within the message, recurses on it
    public static ArrayList<String> convertToSentence(String message, int startIndex, ArrayList<String> currentWords) {
	// Test if the rest of the message is a word
	String updatedMessage = message.substring(startIndex);
        if (dictionary.contains(updatedMessage)) {
	    currentWords.add(updatedMessage);
	    return currentWords;
	}
	
	// Find a word
	// For loop is on message and not updateMessage because the index needs to match alreadyLookedThrough
	for (int endIndex = startIndex + 1; endIndex < message.length(); endIndex++) {
	    String potentialWord = message.substring(startIndex, endIndex);
	    if (dictionary.contains(potentialWord)) {
		if (alreadyLookedThrough[endIndex] == false) {
		    alreadyLookedThrough[endIndex] = true;
		    // Potential runtime/memory problem here from frequent cloning
		    ArrayList<String> updatedWords = (ArrayList<String>)currentWords.clone();
		    updatedWords.add(potentialWord);
		    // Just reusing updatedWords
		    updatedWords = convertToSentence(message, endIndex, updatedWords);
		    if (updatedWords != null) {
			return updatedWords;
		    }
		}
	    }
	}
	// Couldn't find a solution after starting from startIndex
	return null;
    }

    public static void main(String[] args) {
	dictionary = new HashSet<String>();
	dictionary.add("a");
	dictionary.add("b");
	dictionary.add("c");
	dictionary.add("d");
	String word = "abcbcabddbcabdcbe";
	alreadyLookedThrough = new boolean[word.length()];
	ArrayList<String> result = convertToSentence(word, 0, new ArrayList<String>());
	if (result == null) {
	    System.out.println("No solution found!");
	} else {
	    System.out.println("Result: " + result);
	}
    }
}
