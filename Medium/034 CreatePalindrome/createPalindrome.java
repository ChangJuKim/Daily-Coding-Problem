public class createPalindrome {    

    // Creates 2-D int array
    // Start of recursive function
    // Can remove the lines setting default values to word.length+1 since that's n^2 time
    public static int[][] dpArray(String word) {
	int[][] ary = new int[word.length()][word.length()];
	for (int i = 0; i < ary.length; i++) {
	    for (int j = 0; j < ary[i].length; j++) {
		ary[i][j] = word.length() + 1; // max value
	    }
	}
	ary[0][word.length() - 1] = 0;
	return dpArray(word, ary, 0, word.length() - 1);
    }

    // Fills out array
    public static int[][] dpArray(String word, int[][] ary, int lIndex, int rIndex) {
	while (lIndex < rIndex) {
	    // Both letters are the same
	    if (word.charAt(lIndex) == word.charAt(rIndex)) {
		ary[lIndex+1][rIndex-1] = Math.min(ary[lIndex][rIndex] + 1, ary[lIndex+1][rIndex-1]);
		lIndex += 1;
		rIndex -= 1;
	    } else {
		// Both letters are different
		ary[lIndex+1][rIndex] = Math.min(ary[lIndex][rIndex] + 1, ary[lIndex+1][rIndex]);
		ary = dpArray(word, ary, lIndex+1, rIndex);
		ary[lIndex][rIndex-1] = Math.min(ary[lIndex][rIndex] + 1, ary[lIndex][rIndex-1]);
		ary = dpArray(word, ary, lIndex, rIndex-1);
		break;
	    }
	}
	return ary;
    }

    // Looks for the minimums in the middle diagonal, and the one below that
    // Middle diagonal represents starting at a specific letter
    // Diagonal below represents starting between two letters
    public static String findPalindrome(int[][] ary, String word) {
	// Find minimum in middle
	int x = 0;
	int min = word.length() + 1;
	for (int y = 0; x < ary.length && y < ary[x].length; y++) {
	    if (ary[x][y] < min) {
		min = ary[x][y];
	    }
	    x += 1;
	}

	// See if that minimum exists in diagonal below mid
	x = 1;
	boolean exists = false;
	for (int y = 0; x < ary.length && y < ary[x].length; y++) {
	    if (ary[x][y] <= min) {
		min = ary[x][y];
		exists = true;
	    }
	    x += 1;
	}

	// Find best palindrome
	String bestPalindrome = word + word + word;
	
	if (!exists) { x = 0; } // start at middle diagonal
	else { x = 1; } // start at diagonal below
	for (int y = 0; x < ary.length && y < ary[x].length; y++) {
	    if (ary[x][y] == min) {
		// get shortest/alphanumerically first one
		bestPalindrome = getFirst(bestPalindrome, recreatePalindrome(ary, word, x, y, exists));
	    }
	    x += 1;
	}
	return bestPalindrome;
    }
    

    // isDouble checks if you're starting with two letters or one
    public static String recreatePalindrome(int[][] ary, String word, int x, int y, boolean isDouble) {
	String current = isDouble ? "" : "" + word.charAt(y);
	while(ary[x][y] != 0) {
	    if (x-1 >= 0 && y+1 < ary[x].length && ary[x-1][y+1] == ary[x][y]-1) {
		x -= 1;
		y += 1;
		current = "" + word.charAt(y) + current + word.charAt(y);
	    } else {
		String temp1 = "";
		String temp2 = "";
		if (x-1 >= 0 && ary[x-1][y] == ary[x][y]-1) {
		    temp1 = recreatePalindrome(ary, word, x-1, y, current, "up");
		}
		if (y+1 < ary[x].length && ary[x][y+1] == ary[x][y]-1) {   
		    temp2 = recreatePalindrome(ary, word, x, y+1, current, "right");
		}
		return getFirst(temp1, temp2); // compare with previous result to get answer
	    }
	}
	return current;
    }

        // 
    public static String recreatePalindrome(int[][] ary, String word, int x, int y, String current, String direction) {
	if (x < 0 || y < 0 || x >= ary.length || y >= ary[x].length) {
	    return current;
	}
	String character = (direction.equals("up") ? "" + word.charAt(x) : "" + word.charAt(y));
	current = "" + character + current + character;
	while(ary[x][y] != 0) {
	    if (x-1 >= 0 && y+1 < ary[x].length && ary[x-1][y+1] == ary[x][y]-1) {
		x -= 1;
		y += 1;
	    } else {
		String temp1 = "";
		String temp2 = "";
		if (x-1 >= 0 && ary[x-1][y] == ary[x][y]-1) {
		    temp1 = recreatePalindrome(ary, word, x-1, y, current, "up");
		}
		if (y+1 < ary[x].length && ary[x][y+1] == ary[x][y]-1) { 
		    temp2 = recreatePalindrome(ary, word, x, y+1, current, "right");
		}
		return getFirst(temp1, temp2); // compare with previous result to get answer
	    }
	}
	return current;
    }

    // Determines which word is shorter/alphabetically first
    public static String getFirst(String word1, String word2) {
	if (word1.equals("")) { return word2; }
	if (word2.equals("")) { return word1; }
	if (word1.length() < word2.length()) { return word1; }
	if (word2.length() < word1.length()) { return word2; }
	for (int i = 0; i < word1.length(); i++) {
	    if (word1.charAt(i) < word2.charAt(i)) {
		return word1;
	    }
	    if (word2.charAt(i) < word1.charAt(i)) {
		return word2;
	    }
	}
	return word1; // They're the same > . >
    }



    public static void printArray(int[] ary) {
	System.out.print("[");
	for (int i = 0; i < ary.length; i++) {
	    if (i == ary.length - 1) {
		System.out.println("" + ary[i] + "]");
	    } else {
		System.out.print("" + ary[i] + ", ");
	    }
	}
    }

    public static void printArray(int[][] ary) {
	System.out.println("[");
	for (int i = 0; i < ary.length; i++) {
	    printArray(ary[i]);
	}
	System.out.println("]");
    }

    
    public static void main(String[] args) {
	String word = "baadb";
	System.out.println("word: " + word);
	int[][] ary = dpArray(word);
	printArray(ary);
	//System.out.println(ary[3][3]);
	System.out.println(findPalindrome(ary, word));
    }
}
