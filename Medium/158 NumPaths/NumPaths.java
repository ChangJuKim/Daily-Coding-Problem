public class NumPaths {


    // Note that paths are negative and walls == 1
    public static int numPaths(int[][] ary) {
	if (ary.length == 0 || ary[0].length == 0) return 0;
	ary[0][0] = -1;
	
	for (int x = 0; x < ary.length; x++) {
	    for (int y = 0; y < ary.length; y++) {
		if (ary[x][y] != 1) {
		    // Add current value to the right, and to the bottom
		    if (x+1 < ary.length && ary[x+1][y] != 1) ary[x+1][y] += ary[x][y];
		    if (y+1 < ary[x].length && ary[x][y+1] != 1) ary[x][y+1] += ary[x][y];
		}
	    }
	}
	return ary[ary.length-1][ary[0].length-1] * -1;
    }

    /* Testing */

    public static void main(String[] args) {
	int[][] ary = new int[3][3];
	ary[0] = new int[] {0, 0, 1};
	ary[1] = new int[] {0, 0, 1};
	ary[2] = new int[] {1, 0, 0};
	System.out.println(numPaths(ary));
    }
}
