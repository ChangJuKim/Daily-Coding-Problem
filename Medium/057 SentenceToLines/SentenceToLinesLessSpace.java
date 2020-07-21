public class SentenceToLinesLessSpace {


    public static ArrayList<String> makeLines(String sentence, int k) {
	ArrayList<String> lines = new ArrayList<String>();
	String line = "";
	int start = 0;
	int end = 0;
	while (start < k) {
	    // Find first word
	    while (sentence.charAt(end) != " ") {
		end += 1;
	    }
	    word = sentence.substring(start, end);
	    if (word.length() > k) {
		return null;
	    }
	    if (line == "") {
		// Handles first word. Only runs once
		line = word;
	    } else if (line.length() + 1 + word.length() <= k) {
		// Add word
		line += " " + word;
	    } else {
		// New line
		lines.add(line);
		line = word;
	    }
	    start = end; // or end + 1. Not sure
	}

	// Add last word
	if (line != "") {
	    lines.add(line);
	}
	return lines;
    }
}
