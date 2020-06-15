import java.util.HashSet;
import java.util.Iterator;

/*
  Trie data structure.
  If a node represents the end of a word, it will not contain a letter.
  Otherwise, each node contains one letter (the root will not contain any).
  
*/

public class LetterNode {
    public String letter;
    public HashSet<LetterNode> set;

    public LetterNode(String letter) {
	this.letter = letter;
	set = new HashSet<LetterNode>();
    }

    public LetterNode() {
	letter = null;
	set = new HashSet<LetterNode>();
    }

    // Returns true if properly added word.
    // Returns false if word already exists or an error occurred
    // Some strange logic going on here. Most likely bugged
    public boolean add(String word) {
	// Reached end of word. Add an end-of-word node
	if (word.length() == 0) {
	    return set.add(new LetterNode());
	}
	// An error. This should never happen
	if (!word.substring(0, 1).equals(letter)) {
	    System.out.println("Error in add. " + word + ".substring(0,1) != " + letter);
	    return false;
	}
	
	word = word.substring(1);
	LetterNode next;
	if (word.length() > 1) {
	    next = new LetterNode(word.substring(0, 1));
	} else {
	    next = new LetterNode(word);
	}
	set.add(next);
	return next.add(word);
    }

    @Override
    public String toString() {
	return letter;
    }

    @Override
    public int hashCode() {
	if (letter == null) {
	    return 0; // no idea what to put as this
	}
	return letter.hashCode();
    }

    @Override
    public boolean equals(Object o) {
	if (this == o) {
	    return true;
	}
	if (!(o instanceof LetterNode)) {
	    return false;
	}
	LetterNode node = (LetterNode)o;
	return node.letter.equals(letter);
    }

    // Assumes prefix is shorter or equal to current
    private boolean hasPrefix(String prefix, String current) {
	if (prefix.length() > current.length()) {
	    System.out.println("Error in hasPrefix(" + prefix + ", " + current + ")");
	    return false;
	}
	for (int i = 0; i < prefix.length(); i++) {
	    if (prefix.charAt(i) != current.charAt(i)) {
		return false;
	    }
	}
	return true;
    }

    public String autocomplete(String prefix, String current) {
	// Base case
	if (letter == null) {
	    if (current.length() >= prefix.length()) {
		return current;
	    } else {
		return "";
	    }
	}
	current += letter;
	String result = "";
	Iterator<LetterNode> itr = set.iterator();
	while (itr.hasNext()) {
	    LetterNode node = itr.next();
	    // CONTINUE FROM HERE
	}
    }

    /*
    // Prefix is the first few letters
    // Current is the compilation of nodes we went through
    public String autocomplete(String prefix, String current) {
	System.out.println("autocomplete(" + prefix + ", " + current + "). Letter: " + letter);
	// The prefix was previouly found; return found words
	if (current.length() >= prefix.length()) {
	    if (letter == null) { // Leaf node
		return current;
	    } else { // Not a leaf => Keep traversing
		String result = "";
		current += letter;
		Iterator<LetterNode> itr = set.iterator();
		while (itr.hasNext()) {
		    String word = itr.next().autocomplete(prefix, current);
		    if (word.length() > 0) {
			System.out.println("word: " + word + ". Length: " + word.length());
			result += word + ", ";
		    }
		}
		return result;
	    }
	}
	// Keep going down Trie to reach prefix
	else {
	    if (letter == null) { // Leaf node
		return "";
	    } else {
		current += letter;
		
		if (!hasPrefix(current, prefix)) { // No longer matches prefix
		    System.out.println("" + current + " doesn't match with " + prefix);
		    return "";
		} else { // Keep traversing
		    String result = "";
		    Iterator<LetterNode> itr = set.iterator();
		    while (itr.hasNext()) {
			String word = itr.next().autocomplete(prefix, current);
			if (word.length() > 0) {
			    result += word + ", ";
			}
		    }
		    return result;
		}
	    }
	}
    }
    */
}
