import java.util.ArrayList;

public class SmallerElements {

    public static int findPosition(ArrayList<Integer> sortedAry, int element) {
	if (sortedAry.size() == 0) {
	    return 0;
	}

	int left = 0; // Inclusive bound
	int right = sortedAry.size(); // Exclusive bound
	int mid = (left + right) / 2;
	while (mid > left && mid < right) {
	    if (sortedAry.get(mid) < element) {
		left = mid;
	    } else {
		right = mid;
	    }
	    mid = (left + right) / 2;
	    
	}
	return mid + 1;
    }
    

    public static int[] smallerElements(int[] ary) {
	ArrayList<Integer> sortedAry = new ArrayList<Integer>();
	int[] ans = new int[ary.length];

	for (int i = ary.length-1; i >= 0; i--) {
	    int position = findPosition(sortedAry, ary[i]);
	    sortedAry.add(position, ary[i]);
	    ans[i] = position;
	}
	return ans;
    }

    public static void printArray(int[] ary) {
	System.out.print("[");
	for (int i = 0; i < ary.length; i++) {
	    if (i == ary.length-1) {
		System.out.println("" + ary[i] + "]");
	    } else {
		System.out.print("" + ary[i] + ", ");
	    }
	}
    }

    public static void main(String[] args) {
	int[] ary = new int[] {3, 4, 9, 6, 1};

	printArray(smallerElements(ary));
    }
}
