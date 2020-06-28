public class ClockwisePrint {


    // Make sure it works in a rectangle
    public static void printClockwise(int[][] ary) {
	if (ary.length == 0) {
	    return;
	}
	// Setup starting variables
	int counter = ary.length * ary[0].length;
	Coordinate position = new Coordinate(0, 0);
	Constraints walls = new Constraints(-1, ary[0].length, -1, ary.length);
	String direction = "Right";
	System.out.println(ary[position.x][position.y]);

	while (counter > 1) {
	    if (direction.equals("Right")) {
		if (position.y + 1 == walls.right) {
		    direction = "Bot";
		    walls.top = position.x;
		} else {
		    position.y += 1;
		    counter -= 1;
		}
	    }

	    if (direction.equals("Bot")) {
		if (position.x + 1 == walls.bot) {
		    direction = "Left";
		    walls.right = position.y;
		} else {
		    position.x += 1;
		    counter -= 1;
		}
	    }

	    if (direction.equals("Left")) {
		if (position.y - 1 == walls.left) {
		    direction = "Top";
		    walls.bot = position.x;
		} else {
		    position.y -= 1;
		    counter -= 1;
		}
	    }

	    if (direction.equals("Top")) {
		if (position.x - 1 == walls.top) {
		    direction = "Right";
		    //walls.left += 1;
		    walls.left = position.y;
		    continue;
		} else {
		    position.x -= 1;
		    counter -= 1;
		}
	    }
	    System.out.println(ary[position.x][position.y]);
	}	    
    }

    // creates a 2d array filled with incrementing integers 
    private static int[][] createArray(int length, int height) {
	int[][] ary = new int[length][height];
	int counter = 1;
	for (int i = 0; i < length; i++) {
	    for (int j = 0; j < height; j++) {
		ary[i][j] = counter;
		counter++;
	    }
	}
	return ary;
    }

    public static void printArray(int[][] ary) {
	System.out.print("[");
	for (int i = 0; i < ary.length; i++) {
	    System.out.print("[");
	    for (int j = 0; j < ary[i].length; j++) {
		if (j == ary[i].length-1) {
		    System.out.println("" + ary[i][j] + "]");
		} else {
		    System.out.print("" + ary[i][j] + ", ");
		}
	    }
	}
	System.out.println("]");
    }

    public static void test(int length, int width) {
	System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
	int[][] ary = createArray(length, width);
	printArray(ary);
	printClockwise(ary);
	System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
    }

    public static void main(String[] args) {
	test(2, 4);
	test(5, 2);
	test(4, 4);
	test(3, 6);
    }
}
