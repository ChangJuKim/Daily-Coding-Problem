public class ContainsIntervals {

    public static int[] smallestContainingInterval(int[][] intervals) {
	if (intervals.length == 0) {
	    return null;
	}

	int[] mostRestrictive = new int[] {intervals[0][0], intervals[0][1]};
	boolean canShrink = true; // Interval can get smaller
	for (int i = 1; i < intervals.length; i++) {
	    int[] newInterval = intervals[i];
	    // Intervals don't overlap
	    if (newInterval[0] > mostRestrictive[1]) {
		if (canShrink) {
		    mostRestrictive[0] = mostRestrictive[1];
		}
		mostRestrictive[1] = newInterval[0];
		canShrink = false;
	    } else if (newInterval[1] < mostRestrictive[0]) {
		if (canShrink) {
		    mostRestrictive[1] = mostRestrictive[0];
		}
		mostRestrictive[0] = newInterval[1];
		canShrink = false;
	    } else {
		// Intervals do overlap
		if (canShrink) {
		    // Nested intervals can shrink down
		    if (newInterval[0] > mostRestrictive[0]) mostRestrictive[0] = newInterval[0];
		    if (newInterval[1] < mostRestrictive[1]) mostRestrictive[1] = newInterval[1];
		}
	    }
	}
	if (canShrink) {
	    mostRestrictive[1] = mostRestrictive[0];
	}
	return mostRestrictive;
    }


    /*   Testing   */

    // Retrieved from CommonlyUsedCode
    public static void printArray(int[] ary) {
	System.out.print("[");
	for (int i = 0; i < ary.length; i++) {
	    if (i == ary.length - 1) {
		System.out.print(ary[i]);
	    } else {
		System.out.print("" + ary[i] + ", ");
	    }
	}
	System.out.println("]");
    }
    // Retrieved from CommonlyUsedCode
    public static void printArray(int[][] ary) {
	System.out.println("[");
	for (int i = 0; i < ary.length; i++) {
	    printArray(ary[i]);
	}
	System.out.println("]");
    }

    
    public static void test(int[][] intervals) {
	printArray(intervals);
	System.out.print("result: ");
	printArray(smallestContainingInterval(intervals));
	System.out.println();
    }

    
    public static void main(String[] args) {
	int[] oneTen = new int[] {1, 10};
	int[] twoElev = new int[] {2, 11};
	int[] fiveSix = new int[] {5, 6};
	int[] sevEight = new int[] {7, 8};
	int[] thirtFourt = new int[] {13, 14};

	int[] zeroThree = new int[] {0, 3};
	int[] twoSix = new int[] {2, 6};
	int[] threeFour = new int[] {3, 4};
	int[] sixNine = new int[] {6, 9};

	test(new int[][] {zeroThree, twoSix, threeFour, sixNine});
	test(new int[][] {oneTen});
	test(new int[][] {oneTen, twoElev});
	test(new int[][] {oneTen, twoElev, thirtFourt});
	test(new int[][] {oneTen, fiveSix});
	test(new int[][] {oneTen, fiveSix, sevEight});
	test(new int[][] {new int[] {1,1}, new int[] {2,2}, new int[] {100,100}});
    }
}
