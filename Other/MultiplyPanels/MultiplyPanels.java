import java.util.Random;

public class MultiplyPanels {

    private static boolean testAdd(int one, int two) {
	LargeIntegerStrings largeOne = new LargeIntegerStrings("" + one);
	LargeIntegerStrings largeTwo = new LargeIntegerStrings("" + two);
	LargeIntegerStrings sum = largeOne.add(largeTwo);
	//System.out.println("" + one + " + " + two + " = " + sum + "\n (should be " + (one + two) + ") = " + (sum.equals(one + two)));
	return sum.equals(one + two);
    }
    
    private static boolean testMultiply(int one, int two) {
	LargeIntegerStrings largeOne = new LargeIntegerStrings("" + one);
	LargeIntegerStrings largeTwo = new LargeIntegerStrings("" + two);
	LargeIntegerStrings product =  largeOne.multiply(largeTwo);
	//System.out.println("" + one + " * " + two + " = " + product + "\n (should be " + (one * two) + ") = " + (product.equals(one * two)));
	return product.equals(one * two);
    }

    
    public static void main(String[] args) {
	Random randSeed = new Random();
	int seed = randSeed.nextInt();
	Random rand = new Random(seed);
	System.out.println("seed: " + seed + "\n");
	int testCases = 100000;
	for (int i = 0; i < testCases; i++) {
	    int one = rand.nextInt(1000);
	    int two = rand.nextInt(100000);
	    if (!testAdd(one, two)) {
		System.out.println("~~~~~~~~~~ERROR ADD~~~~~~~~~~~~~");
	    }
	    if (!testMultiply(one, two)) {
		System.out.println("~~~~~~~~~~ERROR MULTIPLY~~~~~~~~~~~~~");
	    }
	}

	LargeIntegerStrings large = new LargeIntegerStrings("" + Math.abs(rand.nextInt()));
	LargeIntegerStrings large2 = new LargeIntegerStrings("" + Math.abs(rand.nextInt()));
	System.out.println(large.add(large2));
	System.out.println(large.multiply(large2));
	LargeIntegerStrings large3 = large.multiply(large.multiply(large2.multiply(large2)));
	System.out.println(large3);
	LargeIntegerStrings large4 = large3.multiply(large3.multiply(large3));
	System.out.println(large4);
	System.out.println(large4.multiply(large4));
	for (int i = 0; i < 5; i++) {
	    large4 = large4.multiply(large4);
	}
	System.out.println(large4);
    }
    
    
}
