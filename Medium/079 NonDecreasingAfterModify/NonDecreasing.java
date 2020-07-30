public class NonDecreasing {

    // Actually, doesn't work in this case
    // 1, 2, 3, 1, 2, 5
    public static boolean checkNonDecreasing(int[] ary) {
	int numErrors = 0;
	for (int i = 0; i < ary.length-1; i++) {
	    if (ary[i] > ary[i+1]) {
		if (numErrors > 0) {
		    return false;
		}
		numErrors += 1;
	    }
	}
	return true;
    }

    public static boolean checkNonDecreasingCORRECT(int[] ary) {
	int numErrors = 0;
	for (int i = 0; i < ary.length-1; i++) {
	    if (ary[i] > ary[i+1]) {
		if (numErrors > 0) {
		    return false;
		}
		numErrors += 1;
		ary[i+1] = ary[i]; // new code. Smallest value ary[i+1] can be
	    }
	}
	return true;
    }

    
    
}
