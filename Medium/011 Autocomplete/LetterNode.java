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

    // Returns LetterNode in set that equals next
    public LetterNode find(LetterNode next) {
	if (set.contains(next)) {
	    Iterator<LetterNode> itr = set.iterator();
	    while (itr.hasNext()) {
		LetterNode temp = itr.next();
		if (temp.equals(next)) {
		    return temp;
		}
	    }
	}
	return null;
    }
    
    // Returns true if properly added word.
    // Returns false if word already exists or an error occurred
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
	if (set.add(next)) {
	    System.out.println("set.add was true!");
	    return next.add(word);
	} else {
	    System.out.println("set.add was false!");
	    next = find(next);
	    return next.add(word);
	}
    }

    @Override
    public String toString() {
	return letter;
    }

    @Override
    public int hashCode() {
	if (letter == null) {
	    return 96; // no idea what to put as this so put 'a' - 1
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

    public String setString() {
	Iterator<LetterNode> itr = set.iterator();
	String result = "[";
	while (itr.hasNext()) {
	    result += itr.next().letter + ", ";
	}
	result += "]";
	return result;
    }

    public String autocomplete(String prefix, String current) {
	System.out.println("SET SIZE: " + set.size());
	System.out.println("SET : " + setString());
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
	if (current.length() >= prefix.length()) {
	    if (!hasPrefix(prefix, current)) {
		return "";
	    }
	    // Prefix found, print all possible results
	    while (itr.hasNext()) {
		LetterNode node = itr.next();
		result += autocomplete(prefix, current);
	    }
	} else {
	    if (!hasPrefix(current, prefix)) {
		return "";
	    }
	    // Still matches... gotta keep traversing till current == prefix
	    while (itr.hasNext()) {
		LetterNode node = itr.next();
		result += autocomplete(prefix, current);
	    }
	}
	return result;
    }

}
