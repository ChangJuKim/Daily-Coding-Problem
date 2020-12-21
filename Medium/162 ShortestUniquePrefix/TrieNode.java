import java.util.HashMap;

public class TrieNode {
    private HashMap<Character, TrieNode> map;
    private int numWords;

    public TrieNode() {
	map = new HashMap<Character, TrieNode>();
	numWords = 0;
    }

    // Increments numWords, and calls addWord with truncatated word
    public void addWord(String word) {
	numWords += 1;
	if (word.length() == 0) {
	    return;
	}
	if (map.containsKey(word.charAt(0))) {
	    map.get(word.charAt(0)).addWord(word.substring(1));
	} else {
	    TrieNode node = new TrieNode();
	    map.put(word.charAt(0), node);
	    node.addWord(word.substring(1));
	}
    }

    public String shortestPrefix(String word) {
	if (numWords == 1) {
	    return "";
	}
	
	if (!map.containsKey(word.charAt(0))) {
	    return null; // Error
	}

	return "" + word.charAt(0) + map.get(word.charAt(0)).shortestPrefix(word.substring(1));
    }
}
