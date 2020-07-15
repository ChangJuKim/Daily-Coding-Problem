public class nthPerfect {
    /*
      Rules to creating the next perfect number
        1. If possible, ONES -= 1
	   A. If possible, TENS += 1. Otherwise, HUNDREDS/THOUSANDS/etc += 1
	2. Otherwise, TENS/HUNREDS/ETC -= 1
	   B. HUNDREDS/THOUSANDS/ETC += 1
	3. Edge cases: 91 => 109 => 118 => ... => 190 => 208 => 217
	    Continued: 1810 => 1900 => 2008
	    Continued: 1,111,111,111 => 1,111,111,120
	    Continued: 9,000,001 => 9,000,010 => ... 9,100,000 => 10,000,009
	    Continued: 8,000,020 => 8,000,101
	   A. For edge cases, 
	      a. Find the first nonzero number starting from the right. Make that 0.
	      b. Increment next nonzero number by 1 (if it's 9, add appropriately)
	      c. Make 1's digit whatever it needs to be to become perfect

	Edit: Ended up making "Edge cases" my actual solution
	Note that some edge cases for my solution don't need to be considered because
	I always move from one perfect number to another
	E.g. All 0's: Not a perfect number
     */
    
    public static int sumDigits(int current) {
	int sum = 0;
	while (current > 0) {
	    sum += current % 10;
	    current = current / 10;
	}
	return sum;
    }
    
    // Returns the nth perfect number after current
    public static int nthPerfect(int current, int n) {
	if (n <= 0) {
	    return current;
	}
	int original = current; // for testing purposes
	int zeros = 0;
	// Find first nonzero number
	while (current % 10 == 0) {
	    current = current / 10;
	    zeros += 1;
	}
	current = current / 10; // Make first non-zero into a 0
	zeros += 1;
        current += 1; // Increment next digit by 1
	for (; zeros > 0; zeros -= 1) { // Add appropriate # of 0's
	    current = current * 10;
	}
	current = current / 10;
	current = current * 10 + (10 - sumDigits(current)); // Make 1's digit whatever it needs
	assert original < current;
	assert sumDigits(current) == 10;
	return nthPerfect(current, n-1);
    }

    public static int nthPerfect(int n) {
	if (n == 0) {
	    return 0;
	}
	return nthPerfect(19, n-1);
    }

    public static void test(int number) {
	System.out.println("" + number + " => " + nthPerfect(number, 1));
    }

    public static void test(int number, int n) {
	System.out.println("" + number + " => (" + n + ") => " + nthPerfect(number, n));
    }

    public static void main(String[] args) {
	/*
	test(91);
	test(109);
	test(1810);
	test(1900);
	test(2008);
	test(1111111111);
	test(9000001);
	test(9000010);
	test(9100);
	test(8000020);
	*/
	int n = 1000;
	System.out.println("" + n + " => " + nthPerfect(n));
    }
}
