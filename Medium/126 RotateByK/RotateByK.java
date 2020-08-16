public class RotateByK {

    /* Calculate prime factors / GCF */
    
    // Prolly a better way to get prime factors/GCF
    public static ArrayList<Integer> primeFactors(int num) {
	ArrayList<Integer> primeFactors = new ArrayList<Integer>();
	if (num <= 0) return null;
	if (num == 1) primeFactors.add(1);
	while (num > 1) {
	    if ((num % prime) == 0) {
		primeFactors.add(prime);
	    } else {
		prime += 1;
	    }
	}
	return primeFactors;
    }

    public static ArrayList<Integer> commonPrimeFactors(int a, int b) {
	ArrayList<Integer> total = new ArrayList<Integer>();
	ArrayList<Integer> aFactors = primeFactors(a);
	ArrayList<Integer> bFactors = primeFactors(b);
	int aIndex = 0;
	int bIndex = 0;
	while (aIndex < aFactors.length() && bIndex < bFactors.length()) {
	    int aFactor = aFactors.get(aIndex);
	    int bFactor = bFactors.get(bIndex);
	    if (aFactor == bFactor) {
		total.add(aFactors.get(aIndex));
		aIndex += 1;
		bIndex += 1;
	    } else if (aFactor > bFactor) {
		bIndex += 1;
	    } else {
		aIndex += 1;
	    }
	}
	return total;
    }

    public static int sum(ArrayList<Intger> nums) {
	int total = 0;
	for (int i = 0; i < nums.size(); i++) {
	    total += nums.get(i);
	}
	return total;
    }

    /* End finding prime factors/GCF */

    
    // Used to determine indices
    public static int sumMod(int a, int b, int modulo) {
	return (a + b + modulo) % modulo; // ensure positive
    }

    // Replace index i with i+k, i = i-k
    public static int[] rotateK(int[] ary, int k) {
	int n = ary.length;
	if (k >= n) k = k % n; // ensures k < n
	if (k == 0) return ary;
	// You actually only need GCF but I wasn't clear on the math and just calculated
	// Prime factorization instead
	ArrayList<Integer> commonFactors = commonPrimeFactors(k, n);

	int frontIndex = k;
	int frontValue = ary[k];
	if (commonFactors.size() == 0) { // relatively prime
	    for (int i = 0; i < k; i++) {
		int backIndex = sumMod(frontIndex, k*-1, n);
		int temp = ary[backIndex];
		ary[backIndex] = frontValue;
		
		// Update values for next iteration
		frontIndex = backIndex;
		frontValue = temp;
	    }
	} else { // has common factors.
	    // Since jumping by k loops, stop before a loop occurs and offset by 1
	    int GCF = sum(commonFactors);
	    for (int offset = 0; offset < GCF; offset++) {
		frontIndex = offset;
		frontValue = ary[frontIndex];
		for (int i = 0; i < k/GCF; i++) {
		    int backIndex = sumMod(frontIndex, k*-1, n);
		    int temp = ary[backIndex];
		    ary[backIndex] = frontValue;
		    
		    // Update values for next iteration
		    frontIndex = backIndex;
		    frontValue = temp;
		}
	    }
	}
	return ary;
    }
}
