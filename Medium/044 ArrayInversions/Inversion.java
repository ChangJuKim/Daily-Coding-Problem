import java.util.Arrays;

public class Inversion {
    /* Implementing merge sort
       1. Split up arrays
       2. Merge arrays

       This is basically merge sort except ary[1] is always a 1 element array,
       and holds the number of inversions. Basically returns and updates inversions
       in addition to performing merge sort
     */

    // Merge arrays
    public static int[][] merge(int[][] array1, int[][] array2) {
	int[] ary1 = array1[0];
	int[] ary2 = array2[0];
	int inversions = array1[1][0] + array2[1][0];
	int[] merged = new int[ary1.length + ary2.length];
	int index1 = 0;
	int index2 = 0;
	// Adds to single array while sorting
	while (index1 < ary1.length && index2 < ary2.length) {
	    if (ary1[index1] <= ary2[index2]) {
		merged[index1+index2] = ary1[index1];
		index1++;
	    } else {
		merged[index1+index2] = ary2[index2];
		inversions += ary1.length - index1; // Count number of elements skipped
		index2++;
	    }
	}
	// Add remaining values
	while (index1 < ary1.length) {
	    merged[index1+index2] = ary1[index1];
	    index1++;
	}
	while (index2 < ary2.length) {
	    merged[index1+index2] = ary2[index2];
	    index2++; // Don't add to inversions because we're not skipping any
	}
	assert index1+index2 == merged.length;
	assert inversions >= array1[1][0] + array2[1][0];
	return new int[][] {merged, new int[] {inversions}};
    }

    // Split up arrays
    public static int[][] split(int[][] array) {
	int inversions = array[1][0];
	int[] ary = array[0];
	if (ary.length > 1) {
	    int middle = ary.length / 2;
	    int[][] ary1 = new int[][] {Arrays.copyOfRange(ary, 0, middle), new int[] {inversions}};
	    int[][] ary2 = new int[][]  {Arrays.copyOfRange(ary, middle, ary.length), new int[] {0}};
	    // Only add inversions to one int[][] to ensure it's added, but not doublecounted
	    return merge(split(ary1), split(ary2));
	}
	return new int[][] {ary, new int[] {inversions}};
    }

    public static int[][] mergeSort(int[] ary) {
	return split(new int[][] {ary, new int[] {0}});
    }

    // Taken from commonly used code
    // I really gotta figure out how to import it
    // For testing purposes only
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

    
    public static void main(String[] args) {
	int[] ary = {2, 4, 1, 3, 5};
	int[][] result = mergeSort(ary);
	printArray(result[0]);
	System.out.println(result[1][0]);
    }

    
}
