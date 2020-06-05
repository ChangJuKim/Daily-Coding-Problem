import java.util.ArrayList;

// Relies on compareTo to determine max
public class Stack<T extends Comparable<T>> {
    private ArrayList<T> ary;
    T max;

    public Stack() {
	ary = new ArrayList<T>();
	max = null;
    }
    
    public void push(T val) {
	ary.add(val);
	if (max == null || max.compareTo(val) < 0) {
	    max = val;
	}
    }

    public T pop() {
	if (ary.size() == 0) {
	    return null;
	}
	T result = ary.remove(ary.size() - 1);
	
	// Check if we need a new max because it's been popped
	if (result.compareTo(max) == 0) {
	    calculateMax();
	}
	return result;
    }

    public T max() {
	return max;
    }


    private void calculateMax() {
	if (ary.size() == 0) {
	    max = null;
	} else {
	    max = ary.get(0);
	    for (int i = 0; i < ary.size(); i++) {
		if (max.compareTo(ary.get(i)) < 0) {
		    max = ary.get(i);
		}
	    }
	}
    }
    
}
