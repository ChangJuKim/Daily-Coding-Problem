public class SmallestMissingPositive {

    public static void swap(int[] ary, int i, int j) {
	int temp = ary[i];
	ary[i] = ary[j];
	ary[j] = temp;
    }

    public static int firstMissing(int[] ary) {
	/* Make array look like this: [1, 2, ... k-1, k, NEGATIVE/0/LARGE #/DUPLICATES] */

	// Note that all indices are (something - 1)
	int current = 1; // desired value and index
	int endOfArray = ary.length; // index but for the end
	while (current < endOfArray) {
	    int value = ary[current-1];
	    if (value == current) { // In the correct spot
		current += 1;
	    } else {
		if (value <= 0 || value > endOfArray || ary[value-1] == value ) {
		    // Want to shove it to the end (zero/negative || large # || duplicates) 
		    swap(ary, current-1, endOfArray-1);
		    endOfArray -= 1; // Update end of array
		} else {
		    // Want to place it in the correct spot
		    swap(ary, current-1, value-1);
		}
	    }
	}
	/* Find first number that doesn't fit. return ary.length if they all do */
	while (current <= ary.length && ary[current-1] == current) {
	    current += 1;
	}
	return current;
    }

    /* TESTING PURPOSES */
    public static void printArray(int[] ary) {
	System.out.print("[");
	for (int i = 0; i < ary.length; i++) {
	    System.out.print(ary[i]);
	    if (i != ary.length-1) {
	    	System.out.print(", ");
	    }
	}
	System.out.println("]");
    }
    
    public static void test(int[] ary) {
	System.out.print("Original:\n  ");
	printArray(ary);
	int missing = firstMissing(ary);
	System.out.print("Missing: " + missing + "\n  ");
	printArray(ary);
	System.out.println("~~~~~~~~~~~~");
    }

    public static void main(String[] args) {
	test(new int[] {3, 4, -1, 1});
	test(new int[] {1, 2, 0});
	test(new int[] {});
	test(new int[] {1});
	test(new int[] {2});
	test(new int[] {-1});
	test(new int[] {5, 3, 2, 1, 4, 6});
	test(new int[] {0, -1, 5, -3, 2, 4, 100000});
    }
}
