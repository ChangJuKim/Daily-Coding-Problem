public class SmallestSquares {

    /*
      n = number we want to sum up to
      current = number of squares that we summed
      max_square = max square that you can sum by. E.g. if max_square = 10, you can only
                   sum by 1^2, 2^2, ..., 10^2.
      maxCurrent = smallest number of steps found so far. Ensures you don't do something
                   dumb like 1 + 1 + 1 + ...  + 1
     */
    public static int smallestSquares(int n, int current, int max_square, int maxCurrent) {
	if (n <= 8) {
	    return current + n/4 + n%4;
	}
	if (current > maxCurrent) {
	    return n; // took too many steps: return false
	}
	int a;
	for (a = max_square; a >= 1; a--) {
	    if (Math.pow(a, 2) <= n) {
		break;
	    }
	}

	int result = n;
	for (; a >= 2; a--) {
	    result = Math.min(result, smallestSquares(n-Math.pow(a, 2), current+1, a, maxCurrent));
	    maxCurrent = Math.min(result, maxCurrent);
	}
       	return result;
    }

    public static int smallestSquares(int n) {
	return smallestSquares(n, 0, (int)(Math.sqrt(n)+1), n);
    }
}
