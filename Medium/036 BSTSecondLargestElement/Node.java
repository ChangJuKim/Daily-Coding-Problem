public class Node {
    public Node left;
    public Node right;
    public int val;

    public Node(int value) {
	left = null;
	right = null;
	val = value;
    }

    @Override
    public String toString() {
	return "" + val;
    }
    
}
