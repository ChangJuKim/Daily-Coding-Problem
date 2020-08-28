public class Staircase {


    // N = # of steps in staircase
    // X = Ways to take a step
    public static int numWaysToClimb(int N, int[] X) {
	int[] memo = new int[N+1]; // Since when did I use memo as an array name?
	memo[0] = 1;
	for (int step = 0; step < memo.length; step++) {
	    for (int i = 0; i < X.length; i++) {
		int climb = X[i];
		if (step + climb < memo.length) {
		    memo[step+climb] += memo[step];
		}
	    }
	}
	return memo[N];
    }


    
    /* Testing */

    public static void test(int N, int[] X) {
	System.out.print("Climbing " + N + " stairs with steps: [");
	for (int i = 0; i < X.length; i++) {
	    System.out.print(X[i]);
	    if (i != X.length-1) {
		System.out.print(", ");
	    }
	}
	System.out.println("]");

	System.out.println("Result: " + numWaysToClimb(N, X) + "\n");
    }

    public static void main(String[]args) {
	test(4, new int[] {1, 2});
	test(20, new int[] {1, 3, 5});
    }
}
