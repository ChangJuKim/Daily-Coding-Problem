import java.util.HashMap;

public class TimeMap<T> {
    class TimeLinkedList<U> {
	/*
	  Linked list with time variable.
	  Ensures that root node has the shortest time and every node afterwards
	    has a later time
	*/

	public class TimeNode<V> {
	    public TimeNode<V> next;
	    public V value;
	    public int time;
	
	    public TimeNode(int _time, V _value) {
		next = null;
		time = _time;
		value = _value;
	    }
	}

	public TimeNode<U> root;

	public TimeLinkedList(TimeNode<U> _root) {
	    root = _root;
	}

	// Overwrites node's next. Should only be used on a new node
	public void add(int time, U value) {
	    TimeNode<U> node = new TimeNode<U>(time, value);
	    if (root == null) {
		root = node;
	    }
	    TimeNode<U> head = root;
	    while (head.next != null && head.next.time < node.time) {
		head = head.next;
	    }
	    if (head.next == null) {
		head.next = node;
	    } else if (head.next.time == node.time) {
		// Completely replace head.next
		node.next = head.next.next;
		head.next = node.next;
	    } else {
		// Squeeze node between head and head.next
		node.next = head.next;
		head.next = node;
	    }
	}

	public U get(int time) {
	    if (root == null) {
		return null;
	    }
	    TimeNode<U> head = root;
	    while (head.next != null && head.next.time < time) {
		head = head.next;
	    }
	    return head.value;
	}
    }

    private HashMap<Integer, TimeLinkedList<T>> map;

    public TimeMap() {
	map = new HashMap<Integer, TimeLinkedList<T>>();
    }
    
    public void set(int key, T value, int time) {
	TimeLinkedList<T> list = map.get(key);
	if (list == null) {
	    map.put(key, new TimeLinkedList<T>(null));
	    list = map.get(key); // poor code but i'm out of time
	}
	list.add(time, value);
    }

    public T get(int key, int time) {
	TimeLinkedList<T> list = map.get(key);
	if (list == null) {
	    return null;
	}
	return list.get(time);
    }
}
