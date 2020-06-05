import java.util.ArrayList;

public class UnivalSubtree {
    public static void main(String[] args) {

	// Creates the example test case
	Tree<Integer> t = new Tree<Integer>(0);
	Node<Integer> head = t.getRoot();
	head.add(new Node<Integer>(1));
	head.add(new Node<Integer>(1));
	head = head.getChild(0);
	head.add(new Node<Integer>(1));
	head.add(new Node<Integer>(1));
	head = head.getParent().getChild(1);
	head.add(new Node<Integer>(1));
	head.add(new Node<Integer>(1));
	head = head.getChild(1);
	head.add(new Node<Integer>(2));

	System.out.println(countUnivals(t));


	
	
    }

    // Wrapper for countUnivals(Node)
    public static int countUnivals(Tree<Integer> t) {
	return countUnivals(t.getRoot());
    }

    public static boolean isUnival(Node<Integer> head) {
	if (!head.hasChildren()) {
	    return true;
	}
	ArrayList<Node<Integer>> children = head.getChildren();
	for (int i = 0; i < children.size(); i++) {
	    if (children.get(i).getValue() != head.getValue()) { return false; }
	    if (!isUnival(children.get(i))) { return false; }
	}
	return true;
    }

    
    // Takes in a node of integers and counts how many unival subtrees there are
    public static int countUnivals(Node<Integer> head) {
	// If this node is a leaf, it is unival
	if (!head.hasChildren()) {
	    return 1;
	}
	ArrayList<Node<Integer>> children = head.getChildren();
	int totalUnivals = 0;
	
	for (int i = 0; i < children.size(); i++) {
	    totalUnivals += countUnivals(children.get(i));
	}

	if (isUnival(head)) { totalUnivals += 1; }

	return totalUnivals;
    }
}
