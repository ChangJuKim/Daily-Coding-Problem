public class Reconstruction {
    private static String[] preorder;
    private static String[] inorder;
    private static int preIndex;
    private static int inIndex;

    // Appropriately assigns children
    // Recursive function
    public static void fillChild(Node head) {
        if (!preorder[preIndex].equals(inorder[inIndex])) {
	    // Need to keep going left
	    head.addLeft(new Node(preorder[preIndex]));
	    preIndex += 1;
	    fillChild(head.left);
	} else {
	    head.addLeft(new Node(preorder[preIndex]));
	    preIndex += 1;
	    inIndex += 1;
	    if (head.left.hasAncestor(new Node(inorder[inIndex]))) {
	    // Added a leaf node to the left child
		
	    }
	}
	// Do something about right child;
    }

    public static Node reconstruct(String[] _preorder, String[] _inorder) {
	preorder = _preorder;
	inorder = _inorder;
	if (preorder.length == 0 || inorder.length == 0) {
	    return null;
	}
        Node root = new Node(preorder[0]);
	preIndex = 1;
	inIndex = 0;
	fillChild(root);
	return root;
    }
}
