public class ContiguousSum {

    public static Integer[] sumToK(int[] ary, int K) {
	if (ary.length == 0) {
	    return null;
	}
	if (K == 0) {
	    return new int[0];
	}
	int left = 0;
	int right = 0;
	int sum = ary[0];
	while (left < ary.length) {
	    if (sum == K) {
		return getArray(ary, left, right);
	    }
	    if (sum < K) {
		right += 1;
		if (right < ary.length) {
		    sum += ary[right];
		} else {
		    return null;
		}
	    } else {
		sum -= ary[left];
		left += 1;
		if (left > right) {
		    // check if left equaled right
		    right += 1;
		    if (right < ary.length) {
			sum += ary[right];
		    } else {
			return null;
		    }
		}
	    }
	}
	return null;
    }

    // Returns array between left and right bounds
    public static Integer[] getArray(int[] ary, int left, int right) {
	int[] answer = new int[right - left + 1];
	for (int i = left; i <= right; i++) {
	    answer[i-left] = ary[i];
	}
	return answer;
    }
}
