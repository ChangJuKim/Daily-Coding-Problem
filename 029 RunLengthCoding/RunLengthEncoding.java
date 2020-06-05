public class RunLengthEncoding {


    /* // ONLY WORKS FOR 1 DIGIT NUMBERS
    // Simply checks that each even character is a number, and each odd is a letter
    public static boolean isCode(String code) {
	if (code.length() % 2 != 0) {
	    return false;
	}
	for (int i = 0; i < code.length(); i++) {
	    if (i % 2 == 0 && !Character.isDigit(code.charAt(i))) {
		return false;
	    }
	    if (i % 2 == 1 && !Character.isLetter(code.charAt(i))) {
		return false;
	    }
	}
	return true;
    }
    */


    // Returns the a 2 int array: the number in the code, and the new index
    // Accounts for multi-digit numbers
    public static int[] getInteger(String code, int i) {
	String integer = "";
	for (; i < code.length(); i++) {
	    if (Character.isDigit(code.charAt(i))) {
		    integer += code.charAt(i);
	    }
	    if (!Character.isDigit(code.charAt(i)) && integer.length() > 0) {
		break;
	    }
	}
	// there are no more integers
	if (integer.length() == 0) {
	    return new int[] {-1, i};
	}
	return new int[] {Integer.parseInt(integer), i};
    }


    // Takes in a string of alphabetic characters
    // Returns the run length encoding
    public static String encode(String text) {
	String code = "";
	int counter = 0;
	char character = '\0';
	for (int i = 0; i < text.length(); i++) {
	    System.out.println(text.charAt(i));
	    // we're counting how many of a character there are
	    if (counter > 0) {
		if (text.charAt(i) == character) {
		    counter += 1;
		}
	    }
	    // we're finding a new character to count
	    else {
		character = text.charAt(i);
		counter += 1;
	    }
	    // appends code
	    if (i == text.length() - 1 || text.charAt(i+1) != character) {
		code += counter + "" + character;
		counter = 0;
	    }
	}
	return code;
    }

    // Takes in a Run Length Encoding code
    // returns the plaintext of that code
    public static String decode(String code) {
	String text = "";
	boolean hasInteger = false;
	int num = 0;
	// gets the number for the code
	for (int i = 0; i < code.length(); i++) {
	    if (!hasInteger) {
		int[] result = getInteger(code, i);
		num = result[0];
		i = result[1] - 1;
		// note that i should now point to a letter
		hasInteger = true;
	    } else if (num < 0) {
		// no more integers to get
		break;
	    } else {
		for (int j = 0; j < num; j++) {
		    text += code.charAt(i);
		}
		hasInteger = false;
	    }
	}
	return text;
    }


    public static void encodePrint(String text) {
	System.out.println("Encoding of " + text + " = " + encode(text));
    }

    public static void decodePrint(String code) {
	System.out.println("Decoding of " + code + " = " + decode(code));
    }

    public static void main(String[] args) {
	String text1 = "AAAAAAAABBBCCDAA";
	String code1 = "4A3B2C1D2A";
	encodePrint(text1);
	decodePrint(code1);
	assert encode(decode(code1)).equals(code1);
	assert decode(encode(text1)).equals(text1);
	System.out.println(encode(decode(code1)) + "~");
	System.out.println(decode(encode(text1)) + "~");
	
	System.out.println("~");
    }
}
