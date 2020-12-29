public class SortLinkedList {
    

    public static Node sort(Node head) {
	/*
        int length = 0;
	if (head == null) {
	    return head;
	}
	while (head.next != null) {
	    length += 1;
	    head = head.next;
	}
	return sort(head, length); 
	*/
	return sort(head, null);
    }
    
    // Uses two pointers. One advances twice, the other advances once
    public static Node getMiddle(Node head, Node end) {
	if (head == end || head.next == end) {
	    return head;
	}
	Node mid = head;
	head = head.next;
	
	while (head.next != end) {
	    mid = mid.next;
	    head = head.next;
	    if (head.next == end) {
		return mid;
	    } else {
		head = head.next;
	    }
	}
	return mid;
    }

    // assumes head is smaller than mid
    // returns mid.next
    private static Node insert(Node head, Node mid) {
	Node midNext = mid.next;
	mid.next = head.next;
	head.next = mid;
	return midNext;
    }

    public static Node merge(Node head, Node mid, Node end) {
	root = head;
	while (head != end || mid != end) {
	    // There definitely needs to be some kinda null check here but idk where
	    if (head.value < mid.value) {
		mid = insert(head, mid);
	    } else {
		head = insert(mid, head);
	    }
	}
	return root;
    }

    // Merge sort
    public static Node sort(Node head, Node end) {
	if (head == end) {
	    return head;
	}
	
	// Divide into two
	Node mid = findMiddle(head, end);
	sort(head, mid);
	mid = mid.next; // might cause a bug, but i'm 90% sure this is fine based on logic
	sort(mid, end);

	// Combine the two halves
	merge(head, mid, end);
	
	return null;
    }
}
