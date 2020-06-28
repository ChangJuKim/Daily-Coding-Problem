
// Simple class to constrain dimensions of a 2D array
public class Constraints {
    public int left;
    public int right;
    public int top;
    public int bot;

    public Constraints(int _left, int _right, int _top, int _bot) {
	left = _left;
	right = _right;
	top = _top;
	bot = _bot;
    }

    @Override
    public String toString() {
	return "[" + left + " ~ " + right + "] [" + top + " ~ " + bot + "]";
    }
}
