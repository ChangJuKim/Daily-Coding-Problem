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

    public static String multiplyPanels(int[] ary) {
	LargeIntegerStrings total = new LargeIntegerStrings("1");
	int largestNeg = Integer.MIN_VALUE;
	boolean evenNegs = true;
	for (int i = 0; i < ary.length; i++) {
	    if (ary[i] > 1) {
		total = total.multiply(new LargeIntegerStrings(ary[i]));
	    } else if (ary[i] < 0) {
		evenNegs = !evenNegs;
		if (largestNeg != Integer.MIN_VALUE) {
		    total = total.multiply(-1 * Math.min(largestNeg, ary[i]));
		    largestNeg = Math.max(largestNeg, ary[i]);
		} else {
		    largestNeg = ary[i];
		}
	    }
	}
	if (evenNegs && (largestNeg != Integer.MIN_VALUE)) {
	    total = total.multiply(-1 * largestNeg);
	}
	return total.toString();
    }

    public static void printAry(int[] ary) {
	System.out.print("[");
	for (int i = 0; i < ary.length; i++) {
	    if (i == 0) {
		System.out.print(ary[i]);
	    } else {
		System.out.print(", " + ary[i]);
	    }
	}
	System.out.println("]");
    }

    
    public static void main(String[] args) {
	Random randSeed = new Random();
	int seed = randSeed.nextInt();
	Random rand = new Random(seed);
	System.out.println("seed: " + seed + "\n");

	int testCases = 10;
	int panels = 50;
	for (int i = 0; i < testCases; i++) {

	    int[] ary = new int[panels];
	    for (int j = 0; j < panels; j++) {
		ary[j] = rand.nextInt(2001) - 1000;
	    }
	    System.out.print("Array: ");
	    printAry(ary);
	    System.out.println("Result: " + multiplyPanels(ary) + "\n\n");
	}
    }
    
    
}
