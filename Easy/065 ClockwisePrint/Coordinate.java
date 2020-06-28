public class Coordinate {
    public int x;
    public int y;

    public Coordinate(int _x, int _y) {
	x = _x;
	y = _y;
    }

    public Coordinate add(Coordinate c) {
	return new Coordinate(x + c.x, y + c.y);
    }

    @Override
    public String toString() {
	return "(" + x + ", " + y + ")";
    }
}
