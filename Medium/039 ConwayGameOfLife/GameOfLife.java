import java.util.ArrayList;

public class GameOfLife {

    // Creates int[9] representing 9 indicies.
    // Finds the minimum coordinate and prints it out.
    // Increments the index corresponding to that coordinate
    public static void printCells(ArrayList<ArrayList<Coordinate>> hashed) {
        ArrayList<Integer> indices = new ArrayList<Integer>(hashed.size());
	for (int i = 0; i < hashed.size(); i++) {
	    indices.add(0);
	}
	Coordinate min;
	while (true) {
	    int increment = -1; // helps increment indicies
	    min = new Coordinate(Integer.MAX_VALUE, Integer.MAX_VALUE);
	    for (int hashIndex = 0; hashIndex < indices.size(); hashIndex++) {
		int index = indices.get(hashIndex);
		if (index < hashed.get(hashIndex).size()) {
		    Coordinate point = hashed.get(hashIndex).get(index);
		    if (min.compareTo(point) >= 0) {
			min = point;
			increment = hashIndex;
		    }
		}
	    }
	    if (min.x != Integer.MAX_VALUE && min.y != Integer.MAX_VALUE) {
		indices.set(increment, indices.get(increment) + 1);
		System.out.print("" + min + ", ");
	    } else {
		System.out.println();
		break;
	    }
	}
    }

    public static ArrayList<ArrayList<Coordinate>> hashLiveCells(ArrayList<Coordinate> cells) {
	ArrayList<ArrayList<Coordinate>> hashed = new ArrayList<ArrayList<Coordinate>>(9);
	for (int i = 0; i < 9; i++) {
	    hashed.add(new ArrayList<Coordinate>());
	}
	for (int i = 0; i < cells.size(); i++) {
	    Coordinate cell = cells.get(i);
	    hashed.get(cell.modulo9()).add(cell);
	}
	return hashed;
    }

    private static ArrayList<Coordinate> getNeighbors(Coordinate point, ArrayList<ArrayList<Coordinate>> hashed) {
	ArrayList<Coordinate> ary = new ArrayList<Coordinate>();
	return ary;
    }
    
    public static void gameOfLife(ArrayList<ArrayList<Coordinate>> hashed, int steps) {
	for (int hashIndex = 0; hashIndex < hashed.size(); hashIndex++) { // 0-8
	    for (int index = 0; index < hashed.get(hashIndex).size(); index++) {
		Coordinate point = hashed.get(hashIndex).get(index);
		// Find neighbors
		ArrayList<Coordinate> neighbors = getNeighbors(point, hashed);
	    }
	}
    }

    public static void main(String[] args) {
	ArrayList<Coordinate> cells = new ArrayList<Coordinate>();
	for (int i = 0; i < 4; i++) {
	    for (int j = 0; j < 4; j++) {
		cells.add(new Coordinate(i, j));
	    }
	}
	ArrayList<ArrayList<Coordinate>> hashed = hashLiveCells(cells);
	System.out.println(hashed);
	printCells(hashed);
    }

    
}
