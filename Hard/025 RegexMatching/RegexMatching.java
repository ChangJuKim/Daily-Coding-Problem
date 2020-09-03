public class RegexMatching {


    // Regex may contain . If it finds an asterik, returns index of asterik - 1
    // Else returns Integer.Max if true, Integer.Min if false
    public static Integer[] matchesUpToAsterik(String s, String regex, int sIndex, int regexIndex) {
	for (; regexIndex < regex.length() || sIndex < s.length(); regexIndex++) {
	    if (regexIndex+1 < regex.length() && regex.charAt(regexIndex+1) == '*') {
		return new int[] {sIndex, regexIndex};
	    }
	    if (regex.charAt(regexIndex) != '.' && regex.charAt(regexIndex) != s.charAt(sIndex)) {
		return new int[] {Integer.MIN_VALUE, 0};
	    }
	    sIndex++;
	}
	if (sIndex == s.length() && regexIndex == regex.length()) {
	    return new int[] {Integer.MAX_VALUE, 0};
	}
	return new int[] {Integer.MIN_VALUE, 0};
    }

    // Condense consecutive **** to *	
    public static String condenseAsteriks(String regex) {
	String result = "";
	boolean countingAsteriks = false;
	for (int i = 0; i < regex.length(); i++) {
	    if (regex.charAt(result) == '*') {
		if (!countingAsteriks) {
		    result = result + "*";
		    countingAsteriks = true;
		}
	    } else {
		countingAsteriks = false;
	    }
	}
	return result;
    }
    
    public static boolean matchesWithAsterik(String s, String regex) {
	regex = condenseAsteriks(regex);
	int regexIndex = 0;
	int sIndex = 0;
	while (regexIndex < regex.length()) {
	    int regexIndex = matchesUpToAsterik(s, regex, sIndex, regexIndex);
	    if (i == Integer.MAX_VALUE) return false;
	    if (i == Integer.MIN_VALUE) return true;
	    // found an asterik
	    // Do something
	}
    }
}
