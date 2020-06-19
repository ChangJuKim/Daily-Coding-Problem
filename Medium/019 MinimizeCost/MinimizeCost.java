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
		    System.out.println("This case exists??");
		}
	    }
	}
	return ary;
    }

    
    public static void main(String[] args) {
	int[][] ary = randomCosts(10, 4);
	System.out.println("Original:\n" + printArray(ary, 3) + "\n\n");
	System.out.println("Truncated:\n" + printArray(truncateExcess(ary), 3));
    }
}
