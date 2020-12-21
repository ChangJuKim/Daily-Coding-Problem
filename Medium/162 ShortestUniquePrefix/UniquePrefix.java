import java.util.ArrayList;

public class UniquePrefix {


    public static ArrayList<String> uniquePrefix(ArrayList<String> words) {
	TrieNode root = new TrieNode();
	ArrayList<String> result = new ArrayList<String>();

	for (int i = 0; i < words.size(); i++) {
	    root.addWord(words.get(i));
	}

	for (int i = 0; i < words.size(); i++) {
	    result.add(root.shortestPrefix(words.get(i)));
	}

	return result;
    }


    public static void main(String[] args) {
	ArrayList<String> words = new ArrayList<String>();
	words.add("dog");
	words.add("cat");
	words.add("apple");
	words.add("apricot");
	words.add("fish");

	System.out.println(uniquePrefix(words));
    }
}
