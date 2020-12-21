import java.util.Random; // for testing purposes

public class FindDuplicate {


    
    public static int findDuplicate(int[] ary) {
	int sum = 0;
	int arraySum = ary.length;
	for (int i = 0; i < ary.length; i++) {
	    sum += i + 1;
	    arraySum += ary[i];
	}
	return arraySum - sum;
    }


    public static int[] createArray(int n) {
	int[] ary = new int[n+1];
	Random rand = new Random();
	int denom = 1;
        int current = 1;
	for (int i = 0; i < n+1; i++) {
	    ary[i] = i+1;
	    
	    // Determine which number is duplicate
	    if (i < n) {
		denom = rand.nextInt(i+1);
		if (denom == 0) {
		    current = i + 1;
		}
	    }
	}
	ary[n] = current;

	// Ideally I'd shuffle it here, but my solution doesn't rely on order of elements
	return ary;
    }

    public static void main(String[] args) {
	int n = 10;
	int[] ary = createArray(n);
	System.out.println("The duplicate is: " + findDuplicate(ary));
	System.out.println("Last element: " + ary[n]);

	ary = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 100};
	System.out.println("The duplicate is: " + findDuplicate(ary));
	System.out.println("Last element: " + ary[n]);
    }
}
