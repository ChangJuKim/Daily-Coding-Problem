public class KBuyAndSell {
    private static Integer[][][] memo;
    private static int[] array;

    public static void init(int[] ary, int k) {
	int N = ary.length;
	memo = new Integer[N][N-2*k][2];
	array = ary;
    }

    // Returns profit from exactly k buys and sells
    public static int profit(int[] ary, int k) {
	init(ary, k);
	int skips = ary.length - 2*k;
	return profit(0, skips, 2*k, -1, 0);
    }

    // i = index of array
    public static Integer profit(int i, int skips, int k, int sign, int total) {
	/* BASE CASES */
	if (i == array.length) { return total; } // probably will never run
	if (skips == 0 && k == 0) { return total; } // should never happen 
	if (memo[i][skips][sign] != null && memo[i][skips][sign] >= total) {
	    // Already computed with better result
	    return null;
	}
	memo[i][skips][sign] = total;

	if (k == 0) return total; // no more buys and sells
	if (skips == 0) { // gotta buy and sell everything else
	    assert k == array.length - i; // Off by one error?
	    for (; i < array.length; i++) {
		total += sign * array[i];
		sign *= -1;
	    }
	    return total;
	}

	/* RECURSIVE STEP */
	Integer profit1 = null;
	Integer profit2 = null;
	if (skips > 0) {
	    profit1 = profit(i+1, skips-1, k, sign, total); // Skip value i
	}
	if (k > 0) {
	    profit2 = profit(i+1, skips, k-1, sign * -1, total + sign*array[i]); // Buy/Sell i
	}

	/* RETURN STEP */
	if (profit1 == null) {
	    return profit2;
	}
	if (profit2 == null) {
	    return profit1;
	}
	return Math.max(profit1, profit2);
    }
}
