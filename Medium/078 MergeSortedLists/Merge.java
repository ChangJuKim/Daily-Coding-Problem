import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class Merge {

    // Assumes int LinkedList
    public static LinkedList<Integer> merge(ArrayList<LinkedList<Integer>> lists) {
	// Initialize
	LinkedList<Integer> merged = new LinkedList<Integer>();
	ArrayList<ListIterator<Integer>> pointers = new ArrayList<ListIterator<Integer>>();
        for (int i = 0; i < lists.size(); i++) {
	    if (lists.get(i).size() != 0) {
		pointers.add(lists.get(i).listIterator(0));
	    }
	}

	// Loop until no elements left
	while(pointers.size() > 0) {
	    // Find next value to add
	    Integer min = Integer.MAX_VALUE;
	    int minIndex = -1;
	    for (int i = 0; i < pointers.size(); i++) {
		ListIterator<Integer> itr = pointers.get(i);
		if (itr.hasNext()) {
		    int temp = itr.next();
		    if (temp < min) {
			min = temp;
			minIndex = i;
		    }
		    itr.previous(); // Only advance pointer if it's the min value
		    // Uh.. forgot it's singly linked lol
		    // If I create my own linked list, I can peek() to find next value
		    // Otherwise I can just have 2 pointers lol
		} else {
		    pointers.remove(i); // If fully traversed, remove
		    i--;
		}
	    }
	    if (minIndex != -1) {
		merged.add(min);
		pointers.get(minIndex).next(); // Advance pointer with smallest value
	    }
	}
	return merged;
    }

    /* Testing purposes */

    public static LinkedList<Integer> makeList(int[] ary) {
	LinkedList<Integer> list = new LinkedList<Integer>();
	for (int i = 0; i < ary.length; i++) {
	    list.add(ary[i]);
	}
	return list;
    }
    
    public static void main(String[] args) {
	ArrayList<LinkedList<Integer>> ary = new ArrayList<LinkedList<Integer>>();
	ary.add(makeList(new int[] {1, 4, 7, 10}));
	ary.add(makeList(new int[] {2, 3, 6, 9}));
	ary.add(makeList(new int[] {5, 8, 11, 12}));
	ary.add(makeList(new int[] {1, 1, 1, 2}));
	System.out.println("Merged: " + merge(ary));
    }
}
