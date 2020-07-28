public class CountDiagonals {
    /*
      Assumes bishop coordinates >= 0
      Assumes bishop coordinates are unique
        I.e. no two bishops have the same coordinates
     */

    // Finds board dimensions
    //   x dimensions: 0 - max_x inclusive
    //   y dimensions: 0 - max_y inclusive
    // Note that board may not be square (but instead rectangular)
    public static int[] boardSize(int[][] bishops) {
	int max_x = 0;
	int max_y = 0;
	for (int i = 0; i < bishops.length; i++) {
	    int[] current = bishops[i];
	    if (current[0] > max_x) {
		max_x = current[0];
	    }
	    if (current[1] > max_y) {
		max_y = current[1];
	    }
	}
	return new int[] {max_x, max_y};
    }

    /*
      LeftDiagonal  = \
      RightDiagonal = /
      
      Given board 
      [(0,0) (0,1) (0,2) (0,3)]
      [(1,0) (1,1) (1,2) (1,3)]
      [(2,0) (2,1) (2,2) (2,3)]

      leftDiagonal[0] = diagonal at (2,0)
      leftDiagonal[5] = diagonal at (0,3)

      rightDiagonal[0] = diagonal at (0,0)
      rightDiagonal[5] = diagonal at (2,3)
     */

    // Returns index for leftDiagonal based on the parameters above.
    public static int leftHash(int[] boardSize, int[] coordinate) {
	int hash = coordinate[1] - coordinate[0];
	return hash + boardSize[0]; // Shifts hash so lowest value is 0
    }

    // Same as above but for right diag
    public static int rightHash(int[] boardSize, int[] coordinate) {
	int hash = coordinate[0] + coordinate[1];
	return hash; // I just like the symmetry so I left the hash variable alone
	// It occurs to me that you don't need boardSize for this one. I'll leave it
    }

    // Called variable left for simplicity. left (or right) = diagonals
    public static int countIntersections(ArrayList<ArrayList<Integer[]>> left) {
	int count = 0;
	for (int i = 0; i < left.size(); i++) {
	    count += countIntersections(left.get(i));
	}
    }

    // Counts intersections in one diagonal
    // 2 bishops => 1
    // 3 bishops => 3
    // 4 bishops => 6
    // bishops: 0, 1, 3, 6, 10, 15...
    //          = n(n-1) / 2
    public static int countIntersections(ArrayList<Integer[]> diagonal) {
	int numBishops = diagonal.size();
	return (numBishops * (numBishops-1)) / 2;
    }


    public static int countDiagonals(int[][] bishops) {
	int[] boardSize = boardSize(bishops);
	// Initialize left/right. Holds all bishops. Hashed by functions above
	ArrayList<ArrayList<Integer[]>> left = new ArrayList<ArrayList<Integer[]>>();
	ArrayList<ArrayList<Integer[]>> right = new ArrayList<ArrayList<Integer[]>>();
	for (int i = 0; i < boardSize[0] + boardSize[1] - 1; i++) {
	    left.add(new ArrayList<Integer[]>());
	    right.add(new ArrayList<Integer[]>());
	}
	/*
	  For those confused:
	    left[x][y][z]:
	      x is the hashings of all bishops. Each value in x is a new diagonal
	      y just holds all bishops. Each value in y is a bishop
	      z is a coordinate for a bishop. Hence, an Integer[]
	 */

	// Add bishops to appropriate diagonal
	for (int i = 0; i < bishops.length; i++) {
	    int[] current = bishops[i]; // current bishop
	    left.get(leftHash(boardSize, current)).add(current);
	    right.get(rightHash(boardSize, current)).add(current);
	}

	int count = countIntersections(left);
	count += countIntersections(right);
	return count;
    }
}
