public class Exponentiation {


    // The java binary conversion should be faster
    // It's reversed cause I'm not sure right now how to implement proper binary conversion
    // Also not sure if reversed is better
    public static int getBinary(int num) {
	String binary = "";
	while (num > 0) {
	    binary = "" + num % 2 + binary;
	    num = num / 2;
	}
	return Integer.parseInt(binary);
    }

    // Honestly just gets the digits
    // Will only use for the binary number
    public static int getDigits(int binary) {
	int digits = 0;
	while (binary > 0) {
	    digits += 1;
	    binary = binary / 10;
	}
	return digits;
    }

    // Creates an array of exponential values
    // [exp^1, exp^2, exp^4, exp^8, ... ]
    public static int[] exponentArray(int base, int size) {
	int[] array = new int[size];
	array[0] = base;
	for (int i = 1; i < size; i++) {
	    array[i] = array[i-1] * array[i-1];
	}
	return array;
    }

    public static int pow(int base, int exponent) {
	int binary = getBinary(exponent);
	int[] array = exponentArray(base, getDigits(binary));
	int total = 1;
	
	
	for (int i = 0; i < array.length; i++) {
	    if (binary % 10 == 1) {
		total = total * array[i];
	    }
	    binary = binary / 10;
	}
	return total;
    }

    /* Testing */
    public static void test(int base, int exponent) {
	System.out.println("" + base + "^" + exponent + " = " + pow(base, exponent));
    }
    
    public static void main(String[] args) {
	System.out.println(getBinaryReversed(10));
	test(2, 10);
	test(3, 10);
    }
}
