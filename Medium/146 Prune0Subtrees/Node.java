public class Node {
    public Node left;
    public Node right;
    // Can only be 0 or 1. Well value can be anything but if it's not 0 code assume it's 1
    public int value;

    public Node(int _value) {
	left = null;
	right = null;
	value = _value;
    }

    public Node() {
	left = null;
	right = null;
	value = 0;
    }

    @Override
    public String toString() {
	String leftValue = left == null ? "null" : "" + left.value;
	String rightValue = right == null ? "null" : "" + right.value;
	return "value: " + value + "; left: " + leftValue + "; right: " + rightValue;
    }
}
