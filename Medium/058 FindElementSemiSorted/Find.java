public class Find {


    // Finds index of maximum number
    public static int findMax(int[] ary) {
	if (ary.length == 0) {
	    return -1;
	}
	return findMax(ary, 0, ary.length-1, ary.length / 4, ary.length * 3 / 4);
    }

    // left < right. Both are indices
    public static int findMax(int[] ary, int leftBound, int rightBound, int left, int right) {
	// Base case. Don't know which ones are necessary actually
	if (leftBound == rightBound) {
	    return leftBound;
	} else if (leftBound == rightBound - 1) {
	    if (ary[leftBound] < ary[rightBound]) {
		return right; 
	    } else {
		return left;
	    }
	}
	
	if (ary[left] < ary[right]) {
	    // Max is left of "left" or right of "right"
	    if (ary[leftBound] < ary[left]) {
		// Max is to the right of "right"
		int mid = (rightBound - right) / 2;
		return findMax(ary, right, rightBound, right + mid/2, rightBound - mid/2);
	    } else {
		// Max is to the left of "left"
		int mid = (left - leftBound) / 2;
		return findMax(ary, leftBound, left, leftBound + mid/2, left - mid/2);
	    }
	} else {
	    // Max is between left and right
	    int mid = (rightBound - leftBound) / 2;
	    return findMax(ary, left, right, left + mid/2, right - mid/2);
	}
    }

    // Converts an index from a normal array to one that's wrapped around
    // If array is [13, 18, 25, 2, 8, 10], maxIndex = 2.
    // Converts [2, 8, 10, 13, 18, 25] to above.
    // So index 0 => index 3, index 5 => 2
    public static int wrappedIndex(int maxIndex, int aryLength, int index) {
	return (index + maxIndex + 1) % aryLength;
    }

    // First finds max value (so we know where it starts wrapping)
    // Then uses normal searching tools (split in half) to find index
    public static Integer findInt(int[] ary, int num) {
	if (ary.length == 0) {
	    return null;
	}
	int maxIndex = findMax(ary);

	int index = ary.length / 2;
	while (ary[wrappedIndex(maxIndex, ary.length, index)] != num) {
	    if (num > ary[wrappedIndex(maxIndex, ary.length, index)]) {
		index = (ary.length + index) / 2;
	    } else {
		index = index / 2;
	    }
	}
	return wrappedIndex(maxIndex, ary.length, index);
    }
}
