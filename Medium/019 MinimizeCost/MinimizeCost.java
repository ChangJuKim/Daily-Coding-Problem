import java.util.Random;

public class MinimizeCost {


    public static int[][] randomCosts(int N, int K) {
	Random rand = new Random();
	int[][] costs = new int[K][N];
	for (int i = 0; i < costs.length; i++) {
	    costs[i] = new int[N];
	    for (int j = 0; j < costs[i].length; j++) {
		costs[i][j] = rand.nextInt(900) + 100;
	    }
	}
	return costs;
    }

    public static String printArray(int[][] ary) {
	String result = "[\n";
	for (int i = 0; i < ary.length; i++) {
	    result += "[";
	    for (int j = 0; j < ary[i].length; j++) {
		if (j == ary[i].length - 1) {
		    result += ary[i][j] + "]\n";
		} else {
		    result += ary[i][j] + ", ";
		}
	    }
	}
	return result + "]";
    }

    public static int getDigit(int num) {
	int digit = 1;
	while (num > 9) {
	    num = num / 10;
	    digit += 1;
	}
	return digit;
    }

    // Ensures there is at least <space> space between each comma
    public static String printArray(int[][] ary, int space) {
	String result = "[\n";
	for (int i = 0; i < ary.length; i++) {
	    result += "[";
	    for (int j = 0; j < ary[i].length; j++) {
		String number = "" + ary[i][j];
		int needSpaces = space - getDigit(ary[i][j]);
		for (int z = 0; z < needSpaces; z++) {
		    number += " ";
		}
		if (j == ary[i].length - 1) {
		    result += number + "]\n";
		} else {
		    result += number + ", ";
		}
	    }
	}
	return result + "]";
    }

    // Replaces all but the lowest -> third lowest cost values with 0
    public static int[][] truncateExcess(int[][] ary) {
	System.out.println(ary.length);
	if (ary.length <= 3) {
	    return ary;
	}
	for (int j = 0; j < ary[0].length; j++) {
	    int min = -3; // holds i index
	    int min2 = -2;
	    int min3 = -1;
	    for (int i = 0; i < ary.length; i++) {
		if (min < 0 || ary[i][j] < ary[min][j]) {
		    if (min3 >= 0) {
			ary[min3][j] = 0;
		    }
		    min3 = min2;
		    min2 = min;
		    min = i;
		} else if (min2 < 0 || ary[i][j] < ary[min2][j]) {
		    if (min3 >= 0) {
			ary[min3][j] = 0;
		    }
		    min3 = min2;
		    min2 = i;
		} else if (min3 < 0 || ary[i][j] < ary[min3][j]) {
		    if (min3 >= 0) {
			ary[min3][j] = 0;
		    }
		    min3 = i;
		} else if (ary[i][j] > ary[min3][j]) {
		    ary[i][j] = 0;
		} else {
		    // Shouldn't exist but I didn't want to through the loop invariants.
		    System.out.println("This case exists??");
		}
	    }
	}
	return ary;
    }

    // Returns [i, i2, i3] such that ary[i][j] = min, ary[i2][j] = min2, ary[i3][j] = min3
    // Has similar logic to truncateExcess
    // CANNOT HANDLE ARRAYS WITH ARRAY[0].LENGTH < 3
    public static int[] getMinimums(int[][] ary, int j) {
        int min = -3;
	int min2 = -2;
	int min3 = -1;
	for (int i = 0; i < ary.length; i++) {
	    if (min < 0 || ary[i][j] < ary[min][j]) {
		if (min3 >= 0) {
		    ary[min3][j] = 0;
		}
		min3 = min2;
		min2 = min;
		min = i;
	    } else if (min2 < 0 || ary[i][j] < ary[min2][j]) {
		if (min3 >= 0) {
		    ary[min3][j] = 0;
		}
		min3 = min2;
		min2 = i;
	    } else if (min3 < 0 || ary[i][j] < ary[min3][j]) {
		if (min3 >= 0) {
		    ary[min3][j] = 0;
		}
		min3 = i;
	    } else if (ary[i][j] > ary[min3][j]) {
		ary[i][j] = 0;
	    } else {
		// Shouldn't exist but I didn't want to through the loop invariants.
		System.out.println("This case exists??");
	    }
	}
	return new int[] {min, min2, min3};
    }
    
    // Doesn't work for this very specific case:
    // h1: 1, 9999, 9999, 9999
    // h2: 1, 3, 2, 999, 999, 999
    // h3: 9999, 9999, 1, 999, 999
    // Can be update to fix it, would have to increase minimums by one, and create significantly more if cases

    // This is actually complicated logic and I think I messed up somewhere. I'm stopping for now
    public static int minCost(int[][] costs) {
	int[] temp = getMinimums(costs, 0); // Reminder that this hold indicies
	int[] minimums = new int[] {temp[0], temp[1]}; // temp but only holds two values
	int[] minCosts = new int[] {costs[temp[0]][0], costs[temp[1]][0], costs[temp[2]][0]};
	for (int j = 1; j < costs[0].length; j++) {
	    temp = getMinimums(costs, j);
	    // update temp[0]
	    if (temp[0] != minimums[0]) {
		temp[0] = minimums[0];
		minCosts[0] += costs[temp[0][j]];
	    } else {
		temp[0] = minimums[1];
		minCosts[0] += costs[temp[0][j]];
	    }
	    // update temp[1]
	    if (temp[1] != minimums[0]) {
		temp[1] = minimums[0];
		minCosts[1] += costs[temp[1][j]];
	    } else {
		temp[1] = minimums[1];
		minCosts[1] += costs[temp[1][j]];
	    }
	    // update temp[2]
	    if (temp[2] != minimums[0]) {
		temp[2] = minimums[0];
		minCosts[2] += costs[temp[2][j]];
	    } else {
		temp[2] = minimums[1];
		minCosts[2] += costs[temp[2][j]];
	    }
	    // Update minimums
	    if (minCosts[0] <= minCosts[1]) {
		if (minCosts[0] <= minCosts[2]) {
		    minimums[0] = 0;
		    if (minCosts[1] <= minCosts[2]) {
			minimums[1] = 1;
		    } else {
			minimums[1] = 2;
		    }
		} else {
		    minimums[0] = 2;
		    minimums[1] = 0;
		}
	    } else if (minCosts[1] <= minCosts[2]) {
		minimums[0] = 1;
		
	    }
	}
	return Math.min(Math.min(minCosts[0], minCosts[1]), minCosts[2]);
    }

    
    public static void main(String[] args) {
	int[][] ary = randomCosts(10, 4);
	System.out.println("Original:\n" + printArray(ary, 3) + "\n\n");
	System.out.println("Truncated:\n" + printArray(truncateExcess(ary), 3));
    }
}
