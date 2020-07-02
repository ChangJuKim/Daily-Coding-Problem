public class RainwaterCollection {

    public static int waterTrapped(int[] elevation) {
	if (elevation.length <= 2) {
	    return 0;
	}
	int leftIndex = 0;
	int rightIndex = elevation.length - 1;
	int leftWall = elevation[leftIndex];
	int rightWall = elevation[rightIndex];
	int trappedWater = 0; // Total water / Answer
	
	// Find two tall walls
	while (leftIndex <= rightIndex && leftWall <= elevation[leftIndex]) {
	    leftWall = elevation[leftIndex];
	    leftIndex += 1;
	}
	while (rightIndex >= leftIndex && rightWall <= elevation[rightIndex]) {
	    rightWall = elevation[rightIndex];
	    rightIndex -= 1;
	}

	// Start determining water trapped
	while (leftIndex <= rightIndex) {
	    // Start at the smaller wall
	    if (leftWall <= rightWall) {
		if (elevation[leftIndex] < leftWall) {
		    trappedWater += leftWall - elevation[leftIndex];
		} else {
		    leftWall = elevation[leftIndex];
		}
		leftIndex += 1;
	    } else { // Same logic as before but with right index instead
		if (elevation[rightIndex] < rightWall) {
		    trappedWater += rightWall - elevation[rightIndex];
		} else {
		    rightWall = elevation[rightIndex];
		}
		rightIndex -= 1;
	    }
	}
	return trappedWater;
    }

    public static void printArray(int[] ary) {
	System.out.print("[");
	for (int i = 0; i < ary.length; i++) {
	    if (i == ary.length - 1) {
		System.out.print("" + ary[i]);
	    } else {
		System.out.print("" + ary[i] + ", ");
	    }
	}
	System.out.println("]");
    }


    public static void test(int[] ary) {
	printArray(ary);
	System.out.println("water trapped: " + waterTrapped(ary) + "\n");
    }

    public static void main(String[] args) {
	test(new int[] {2, 1, 2});
	test(new int[] {3, 0, 1, 3, 0, 5});
	test(new int[] {0, 1, 3, 3, 4, 5});
	test(new int[] {5, 4, 3, 3, 1, 0});
	test(new int[] {1, 2, 3, 2, 1});
	test(new int[] {1, 2, 3, 3, 2, 1});
	test(new int[] {});
	test(new int[] {1});
	test(new int[] {1, 2});
	test(new int[] {2, 1});
	test(new int[] {1, 2, 3, 10, 3, 11, 5, 13, 6, 3, 3, 10, 3, 2, 1});
    }
}
