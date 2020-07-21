import java.util.ArrayList;

public class SentenceToLines {
    
    // Tries adding each word to current line
    // If not possible then makes new line (returns null if word >= k) 
    public static ArrayList<String> makeLines(String sentence, int k) {
	String[] array = sentence.split(" ");
	ArrayList<String> lines = new ArrayList<String>();
	String newline = "";

	// Handle first word
	if (array.length == 0 || array[0].length() > k) {
	    return null;
	}
	newline = array[0];
	
	for (int i = 1; i < array.length; i++) {
	    String word = array[i];
	    if (newline.length() + word.length() + 1 <= k) {
		newline += " " + word;
	    } else {
		// Word doesn't fit
		lines.add(newline);
		if (word.length() > k) {
		    return null;
		}
		newline = word;
	    }
	}
	
	// Add last line
	if (!newline.equals("")) {
	    lines.add(newline);
	}
	
	return lines;
    }

    public static void main(String[] args) {
	String sentence = "Hello I am you and mee";
	int k = 10;
	ArrayList<String> lines = makeLines(sentence, k);
	System.out.println(sentence + ":\n" + lines);
    }
}
