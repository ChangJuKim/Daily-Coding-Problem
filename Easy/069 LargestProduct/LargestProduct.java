//import common.*;
import java.util.Random;
import java.util.Arrays;

public class LargestProduct {

    
    public static int largestProduct(int[] ary) {
	int[] largestInts = new int[3]; // Excludes 0's if possible. ary[0] is largest, ary[2] is smallest. Holds 3 largest values so far
	int[] smallestNegs = new int[2]; // Excludes 0's if possible. ary[0] is smallest, ary[1] is largest. Only holds negatives

	for (int i = 0; i < ary.length; i++) {
	    if (ary[i] > largestInts[0] || largestInts[0] == 0) {
		largestInts[2] = largestInts[1];
		largestInts[1] = largestInts[0];
		largestInts[0] = ary[i];
	    } else if (ary[i] > largestInts[1] || largestInts[1] == 0) {
		largestInts[2] = largestInts[1];
		largestInts[1] = ary[i];
	    } else if (ary[i] > largestInts[2] || largestInts[2] == 0) {
		largestInts[2] = ary[i];
	    }

	    if (ary[i] < smallestNegs[0]) {
		smallestNegs[1] = smallestNegs[0];
		smallestNegs[0] = ary[i];
	    } else if (ary[i] < smallestNegs[1]) {
		smallestNegs[1] = ary[i];
	    }
	}

	int productNegs = smallestNegs[1] * smallestNegs[0];
	int productPos = largestInts[2] * largestInts[1];
	if (smallestNegs[1] == 0) { // Don't count negative if you only have one
	    productNegs = productPos;
	}

	if (largestInts[0] > 0) { // get largest value
	    return Math.max(productNegs, productPos) * largestInts[0];
	} else {
	    return productPos * largestInts[0];
	}
    }

    public static void printArray(int[] ary) {
	System.out.print("[");
	for (int i = 0; i < ary.length; i++) {
	    if (i == ary.length - 1) {
		System.out.println("" + ary[i] + "]");
	    } else {
		System.out.print("" + ary[i] + ", ");
	    }
	}
    }

    public static void test() {
	Random rand = new Random();
	int[] ary = new int[rand.nextInt(1) + 3];
	for (int i = 0; i < ary.length; i++) {
	    ary[i] = rand.nextInt(10) - 5;
	}
	int largestProduct = largestProduct(ary);
	Arrays.sort(ary);
	printArray(ary);
	System.out.println("largest product: " + largestProduct);
    }

    public static void main(String[] args) {
	test();
    }
}
