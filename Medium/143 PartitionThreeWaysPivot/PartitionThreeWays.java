public static class PartitionThreeWays {


    // partitions by creating a new array.
    // Idea 1 in my README 
    public static int[] partitionWithNewArray(int[] ary, int value) {
	int[] answer = new int[ary.length];
	int left = 0; int right = ary.length-1;
	// Fill in (< value) and (> value). Ignore (= value)
	for (int i = 0; i < ary.length; i++) {
	    if (ary[i] < value) {
		answer[left] = ary[i];
		left += 1;
	    } else if (ary[i] > value) {
		answer[right] = ary[i];
		right -= 1;
	    }
	}
	// Fill in remaining spots with value
	for (; left <= right; left++) {
	    answer[left] = value;
	}
	return answer;
    }

    // You can just insert this code into partitionSameArray if it's not pass by reference
    public static int[] swap(int[] ary, int index1, int index2) {
	int temp = ary[index2];
	ary[index2] = ary[index1];
	ary[index1] = temp;
	return ary;
    }

    // Partitions without creating new array. Modifies old array.
    // Idea 2 in README
    public static int[] partitionSameArray(int[] ary, int value) {
	int left = 0; int right = ary.length-1;
	// Move (< value) to the left first
	while (left <= right) {
	    while (ary[left] >= value) {
		ary = swap(ary, left, right); // If it's pass by reference, ary = is redundant
		right -= 1;
	    }
	    left += 1;
	}
	// Now repeat, but put the equal ones to leftIndex
	right = ary.length-1;
	while (left <= right) {
	    while (ary[left] > value) {
		ary = swap(ary, left, right);
		right -= 1;
	    }
	    left += 1;
	}
	return ary;
    }
}
