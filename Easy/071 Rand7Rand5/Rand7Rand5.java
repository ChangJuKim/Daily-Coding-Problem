import java.util.Random; // To implement rand7

public class Rand7Rand5 {

    public static int rand7() {
	Random rand = new Random();
	return rand.nextInt(7);
    }

    public static int rand5() {
	int result = rand7();
	while (result >= 5) {
	    result = rand7();
	}
	return result;
    }

    // Testing purposes

    public static void printArray(int[] ary) {
	System.out.print("[");
	for (int i = 0; i < ary.length; i++) {
	    if (i != ary.length - 1) {
		System.out.print("" + ary[i] + ", ");
	    } else {
		System.out.println("" + ary[i] + "]");
	    }
	}
    }

    public static void main(String[] args) {
	int[] totals = new int[]{0, 0, 0, 0, 0};
	int testCases = 100000;
	while(testCases > 0) {
	    testCases -= 1;
	    int x = rand5();
	    totals[x] += 1;
	}
	printArray(totals);
    }
}
