import java.util.ArrayList;

public class GrayCode {
    // Placing memo table here for convenience.
    // Can probably pass it around as a variable if you don't like globals
    // Representing binary numbers as string. If I was more comfortable, I'd choose
    //   integers and use binary methods
    private static ArrayList<String> memoTable;
    private static int size; // 2^size = memoTable.size()


    public static ArrayList<String> grayCode(int n) {
	if (n == 0) return new ArrayList<String>();
	if (size == 0) memoTable = new ArrayList<String>();
	
	// Gotta update the table
	if (size < n) {
	    fillTable(n);
	}
	// Oh this is broken for when you call
	// grayCode(10)
	// grayCode(5)
	return memoTable;
    }

    // Fills memo table
    public static void fillTable(int n) {
	/* memoTable never filled out */
	if (n == 1 && size == 0) {
	    memoTable.add("0");
	    memoTable.add("1");
	    size += 1;
	    return;
	}
	
	/* Fill in previous values before this one */ 
	if (size < n-1) {
	    fillTable(n-1);
	}

	/* Fill in current value */
	if (size == n-1) {
	    // First copy values but reversed
	    for (int i = memoTable.size()-1; i >= 0; i--) {
		memoTable.add(memoTable.get(i));
	    }
	    // Then place a 0 in front of the first half, a 1 in front of the other half
	    for (int i = 0; i < memoTable.size(); i++) {
		if (i < memoTable.size() / 2) {
		    memoTable.set(i, "0" + memoTable.get(i));
		} else {
		    memoTable.set(i, "1" + memoTable.get(i));
		}
	    }
	    size += 1;
	}
    }


    
    /* Testing */

    public static void confirmGrayCode() {
	if (size == 0) {
	    return;
	}
    }

    public static void main(String[] args) {
	System.out.println(grayCode(5));
	System.out.println(grayCode(3));
    }
}
