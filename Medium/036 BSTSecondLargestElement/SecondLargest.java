public class SecondLargest {

    public static Node getLargest(Node head) {
	while (head.right != null) {
	    head = head.right;
	}
	return head;
    }
    
    // Assumes right is greater, left is smaller
    public static int secondLargest(Node root) {
	if (root == null || (root.left == null && root.right == null)) {
	    return -1;
	}
	Node largest = root;
	Node secondLargest = root.left;
	if (root.right != null) {
	    // Look for the largest node
	    while (largest.right != null) {
		secondLargest = largest;
		largest = largest.right;
	    }
	    // If largest.left exists, second is largest of that left.
	    if (largest.left != null) {
		secondLargest = largest.left;
		secondLargest = getLargest(secondLargest);
	    }
	    return secondLargest.val;
	} else {
	    // Largest is root
	    secondLargest = root.left;
	    return getLargest(secondLargest).val;
	}
    }

    /*
    public static void arrayToTree(int[] ary, int index, Node head) {
	head.left = (index*2 + 1 >= ary.length) ? null : new Node(ary[index*2 + 1]);
    	head.right = (index*2 + 2 >= ary.length) ? null : new Node(ary[index*2 + 2]);
	if (head.left != null) { arrayToTree(ary, index*2 + 1, head.left); }
	if (head.right != null) { arrayToTree(ary, index*2 + 2, head.right); }
    }
    */

    public static void main(String[] args) {
	
	Node root = new Node(5);
	root.right = new Node(7);
	//root.right.left = new Node(6);
	//root.left = new Node(3);
	//root.left.right = new Node(4);
	System.out.println("second largest: " + secondLargest(root));
    }
}
