public class RotateMatrix {



    public static int[][] rotate(int[][] ary) {
	int n = ary.length;
	
	// N is even
	if (ary.length % 2 == 0) {
	    // Somehow I f'd up. So this is actually
	    // Rotate 2nd and 3rd quadrant
	    for (int i = 0; i < n/2; i++) {
		for (int j = 0; j < n/2; j++) {
		    // Swap 1st quadrant clockwise
		    int temp = ary[i][j];
		    ary[i][j] = ary[n-j-1][i];
		    ary[n-j-1][i] = temp;

		    // Swap 4th quadrant cw
		    temp = ary[n-i-1][n-j-1];
		    ary[n-i-1][n-j-1] = ary[j][n-i-1];
		    ary[j][n-i-1] = temp;
		}
	    }

	    printArray(ary);
	    
	    // Swap new 2nd and 3rd quadrant
	    for (int i = 0; i < n/2-1; i++) {
		for (int j = n/2; j < n; j++) {
		    int temp = ary[i][j];
		    ary[n-i-1][n-j-1] = ary[i][j];
		    ary[i][j] = temp;
		}
	    }
	}

	// N is odd
	if (ary.length % 2 == 1) {
	    // Rotate... something weird. It's in README
	    for (int i = 0; i <= n/2; i++) {
		for (int j = i; j < n-i-2; j++) {
		    int temp = ary[i][j];
		    ary[i][j] = ary[n-j-1][i];
		    ary[n-j-1][i] = temp;
		}
	    }
	    // Now rotate the other side
	    for (int i = n-1; i > n/2 + 1; i--) {
		for (int j = i; j >= n-i; j--) {
		    int temp = ary[i][j];
		    ary[i][j] = ary[n-j-1][i];
		    ary[n-j-1][i] = temp;
		}
	    }

	    printArray(ary);


	    // Swap the others
	    // I haven't done the math/figuring out for this part
	    // But i'm pretty sure if you swap i and j you get good results
	    for (int j = 0; j < n/2; j++) {
		for (int i = j; i < n-j-2; i++) {
		    int temp = ary[i][j];
		    ary[n-i-1][n-j-1] = ary[i][j];
		    ary[i][j] = temp;
		}
	    }
	}
	return ary;
    }

    // ~~~~~~~~~~~~ TESTING ~~~~~~~~~~~~~~
    
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
    public static void printArray(int[][] ary) {
	System.out.println("[");
	for (int i = 0; i < ary.length; i++) {
	    printArray(ary[i]);
	}
	System.out.println("]");
    }


    public static int[][] makeArray(int n) {
	int[][] ary = new int[n][n];
	int counter = 1;
	for (int i = 0; i < n; i++) {
	    for (int j = 0; j < n; j++) {
		ary[i][j] = counter;
		counter++;
	    }
	}
	return ary;
    }
    
    

    public static void main(String[] args) {
	int[][] ary = makeArray(4);
	printArray(ary);

	ary = rotate(ary);
	printArray(ary);
	

	
    }
    
}

