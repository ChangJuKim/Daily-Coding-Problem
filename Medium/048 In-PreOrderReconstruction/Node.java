public class Node {
    public Node parent;
    public Node left;
    public Node right;
    public String val;

    public Node(String value) {
	left = null;
	right = null;
	val = value;
    }

    public boolean hasAncestor(Node n) {
	Node head = this;
	while (head != null) {
	    if (head.val == n.val) {
		return true;
	    }
	    head = head.parent;
	}
	return false;
    }

    public void addLeft(Node n) {
	left = n;
	n.parent = this;
    }

    public void addRight(Node n) {
	right = n;
	n.parent = this;
    }

    // Note that this only compares value, not children
    public int compareTo(Node n) {
	if (n.val.equals(val)) {
	    return 0;
	} else {
	    return -1;
	}
    }
}
