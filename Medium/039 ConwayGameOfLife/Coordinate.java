public class Coordinate {
    // As this will be used in a board, coordinates should not change
    public final int x;
    public final int y;
    // May not be necessary; we only keep track of live cells
    public boolean alive;
    
    public Coordinate(int _x, int _y) {
	x = _x;
	y = _y;
	alive = true;
    }

    public Coordinate(int _x, int _y, boolean _alive) {
	x = _x;
	y = _y;
	alive = _alive;
    }

    @Override
    public String toString() {
	return "(" + x + ", " + y + ")";
    }

    public int compareTo(Coordinate c) {
	if (x != c.x) {
	    return x - c.x;
	} else {
	    return y - c.y;
	}
    }
    
    public int modulo9() {
	return (x % 3) * 3 + (y % 3);
    }
}
