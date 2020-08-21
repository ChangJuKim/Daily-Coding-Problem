public class NextBiggest {
    
    // Checks which case to run
    public static Node nextBiggest(Node n) {
	if (n == null) return;
	/* Case 1: has a right child */
	if (n.right != null) return getLeftmostRightchild(n);

	/* Case 2: check n's parents */
	return loopParents(n);
    }

    // Case 1: Given node has a right child. Find leftmost of given's rightchild
    private static Node getLeftmostRightchild(Node n) {
	n = n.right;
	while (n.left != null) {
	    n = n.left;
	}
	return n;
    }

    // Case 2: Find first parent larger than given
    private static Node loopParents(Node n) {
	while (n.parent != null || n.parent.right == n) {
	    n = n.parent;
	}
	
	// n is biggest element
	if (n.parent == null) {
	    return null;
	} else {
	    // n is n.parent's leftchild
	    return n.parent;
	}
    }
}
