import java.util.Random;

public class Rand {


    public static int rand5() {
	Random rand = new Random();
	return rand.nextInt(5) + 1;
    }

    // Roll the 5-sided die twice.
    // Depending on the two die, return 1-7.
    // If you get 5-2, 5-3, 5-4, or 5-5: reroll.
    public static int rand7() {
	int randOne = 5;
	int randTwo = 5;
	while (randOne == 5 && randTwo != 1) {
	    // 52, 53, 54, 55 => REROLL
	    randOne = rand5();
	    randTwo = rand5();
	}
	switch(randOne) {
	case 1:
	    if (randTwo <= 3) { return 1; } // 11, 12, 13 => RETURN 1
	    else { return 2; } // 14, 15, 21 => RETURN 2
	case 2:
	    if (randTwo <= 1) { return 2; }
	    else if (randTwo <= 4) { return 3; } // 22, 23, 24 => RETURN 3
	    else { return 4; } // 25, 31, 32 => RETURN 4
	case 3:
	    if (randTwo <= 2) { return 4; }
	    else { return 5; } // 33, 34, 35 => RETURN 5
	case 4:
	    if (randTwo <= 3) { return 6; } // 41, 42, 43 => RETURN 6
	    else { return 7; } // 44, 45, 51 => RETURN 7
	default:
	    return 7;
	}
    }


    // must be greater than size 0
    public static void printArray(int[] ary) {
        System.out.print("[" + ary[0]);
	for (int i = 1; i < ary.length; i++) {
	    System.out.print(", " + ary[i]);
	}
	System.out.println("]");
    }

    public static void main(String[] args) {
	int testCases = 10000004;
	int[] num = new int[7];
	for (int i = 0; i < testCases; i++) {
	    num[rand7() - 1] += 1;
	}
	printArray(num);
	for (int i = 0; i < num.length; i++) {
	    num[i] -= testCases / 7;
	}
	printArray(num);
    }
}
