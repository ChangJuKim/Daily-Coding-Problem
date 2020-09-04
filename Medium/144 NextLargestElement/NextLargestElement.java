public class NextLargestElement {


    public static Integer nextLargestIndex(int[] ary, int index) {
	int left = index - 1;
	int right = index + 1;
	while (left >= 0 || right < ary.length) {
	    if (left >= 0 && ary[left] > ary[index]) {
		return left;
	    }
	    if (right < ary.length && ary[right] > ary[index]) {
		return right;
	    }
	    left -= 1;
	    right += 1;
	}
	return null;
    }

    public static Integer nextLargestIndexPreprocessed(int[] ary, int index) {
	// Preprocessing step
	Integer[] results = new Integer[ary.length];
	for (int i = 0; i < ary.length; i++) {
	    results[i] = nextLargestIndex(ary, i);
	}

	return results[index];
    }
}
