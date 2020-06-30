import java.util.ArrayList;

public class JustifyText {

    public static ArrayList<String> justifyText(String[] words, int lineLength) {
	ArrayList<String> justified = new ArrayList<String>();
	int startIndex = 0;
	int endIndex = 0;

	while (startIndex < words.length) {
	    // Determine which words are used in the next line
	    String line = words[startIndex];
	    int remainingLength = lineLength - words[startIndex].length(); // Remaining length in line
	    endIndex += 1;
	    while (endIndex < words.length && words[endIndex].length() + 1 <= remainingLength) {
		remainingLength -= (words[endIndex].length() + 1);
		endIndex += 1;
	    }
	
	    // Determine number of spaces per line
	    int extraSpaces = remainingLength;
	    int spaceLocations = endIndex - startIndex - 1; // number of places to put spaces
	    
	    // Edge case: Only one word in the line. Ignores rest of code
	    if (spaceLocations == 0) {
		int minSpaces = extraSpaces;
	        for (int i = 0; i < minSpaces; i++) {
		    line += " ";
		}
		startIndex += 1;
	    }

	    // Continue determining number of spaces
	    else {
		int minSpaces = extraSpaces / spaceLocations + 1; // minimum spaces to put
		int remaining = extraSpaces % spaceLocations; // number of spaces remaining

		
		// Add spaces and words to the line
		startIndex += 1; // Don't add first word
		while (startIndex < endIndex) {
		    String nextWord = "";
		    for (int i = 0; i < minSpaces; i++) {
			nextWord += " ";
		    }
		    if (remaining > 0) {
			nextWord += " ";
			remaining -= 1;
		    }
		    nextWord += words[startIndex];
		    line += nextWord;
		    startIndex += 1;
		}
	    }
	    justified.add(line);
	}
	return justified;
    }

    public static void test(String[] words, int lineLength) {
	ArrayList<String> justified = justifyText(words, lineLength);
	System.out.println(justified);
	for (int i = 0; i < justified.size(); i++) {
	    System.out.println(justified.get(i).length());
	}
    }

    public static void main(String[] args) {
	String[] words = new String[]{"12345", "12345", "1234", "1", "2", "3", "4", "5", "6", "7", "89", "0", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
	test(words, 5);
	test(words, 16);
	test(words, 7);
    }
}
