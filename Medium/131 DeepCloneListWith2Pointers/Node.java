public class Node {
    /*
      Node class for singly linked list where each node has a 'random' pointer
     */
    public int value;
    public Node next;
    public Node random;
    
    public Node(int value) {
	val = value;
    }

    public Node(int value, Node _next) {
	val = value;
	next = _next;
    }    
}
