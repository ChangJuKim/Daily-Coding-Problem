public class XORLinkedList {
    private XORNode head;

    // Walk to the end and add it
    public void add(int element) {
	XORNode current = head;
	XORNode previous = null;
	while (current != null) {
	    XORNode next = current ^ previous;
	    previous = current;
	    current = next;
	    current_index += 1;
	}
	// previous = end
	XORNode last = new XORNode(element);
	previous.prevNext = (previous.prevNext ^ null) ^ last; // (previous.previous) ^ last
	last.prevNext = previous ^ null;
    }

    public XORNode get(int index) {
	if (index < 0) {
	    return null;
	}
	XORNode current = head;
	XORNode previous = null;
	int current_index = 0;
	while (current_index < index && current != null) {
	    XORNode next = current ^ previous;
	    previous = current;
	    current = next;
	    current_index += 1;
	}
	return current; // returns null if index > LinkedList.length
    }
}
