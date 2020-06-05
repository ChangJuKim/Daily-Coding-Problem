public class MaxProfit {

    // Run through the array.
    // Keep track of the current max profit, and the minimum integer
    // If...
    //   1. You encounter a new minimum: update minimum.
    //   2. You current profit < (profit from buying at min, and selling at current): update profit
    public static int maxProfit(int[] ary) {
	int currentProfit = 0;
	int min = Integer.MAX_VALUE;
	for (int i = 0; i < ary.length; i++) {
	    if (ary[i] < min) {
		min = ary[i];
	    } else if (ary[i] - min > currentProfit) {
		currentProfit = ary[i] - min;
	    }
	}
	return currentProfit;
    }

    // must be greater than size 0
    public static void printArray(int[] ary) {
        System.out.print("[");
	for (int i = 0; i < ary.length; i++) {
	    if (i == 0) { System.out.print(ary[i]); }
	    else { System.out.print(", " + ary[i]); }
	}
	System.out.println("]");
    }
    
    public static void main(String[] args) {
	int[] ary = new int[] {9, 100, 8, 5, 7, 10};
	printArray(ary);
	System.out.println("Max profit: " + maxProfit(ary));
    }
}
