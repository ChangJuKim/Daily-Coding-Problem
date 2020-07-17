public class MaxSum {


    
    public static int maxSum(int[] array) {
	int max = 0;
	int currentSum = 0;
	for (int i = 0; i < array.length; i++) {
	    if (currentSum < 0) {
		// It's better to restart at this index, than to start with a negative value
		currentSum = 0;
	    }
	    currentSum += array[i];
	    if (currentSum > max) {
		max = currentSum;
	    }
	}
	return max;
    }

    // For testing purposes
    public static void print(int[] array) {
	System.out.print("[");
	for (int i = 0; i < array.length; i++) {
	    if (i == array.length - 1) {
		System.out.print(array[i]);
	    } else {
		System.out.print("" + array[i] + ", ");
	    }
	}
	System.out.println("]");
    }

    // For testing purposes
    public static void test(int[] array) {
	print(array);
	System.out.println("Max sum: " + maxSum(array));
    }

    // For testing purposes
    public static void main(String[] args) {
	int[] test1 = new int[] {34, -50, 42, 14, -5, 86};
	int[] test2 = new int[] {-5, -1, -8, -9};
	int[] test3 = new int[] {};

	test(test1); // should be 137
	test(test2); // should be 0
	test(test3); // should be 0
	test(new int[] {0, 1, 0, 0, 0, 0, 2}); // should be 3
	test(new int[] {0, 1, -1, 0, 1, -1, 1, -1}); // should be 1
    }
}
