public class LongestSubsequence {

    public static int[] longestIncSubsequence(int[] ary) {
	int[] lengths = new int[ary.length];
	for (int i = ary.length - 1; i >= 0; i--) {
	    int max = 1;
	    for (int j = i+1; j < ary.length; j++) {
		if (ary[i] < ary[j]) {
		    if (max < lengths[j] + 1) {
			max = lengths[j] + 1;
		    }
		}
	    }
	    lengths[i] = max;
	}
	
	/* 
	//Commented out for debugging purposes. 
	
	int maxLength = 0;
	for (int i = 0; i < lengths.length; i++) {
	    if (lenghts[i] > maxLength) {
		maxLength = lengths[i];
	    }
	}
	return maxLength;
	*/

	return lengths;
    }

    /* Debugging/Testing */

    public static void printArray(int[] ary) {
	System.out.print("[");
	for (int i = 0; i < ary.length; i++) {
	    System.out.print(ary[i]);
	    if (i != ary.length - 1) {
		System.out.print(", ");
	    }
	}
	System.out.println("]");
    }
    
    public static void main(String[] args) {
	int[] one = new int[] {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
	printArray(longestIncSubsequence(one));
    }
}
