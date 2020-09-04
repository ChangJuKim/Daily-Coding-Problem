public class Prune {

    public static Node prune(Node head) {
	if (head == null || DFS(head)) return null;
	return head;
    }
    
    public static boolean DFS(Node current) {
	// can be 3 lines total which would be cool... but less readable :<
	if (current.left != null) {
	    if (DFS(current.left)) current.left = null;
	}
	if (current.right != null) {
	    if (DFS(current.right)) current.right = null;
	}
	return (current.left == null && current.right == null && current.value == 0);
    }


    public static void main(String[] args) {
	Node head = new Node(0);
	head.left = new Node(1);
	head.right = new Node(0);
	head.right.left = new Node(1);
	head.right.left.left = new Node(0);
	head.right.left.right = new Node(0);
	head.right.right = new Node(0);
	
	head = prune(head); // prune(head): shaving that head bald
	System.out.println(head);
	System.out.println(head.left);
	System.out.println(head.right);
	System.out.println(head.right.left);
    }
}
