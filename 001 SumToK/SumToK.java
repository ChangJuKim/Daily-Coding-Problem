import java.util.ArrayList;
import java.util.HashSet;

public class SumToK {

    public static void main(String[] args) {
	System.out.println("Hello world!");
	int K = 5;
	ArrayList<Integer> test = new ArrayList<Integer>();
	test.add(1);
	test.add(2);
	test.add(3);
	System.out.println("" + test + " sums to " + K + ": " + sumsOnePass(test, K));
	System.out.println("" + test + " sums to " + 6 + ": " + sumsOnePass(test, 6));
	
    }

    // Goes through the list twice
    public static boolean sumsToK(ArrayList<Integer> list, int K) {
	for (int i = 0; i < list.size(); i++) {
	    for (int j = i+1; j < list.size(); j++) {
		if (list.get(i) + list.get(j) == K) {
		    return true;
		}
	    }
	}
	return false;
    }

    // Uses set to make one pass through the list
    public static boolean sumsOnePass(ArrayList<Integer> list, int K) {
	HashSet<Integer> set = new HashSet<Integer>();
	for (int i = 0; i < list.size(); i++) {
	    if (set.contains(list.get(i))) {
		return true;
	    }
	    int result = K - list.get(i);
	    set.add(result);	    
	}
	return false;
    }
}
