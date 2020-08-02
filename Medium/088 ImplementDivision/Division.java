import java.util.ArrayList;

public class Division {


    // Returns integer division a / b = c
    public static Integer divide(int a, int b) {
	if (b == 0) {
	    return null; // Or throw an exception
	}
	ArrayList<Integer> powers = new ArrayList<Integer>(); // b, 2b, 4b, ...
	ArrayList<Integer> power2 = new ArrayList<Integer>(); // 1, 2, 4, ...

	// Fill in arrays
	int currentPower = b; // b, 2b, 4b, ...
	int currentPower2 = 1; // 1, 2, 4, ...
	while (currentPower <= a) {
	    powers.add(currentPower);
	    power2.add(currentPower2);
	    currentPower += currentPower;
	    currentPower2 += currentPower2;
	}

	// Determine which ones to add
	int totalSum = 0;
	int quotient = 0;
	for (int i = powers.size()-1; i >= 0; i--) {
	    if (totalSum + powers.get(i) <= a) {
		totalSum += powers.get(i);
		quotient += power2.get(i);
	    }
	}
	return quotient;
    }

    /* Testing purposes */

    public static void main(String[] args) {
	System.out.println(divide(4, 2));
	System.out.println(divide(3, 1));
	System.out.println(divide(10, 3));
	System.out.println(divide(100, 3));
	System.out.println(divide(100, 0));
	System.out.println(divide(0, 3));
	System.out.println(divide(10, 11));
	
	
    }
}
