public class createPalindrome {

    public static String insert(String string, int index, String toBeInserted) {
	return string.substring(0, index) + toBeInserted + string.substring(index);
    }
}
