public class ReverseOrder {

    // Creates new string
    public static String reverseWord(String s) {
	String reversed = "";
	int start = 0;
	int end = 0;
	while (start < s.length()) {
	    while (end < s.length()) {
		if (s.charAt(end) == ' ') break;
		end += 1;
	    }
	    if (start == 0) {
		reversed = s.substring(start, end);
	    } else {
		reversed = s.substring(start, end) + " " + reversed;
	    }
	    start = end+1;
	    end += 1;
	}
	return reversed;
    }

    // Doesn't create new string
    // Doesn't work lol
    // Several off by 1 errors and gotta get the word starting from the back
    public static String reverseWordInPlace(String s) {
	int start = 0;
	int end = 0;
	int sortedStart = 0;
	int sortedEnd = 0;
	while (start < s.length()) {
	    // Find next word
	    while (end < s.length()) {
		if (s.charAt(end) == ' ') break;
		end += 1;
	    }
	    
	    if (end != s.length()) {
		s = s.substring(sortedStart, sortedEnd) + s.substring(start, end) + s.substring(end);
	    } else {
		s = s.substring(sortedStart, sortedEnd) + s.substring(start, end);
	    }
	    // Move all indices by end-start-1
	    int buffer = end-start;
	    sortedEnd += end-start;
	    start = buffer + end + 1;
	    end += buffer + 1;
	}
	return s;
    }

    /*  Testing  */

    public static void test(String s) {
	System.out.println("Word:     " + s);
	System.out.println("Reversed: " + reverseWord(s));
	//System.out.println("In Place: " + reverseWordInPlace(s));
	System.out.println();
    }
    
    public static void main(String[] args) {
	test("hello");
	test("hello world!");
	test("hello world! here!");
	test("hello my name is blah blah ding dong");
    }
}
