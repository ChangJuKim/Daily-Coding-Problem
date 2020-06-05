import java.util.Random;

public class RandExtensified {
    // Using a randN(), creates randM()

    public static int randN(int n) {
	Random rand = new Random();
	return rand.nextInt(n) + 1;
    }

    // Determines smallest X such that N^X > M.
    public static int determineX(int n, int m) {
	int total = n;
	int x = 1;
	while (total < m) {
	    total *= n;
	    x += 1;
	}
	return x;
    }

    public static int randM(int n, int m) {
	int x = determineX(n, m);
	int total = Integer.MAX_VALUE;
	// m*A + Z = n^x. We want m*A as threshold
	int A = (int)Math.pow(n, x) / m;
	// Threshold: anything greater or equal to threshold should call a reroll
	int threshold = m*A;

	// Recalculate total until it doesn't break the threshold
	while(total >= threshold) {
	    total = 0;
	    for (int i = 0; i < x; i++) {
		total += (randN(n)-1) * (int)Math.pow(n, i);
	    }
	}
	return total % m + 1;
    }

    // must be greater than size 0
    public static void printArray(int[] ary) {
        System.out.print("[" + ary[0]);
	for (int i = 1; i < ary.length; i++) {
	    System.out.print(", " + ary[i]);
	}
	System.out.println("]");
    }

    public static void main(String[] args) {
	Random rand = new Random();
	int testCases = 10;
	int numRuns = 500000;
	
	for (int i = 0; i < testCases; i++) {
	    int n = rand.nextInt(5) + 3;
	    int m = rand.nextInt(50) + 10;
	    int[] ary = new int[m];
	    System.out.println("Testing rand" + n + "() to rand" + m + "().");
	    for (int j = 0; j < numRuns; j++) {
		ary[randM(n, m) - 1] += 1;
	    }
	    System.out.print("Result: ");
	    printArray(ary);
	    System.out.println();
	}
    }
}
