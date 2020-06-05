import java.util.ArrayList;

public class Node<T> {
    private T data;
    private ArrayList<Node<T>> children;
    private Node<T> parent;

    // Constructor
    public Node(T _data) {
	data = _data;
	children = new ArrayList<Node<T>>();
	parent = null;
    }

    // Add and Get functions
    public void add(Node<T> child) {
	children.add(child);
	child.parent = this;
    }

    public T getValue() {
	return data;
    }

    public Node<T> getChild(int i) { return children.get(i); }

    public Node<T> getParent() { return parent; }

    public ArrayList<Node<T>> getChildren() { return children; }

    // may not work if removing children doesn't change arrayList size
    public boolean hasChildren() { return children.size() > 0; }

    public String toString() { return "" + data; }
}
