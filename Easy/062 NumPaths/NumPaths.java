import java.util.Random;

public class NumPaths {
    

    
    // N x M time,
    // N x M storage
    public static int numPaths(int N, int M) {
	if (N == 0 || M == 0) {
	    return 0;
	}
	int[][] board = new int[N][M];
	board[0][0] = 1;
	for (int i = 0; i < N; i++) {
	    for (int j = 0; j < M; j++) {
		if (i+1 < N) {
		    board[i+1][j] += board[i][j];
		}
		if (j+1 < M) {
		    board[i][j+1] += board[i][j];
		}
	    }
	}
	return board[N-1][M-1];
    }

    // n C r
    // Runtime: (n - r) + r
    public static int combination(int n, int r) {
	int total = 1;
	// can break on too large numbers
	// replace with BigInteger if necessary
	for (int i = n; i > n-r; i--) {
	    total *= i;
	}
	for (int j = r; j > 0; j--) {
	    total /= j;
	}
	return total;
    }

    // (N+M-2) time
    public static int numPathsConstant(int N, int M) {
	int n = N + M - 2;
	int r = N - 1;

	return combination(n, r);
    }
    

    public static void main(String[] args) {
	int N = 3;
	int M = 4;
	Random rand = new Random();
	int testCases = 10;
	for (int i = 0; i < testCases; i++) {
	    N = rand.nextInt(10);
	    M = rand.nextInt(10);
	    System.out.println("(Original) For " + N + " by " + M + " board: " + numPaths(N, M));
	    System.out.println("(Constant) For " + N + " by " + M + " board: " + numPathsConstant(N, M));
	    System.out.println("   Works: " + (numPaths(N, M) == numPathsConstant(N, M)) + "\n");
	    
	}
    }
}
