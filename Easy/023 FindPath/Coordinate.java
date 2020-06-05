public class Coordinate {
    public int x;
    public int y;

    public Coordinate(int _x, int _y) {
	x = _x; y = _y;
    }

    public Coordinate() {
	x = y = 0;
    }

    public Coordinate[] neighbors() {
	Coordinate[] neighbor = new Coordinate[4];
	neighbor[0] = new Coordinate(x-1, y);
	neighbor[1] = new Coordinate(x, y-1);
	neighbor[2] = new Coordinate(x+1, y);
	neighbor[3] = new Coordinate(x, y+1);
	return neighbor;
    }

    @Override
    public boolean equals(Object o) {
	if (o == this) {
	    return true;
	}
	
	if (!(o instanceof Coordinate)) {
	    return false;
	}
	
	Coordinate c = (Coordinate)o;
	if (c.x == x && c.y == y) {
	    return true;
	} else {
	    return false;
	}
    }
    
    // Assumes board is a boardx by boardy size
    // Thus board[boardx][boardy] is not in the board
    public boolean outOfBounds(int boardx, int boardy) {
	return x < 0 || y < 0 || x >= boardx || y >= boardy;
    }
}
