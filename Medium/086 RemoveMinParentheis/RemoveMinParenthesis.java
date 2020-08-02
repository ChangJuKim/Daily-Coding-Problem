public class RemoveMinParenthesis {

    // Assumes s only has ")" or "(" characters
    public static int minRemoval(String s) {
	int stack = 0;
	int removals = 0;
	for (int i = 0; i < s.size(); i++) {
	    if (s.charAt(i) == '(') {
		stack += 1;
	    } else {
		if (stack == 0) {
		    removals += 1;
		} else {
		    stack -= 1;
		}
	    }
	}
	return removals + stack;
    }
}
