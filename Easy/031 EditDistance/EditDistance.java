public class EditDistance {

    public static int editDistance(String word1, String word2) {
	// Buffer for word1 and word2. Just allows indicies to match array
	// (word1 and word2 now start with index 1, not index 0)
	// Note that index 0 of word1/word2 are never used
	word1 = "X" + word1;
	word2 = "X" + word2;

	// ary[x][y] means edit distance of word1[1 to x+1] and word2[1 to y+1]
	// This is done by comparing word1[x+1] and word2[y+1]
	// ary[0][0] compares empty strings
	int[][] ary = new int[word1.length()][word2.length()];

	// Edit distance of (string, "") is length of string
	for (int index1 = 0; index1 < word1.length(); index1++) {
	    ary[index1][0] = index1;
	}

	// Same but for word2
	for (int index2 = 0; index2 < word2.length(); index2++) {
	    ary[0][index2] = index2;
	}
	
	// Fills in rest of array
	for (int index1 = 1; index1 < word1.length(); index1++) {
	    for (int index2 = 1; index2 < word2.length(); index2++) {
		int smallestDistance = Math.min(Math.min(ary[index1-1][index2], // delete
							 ary[index1][index2-1]), // insert
						ary[index1-1][index2-1]); // replace
		if (word1.charAt(index1) == word2.charAt(index2)) {
		    ary[index1][index2] = smallestDistance;
		} else {
		    ary[index1][index2] = smallestDistance + 1;
		}
	    }
	}
	return ary[word1.length()-1][word2.length()-1];
    }

    public static void test(String word1, String word2) {
	System.out.println("Edit distance of \"" + word1 + "\" to \"" + word2 + "\": " + editDistance(word1, word2));
    }

    public static void main(String[] args) {
	test("edit", "distance");
	test("", "");
    }
}
