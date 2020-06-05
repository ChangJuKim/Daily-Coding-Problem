public class MatchingBrackets {

    private static final String OPEN = "([{";
    private static final String CLOSED = ")]}";

    // Takes in string of size 1 (might change to char)
    // Returns true if it matches a character in OPEN
    // Returns false otherwise (should mean that it is in CLOSED) 
    private static boolean isOpen(String s) {
        assert (s.length() == 1);
	return OPEN.contains(s);
    }

    private static boolean matches(String openChar, String closedChar) {
	return OPEN.indexOf(openChar) == CLOSED.indexOf(closedChar);
    }

    public static boolean matchingBrackets(String s) {
	Stack<String> stack = new Stack<String>();
	for (int i = 0; i < s.length(); i++) {
	    String c = s.substring(i, i+1);
	    if (isOpen(c)) {
		stack.push(c);
	    } else {
		try {
		    String popped = stack.pop();
		    if (!matches(popped, c)) {
			return false;
		    }
		} catch (Exception e) {
		    // empty stack
		    System.out.println("empty stack!");
		    return false;
		}
	    }
	}
	return stack.isEmpty();
    }

    public static void printTest(String s) {
	Stack<String> stack = new Stack<String>();
	System.out.println(s + " is matching: " + matchingBrackets(s));
    }
    
    public static void main(String[] args) {
	printTest("([])[]({})");
	printTest("([)]");
	printTest("((()");
	printTest("()))");
	printTest("");
	
	System.out.println("Matching (, ]: " + matches("(", "]"));
    }
    
}
