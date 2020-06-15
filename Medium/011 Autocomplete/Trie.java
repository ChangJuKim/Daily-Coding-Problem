import java.util.Iterator;

/*
  Wrapper class for LetterNode. 
  Ensures root of the Trie is empty and doesn't break anything
 */
public class Trie {
    private LetterNode root;

    public Trie() {
	root = new LetterNode("");
    }

    public void printSetLength() {
	System.out.println("Set length: " + root.set.size());
    }

    public boolean add(String word) {
	if (word.length() == 0) {
	    return root.set.add(new LetterNode());
	}
	LetterNode next = new LetterNode(word.substring(0, 1));
	root.set.add(next);
	return next.add(word);
    }

    public String autocomplete(String prefix) {
	if (prefix.length() == 0) {
	    String result = "";
	    Iterator<LetterNode> itr = root.set.iterator();
	    while (itr.hasNext()) {
		String word = itr.next().autocomplete(prefix, "");
		if (word.length() > 0) {
		    result += word + ", ";
		}
	    }
	} else {
	    Iterator<LetterNode> itr = root.set.iterator();
	    while (itr.hasNext()) {
		LetterNode node = itr.next();
		if (node.letter.equals(prefix.substring(0, 1))) {
		    return node.autocomplete(prefix, "");
		}
	    }
	}
	return "None";
    }
}
