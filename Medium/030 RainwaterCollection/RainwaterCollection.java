public class RainwaterCollection {

    /*
      Edge cases:
        1. Elevation never descends
	2. Elevation never ascends
	3. Elevation is just a mountain (like this: ^ )

     */
    public static int waterTrapped(int[] elevation) {
	if (elevation.length <= 2) {
	    return 0;
	}
	int leftIndex = 0;
	int rightIndex = elevation.length - 1;
	int leftWall = elevation[leftIndex];
	int rightWall = elevation[rightIndex];
	int trappedWater = 0;
	// Find two walls
	while (leftIndex <= rightIndex && leftWall <= elevation[leftIndex]) {
	    leftWall = elevation[leftIndex];
	    leftIndex += 1;
	}
	while (rightIndex >= leftIndex && rightWall <= elevation[rightIndex]) {
	    rightWall = elevation[rightIndex];
	    rightIndex -= 1;
	}
	
	while (leftIndex <= rightIndex) {
	    if (leftWall <= rightWall) {
		if (elevation[leftIndex] < leftWall) {
		    System.out.println("Left: " + trappedWater + " + " + (leftWall - elevation[leftIndex]) + " = " + (trappedWater + leftWall - elevation[leftIndex]));
		    trappedWater += leftWall - elevation[leftIndex];
		} else {
		    leftWall = elevation[leftIndex];
		}
		leftIndex += 1;
	    } else {
		if (elevation[rightIndex] < rightWall) {
		    System.out.println("Right: " + trappedWater + " + " + (rightWall - elevation[rightIndex]) + " = " + (trappedWater + rightWall - elevation[rightIndex]));
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
