import java.util.NoSuchElementException;

public class Iterator<T> {
    /* 
       Note that ary[i][j] will either be the next element to be returned,
       or out of bounds 
    */
    
    private T[][] ary;
    private int i, j;

    public Iterator(T[][] array) {
	ary = array;
	i = 0;
	j = 0;
	// Find first non-empty sub array
	while (i < ary.length && ary[i].length == 0) {
	    i++;
	}
    }

    public T next() throws NoSuchElementException {
	// No more elements
	if (i >= ary.length) {
	    throw new NoSuchElementException();
	}
	T ans = ary[i][j];

	// Advance iterator
	j++;
	while (i < ary.length && j >= ary[i].length) {
	    j = 0;
	    i++;
	}

	return ans;
    }

    public boolean has_next() {
	return i >= ary.length;
    }


    public static void main(String[] args) {
	Integer[] ary1 = new Integer[] {1, 2};
	Integer[] ary2 = new Integer[] {3};
	Integer[] ary3 = new Integer[] {};
	Integer[] ary4 = new Integer[] {4, 5, 6};

	Integer[][] ary = new Integer[][] {ary1, ary2, ary3, ary4};
	Iterator<Integer> itr = new Iterator<Integer>(ary);

	for (int i = 0; i < 7; i++) {
	    System.out.println(itr.next());
	}
    }
}
