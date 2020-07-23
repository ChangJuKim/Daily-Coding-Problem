import java.util.Arrays;

public class SplitSums {

    public static int getTotal(int[] ary) {
	int total = 0;
	for (int i = 0; i < ary.length; i++) {
	    total += ary[i];
	}
	return total;
    }

    // Returns true if ary can be split into two arrays of equal sums
    public static boolean canSplit(int[] ary) {
	int total = getTotal(ary);
	if (total % 2 == 1) {
	    return false;
	}
	int desired = total / 2;

	// Cause why not?
	// If I find an O(N) solution I'll remove this
	ary = Arrays.sort(ary);
	return canSplit(ary, desired, ary.length - 1);
    }

    // Basically runs through the 2^N options.
    // Starts from the largest numbers cause that's more likely to break faster
    // ...I think
    // Runtime: O(2^N)
    public static boolean canSplit(int[] ary, int desired, int index) {
	/* Base cases */
	if (desired == 0) {
	    return true;
	}
	if (index == -1) {
	    return false;
	}
	// no negative numbers but desired is negatived
	if (desired < 0 && ary[0] >= 0) {
	    return false;
	}
	// no more positive numbers but desired is still positive
	if (desired > 0 && ary[index] <= 0) {
	    return false;
	}
	
	/* Recursive calls */
	// Add index
	if (canSplit(ary, desired - ary[index], index - 1)) {
	    return true;
	}
	// Don't add index
	return canSplit(ary, desired, index - 1);
    }

    
}
