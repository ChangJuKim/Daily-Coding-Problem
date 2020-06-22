import java.util.LinkedList;
import java.util.ListIterator;

public class KthLast {

    public static int kthLast(LinkedList<Integer> list, int k) {
	ListIterator<Integer> forward_itr = list.listIterator();
	ListIterator<Integer> behind_itr = list.listIterator();
	int counter = 0;
	while (forward_itr.hasNext() && counter < k) {
	    forward_itr.next();
	    counter += 1;
	}
	if (counter != k || k == 0) {
	    System.out.println("k is not within the size of the list!");
	    return -1;
	}
	while (forward_itr.hasNext()) {
	    forward_itr.next();
	    behind_itr.next();
	}
	return behind_itr.next();
    }
    
    public static void main(String[] args) {
	LinkedList<Integer> list = new LinkedList<Integer>();
	for (int i = 0; i < 15; i++) {
	    list.add(i);
	}
	int k = 2;
	System.out.println("" + k + "th last of " + list + ": " + kthLast(list, k));
    }
}
