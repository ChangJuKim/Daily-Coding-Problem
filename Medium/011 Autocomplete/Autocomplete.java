public class Autocomplete {


    public static void main(String[] args) {
	Trie trie = new Trie();
	System.out.println(trie.add("ddog"));
	System.out.println(trie.add("deer"));
	System.out.println(trie.add("deal"));
	System.out.println(trie.add("eyy"));
	trie.printSetLength();
	System.out.println("\n\n");
	System.out.println("autocomplete: " + trie.autocomplete("dee"));

	
    }
    
}
