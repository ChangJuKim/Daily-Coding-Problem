public class Node {
    // Simple linked list interface
    int value;
    Node next;

    public Node(int _value) {
	value = _value;
	next = null;
    }

    public Node(int _value, Node _next) {
	value = _value;
	next = _next;
    }
}
