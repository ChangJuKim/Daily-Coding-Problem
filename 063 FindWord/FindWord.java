public class FindWord {
    private static final boolean debug = false;
    
    public static void printDebug(String message) {
	if (debug) { System.out.println(message); }
    }

    // Returns true if board has the word from left-right, or up-down
    // Returns false otherwise
    public static boolean hasWord(char[][] board, String word) {
	// Looks for a word going top-down
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[i].length - word.length() + 1; j++) {
		// Find first letter
		if (board[i][j] == word.charAt(0)) {
		    // Check downwards
		    int k = 0;
		    // k will never be out of bounds because of the for loop constraint on j
		    while (k < word.length() && board[i][k] == word.charAt(k)) {
			k++;
		    }
		    if (k == word.length()) {
			printDebug("board[" + i + "][ " + j + "]: " + board[i][j]);
			return true;
		    }
		}
	    }
	}

	// Same as above but for left-right
	for (int i = 0; i < board.length - word.length() + 1; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		if (board[i][j] == word.charAt(0)) {
		    int k = 0;
		    while (k < word.length() && board[k][j] == word.charAt(k)) {
			k++;
		    }
		    if (k == word.length()) {
			printDebug("board[" + i + "][" + j + "]: " + board[i][j]);
			return true;
		    }
		}
	    }
	}

	return false;
    }


    public static void main(String[] args) {
	char[][] board = new char[][] {{'F', 'A', 'C', 'I'}, {'O', 'B', 'Q', 'P'}, {'A', 'N', 'O', 'B'}, {'M', 'A', 'S', 'S'}};
	String word = "FOAM";
	System.out.println("word: " + word);
	System.out.println("board has " + word + ": " + hasWord(board, word));
	word = "FACI";
	System.out.println("word: " + word);
	System.out.println("board has " + word + ": " + hasWord(board, word));
	word = "FBOS";
	System.out.println("word: " + word);
	System.out.println("board has " + word + ": " + hasWord(board, word));
	word = "FACISSSS";
	System.out.println("word: " + word);
	System.out.println("board has " + word + ": " + hasWord(board, word));
    }
}
