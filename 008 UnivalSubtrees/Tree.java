import java.util.ArrayList;

public class Tree<T> {
    private Node<T> root;

    // Constructors
    public Tree(T _data) {
	root = new Node<T>(_data);
    }
    public Tree(Node<T> node) {
	root = node;
    }

    // Get functions
    public Node<T> getRoot() {
	return root;
    }

}
