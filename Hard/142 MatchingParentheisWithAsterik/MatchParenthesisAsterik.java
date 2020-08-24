public class MatchParenthesisAsterik {

    // Idea in README
    // Ignores any characters that are not '(', ')', '*'
    public static boolean isBalanced(String s) {
	int leftBound = 0;
	int rightBound = 0;
	for (int i = 0; i < s.length(); i++) {
	    char current = s.charAt(i);
	    if (current == '(') {
		leftBound += 1; rightBound += 1;
	    } else if (current == ')') {
		leftBound -= 1; rightBound -= 1;
	    } else if (current == '*') {
		leftBound -= 1; rightBound += 1;
	    }
	    // Ensure you don't have too many ')'
	    if (rightBound < 0) return false;
	    // Remove cases where too many '*' are ')'
	    if (leftBound < 0) leftBound = 0;
	}
	// Bounds at the end don't contain 0
	if (leftBound > 0 || rightBound < 0) return false;
	return true;
    }

    public static void test(String s) {
	System.out.println(s + " is balanced: " + isBalanced(s));
    }

    public static void main(String[] args) {
	test("(()*");
	test("(*)");
	test(")*(");
	test("");
	test("(");
	test(")");
	test("*");
    }
}
