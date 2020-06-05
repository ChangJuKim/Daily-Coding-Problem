public class ArithmeticTree {

    // Assumes n.value is an operator ( either +, -, *, or / )
    public static int operator(Node n, int left, int right) {
	if (n.getValue().equals("+")) { return left + right; }
	if (n.getValue().equals("-")) { return left - right; }
	if (n.getValue().equals("*")) { return left * right; }
	if (n.getValue().equals("/")) { return left / right; }
	// If this runs we have a problem
	throw new NumberFormatException();
    }

    // Wrapper to check if root is a number
    public static int solve(Node root) {
	try {
	    return Integer.parseInt(root.getValue());
	} catch (NumberFormatException ex) {
	    return solveHelper(root);
	}
    }
    
    // Assumptions:
    //   Tree is full (every node other than leaves has two children
    public static int solveHelper(Node n) {
        int left = 0;
	int right = 0;

	try {
	    left = Integer.parseInt(n.left.getValue());
	} catch (NumberFormatException ex) {
	    left = solveHelper(n.left);
	}
	
	try {
	    right = Integer.parseInt(n.right.getValue());
	} catch (NumberFormatException ex) {
	    right = solveHelper(n.right);
	}
	
	return operator(n, left, right);	    
    }

    public static void main(String[] args) {
	Node head = new Node("/"); // 9 / 3 = 3
	head.left = new Node("+"); // 7 + 2 = 9
	head.left.left = new Node("-"); // 10 - 3 = 7
	head.left.left.left = new Node("10");
	head.left.left.right = new Node("3");
	head.left.right = new Node("2");
	head.right = new Node("+"); // 1 + 2 = 3
	head.right.left = new Node("1");
	head.right.right = new Node("2");

	System.out.println("solve: " + solve(head));

	Node head2 = new Node("2");
	System.out.println("solve: " + solve(head2));
    }
}
