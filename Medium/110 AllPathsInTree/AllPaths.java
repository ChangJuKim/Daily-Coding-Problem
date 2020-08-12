import java.util.ArrayList;

public class AllPaths {
    private static class Node {
	public Node left;
	public Node right;
	public int value;

	public Node(int _value) {
	    left = null;
	    right = null;
	    value = _value;
	}

	@Override
	public String toString() {
	    return "" + value;
	}
    }

    private static ArrayList<ArrayList<Node>> paths;
    
    // Wrapper function
    public static void findPaths(Node root) {
	paths = new ArrayList<ArrayList<Node>>();
	ArrayList<Node> current = new ArrayList<Node>();
	if (root == null) {
	    paths.add(current);
	    return;
	}
	findPaths(root, current);
    }

    public static void findPaths(Node node, ArrayList<Node> current) {
	current.add(node);
	if (node.left != null) {
	    findPaths(node.left, current);
	    current.remove(current.size()-1);
	}
	if (node.right != null) {
	    findPaths(node.right, current);
	    current.remove(current.size()-1);
	}
	if (node.left == null && node.right == null) {
	    paths.add((ArrayList<Node>)current.clone());
	}
    }

    /* Testing purposes */

    public static void main(String[] args) {
	Node root = new Node(1);
	root.left = new Node(2);
	root.right = new Node(3);
	root.right.left = new Node(4);
	root.right.right = new Node(5);

	findPaths(root);
	System.out.println(paths);

	root = new Node(0);
	findPaths(root);
	System.out.println(paths);

	root = null;
	findPaths(root);
	System.out.println(paths);
    }
}
