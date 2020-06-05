import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Arrays;

public class IntersectingLinkedLists {

    // First, sum each list.
    // Next have pointers interating through each list
    // As you go through it, remove (or iterate through) the lists based on the following conditions:
    // 1. If the sums are different or the pointers are pointing to different numbers, remove
    //    a. from the list with the higher sum
    //    b. if the sums are the same, the higher number
    // 2. If the sums are the same AND the pointers are pointing to the same numbers,
    //    a. Record the current node as a potential candidate
    //    b. remove from both lists
    //    c. if it is the same number, go to step b
    //    d. if they are different numbers, forget the node and go to step 1

    
    // Returns the sum of the values in the list
    // To account for negative numbers, sums the absolute values
    public static int getSum(LinkedList<Integer> list) {
	ListIterator<Integer> itr = list.listIterator();
	int sum = 0;
	while (itr.hasNext()) {
	    sum += Math.abs(itr.next());
	}
	return sum;
    }

    public static int findIntersection(LinkedList<Integer> A, LinkedList<Integer> B) {
	int sumA = getSum(A);
	int sumB = getSum(B);
	ListIterator<Integer> itrA = A.listIterator();
	ListIterator<Integer> itrB = B.listIterator();
	boolean isSuccess = false;
	
	Integer answer = null;
	
	while(itrA.hasNext() && itrB.hasNext()) {
	    assert sumA > 0;
	    assert sumB > 0;
	    // There is no node that may be the intersection
	    if (sumA > sumB) {
		sumA -= Math.abs(itrA.next());
		isSuccess = false;
	    } else if (sumB > sumA) {
		sumB -= Math.abs(itrB.next());
		isSuccess = false;
	    } else {
		assert sumA == sumB;
		int a_next = itrA.next();
		int b_next = itrB.next();
		if (Math.abs(a_next) != Math.abs(b_next)) {
		    sumA -= Math.abs(a_next);
		    itrB.previous(); // needs to go back one
	        } else {
		    // This node may be the intersection
		    assert sumA == sumB && a_next == b_next;
		    // if this is the first success, record current node and subtract from both
		    if (!isSuccess) {
			answer = a_next;
			isSuccess = true;
		    }
		    sumA -= Math.abs(a_next);
		    sumB -= Math.abs(b_next);
		}
	    }
	}
	// assumes the linked lists are intersecting
	assert isSuccess == true : "Error in intersecting linked lists";
	assert sumA == 0;
	assert sumB == 0;
	return answer;
    }

    public static void testIntersection(LinkedList<Integer> A, LinkedList<Integer> B) {
	System.out.println("testing intersection of: " + A + ", " + B);
	Integer result = findIntersection(A, B);
	if (result == null) {
	    System.out.println("No intersection");
	} else {
	    System.out.println("Result: " + result);
	}
    }

    public static void main(String[] args) {
	LinkedList<Integer> A = new LinkedList<Integer>(Arrays.asList(-999, 10));
	LinkedList<Integer> B = new LinkedList<Integer>(Arrays.asList(99, 1, 8, 10));

	testIntersection(A, B);

	LinkedList<Integer> C = new LinkedList<Integer>(Arrays.asList(-999, 1));
	LinkedList<Integer> D = new LinkedList<Integer>(Arrays.asList(99, 1, 8, 10));
	testIntersection(C, D);


    }
}
