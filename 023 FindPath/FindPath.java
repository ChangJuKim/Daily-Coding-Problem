import java.util.ArrayList;

public class FindPath {


    public static void modifying(boolean[][] board, int x, int y) {
	board[x][y] = !board[x][y];
    }

    public static void printBoard(boolean[][] board) {
	for (int i = 0; i < board.length; i++) {
	    System.out.print("[");
	    for (int j = 0; j < board[i].length; j++) {
		if (j == 0) {
		    System.out.print(board[i][j]);
		} else {
		    System.out.print(", " + board[i][j]);
		}
	    }
	    System.out.print("]\n");
	}
	System.out.println();
    }

    public static int findPath(boolean[][] board, ArrayList<Coordinate> positions, Coordinate end) {
	printBoard(board);
	ArrayList<Coordinate> newPositions = new ArrayList<Coordinate>();
	for (int i = 0; i < positions.size(); i++) {
	    Coordinate current = positions.get(i);
	    if (current.equals(end)) {
		return 0;
	    }
	    Coordinate[] neighbors = current.neighbors();
	    for (int j = 0; j < 4; j++) {
	        Coordinate neighbor = neighbors[j];
		// if a neighbor is an accessible path
		if (!neighbor.outOfBounds(board.length, board[0].length) && !board[neighbor.x][neighbor.y]) {
		    newPositions.add(neighbors[j]);
		    board[neighbors[j].x][neighbors[j].y] = true;
		}
	    }
	}
	if (newPositions.size() == 0) {
	    return -999; // Ideally this would be something like -1 * board.size * board[0].size to ensure result is negative
	}
	return 1 + findPath(board, newPositions, end);
    }

    public static int findPathWrapper(boolean[][] board, Coordinate start, Coordinate end) {
	ArrayList<Coordinate> newPositions = new ArrayList<Coordinate>(1);
	newPositions.add(start);
	board[start.x][start.y] = true;
	int distance = findPath(board, newPositions, end);
	if (distance < 0) {
	    System.out.println("There is no path.");
	    return -1;
	} else {
	    System.out.println("Path is " + distance + " long");
	    return distance;
	}
    }

    // Have to test!
    public static void main(String[] args) {
	boolean[][] board = new boolean[4][4];

	modifying(board, 1, 0);
	modifying(board, 1, 1);
	modifying(board, 1, 3);
	modifying(board, 3, 0);
	modifying(board, 2, 3);
	System.out.println("Starting board: ");
	printBoard(board);

	findPathWrapper(board, new Coordinate(3, 0), new Coordinate(0, 0));
	
    }
}
