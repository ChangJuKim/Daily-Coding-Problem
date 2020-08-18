public class SquareRoot{

    // Gets # digits. Ignores decimals.. sorta.
    // Not very precise (esp. if n is a float are involved)
    public static int getDigits(double n) {
	int digits = 0;
	while (n > 1) {
	    n = n / 10;
	    digits += 1;
	}
	return digits;
    }

    // N must be real
    public static Double squareRoot(double n) {
	if (n < 0) {
	    throw new ArithmeticException();
	}
	if (n == 0 || n == 1) {
	    return n;
	}

	// Determine starting point.
	// For small numbers uses n/2. Otherwise starts at 10^something
	double current = n/2;
	if (n > 100) {
	    current = 1;
	    // gets to a nicer starting point
	    int digits = getDigits(n) / 2;
	    while (digits > 0) {
		current = current * 10;
		digits -= 1;
	    }
	}
	
	while(true) {
	    double difference = n-current*current;
	    if (difference <= .01 && difference >= -.01) {
		return current;
	    }
	    current = current + difference/2.0;
	}
    }

    /* Testing */

    public static void test(double n) {
	System.out.println("Sqrt("+n+"): " + squareRoot(n) + ".\n  Difference: " + (Math.sqrt(n) - squareRoot(n)));
    }

    public static void main(String[] args) {
	test(4);
	test(0);
	test(1);
	test(2);
	test(3);
	test(100000000);
    }
}
