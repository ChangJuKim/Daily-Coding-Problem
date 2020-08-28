public class LongestSubstring {


    // Error: end stops right when you get k distinct characters
    // which means this bug will break: "abbbbb", k=3.
    public static Integer longestSubstring(String s, int k) {
	HashMap<Character, Integer> map = new HashMap<>();
	int distinctChars = 0;
	int maxLength = 0;
	int start = 0;
	int end = -1; // lets end start at 0
	while (end < s.size()) {
	    // Increment end to find a substring 
	    while (distinctChars <= k) {
		end++;
		if (end >= s.size()) {
		    break;
		}
		char endLetter = map.charAt(end);
		if (map.containsKey(endLetter)) {
		    map.put(endLetter, map.get(endLetter) + 1);
		} else {
		    map.put(endLetter, 1);
		    distinctChars += 1;
		}
	    }
	    distinctChars -= 1;
	    end -= 1;
	    
	    // Increment start to find next substring
	    if (distinctChars == k) {
		if (end-start+1 > maxLength) {
		    maxLength = end-start+1;
		}
		while (distinctChars == k) {
		    char startLetter = map.charAt(start);
		    map.put(startLetter, map.get(startLetter) - 1);
		    if (map.get(startLetter) == 0) {
			map.remove(startLetter);
			distinctChars -= 1;
		    }
		    start++;
		}
	    }
	}
	if (end-start > maxLength) return end-start; // end == s.size()
	return maxLength;
    }
}
