public class CanHopToEnd {


    // Keep taking steps and see if you reached end or can increase # steps remaining
    public static boolean canReachEnd(int[] ary) {
	if (ary.length == 0) return true; // Or is it false?? Question doesn't specify
	int steps = 1; // Number of available steps
	int current = -1; // Position on ary. Starting values set so that you start at 0
	while (current < ary.length) {
	    // Take a step
	    steps -= 1;
	    current += 1;
	    steps = Math.max(steps, ary[current]);
	    // Then check if you should stop
	    if (current == ary.length-1) return true; // Reached end
	    if (steps == 0) return false; // Can't progress further
	}
	return false; // Should never happen. I guess this means I have bad design somewhere
    }

    /* Testing purposes */

    public static void test(int[] ary) {
	System.out.print("[");
	for (int i = 0; i < ary.length; i++) {
	    System.out.print(ary[i]);
	    if (i != ary.length - 1) System.out.print(", ");
	}
	System.out.println("]");

	System.out.println("Can reach end: " + canReachEnd(ary));
    }

    public static void main(String[] args) {
	test(new int[] {2, 0, 1, 0});
	test(new int[] {1, 1, 0, 1});
	test(new int[] {});
	test(new int[] {1});
	test(new int[] {0});
	test(new int[] {10, 0, 0});
    }
}
