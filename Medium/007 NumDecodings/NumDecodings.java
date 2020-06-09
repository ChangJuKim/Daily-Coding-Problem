import java.util.Arrays;

public class NumDecodings {

    // Text must be length two
    // Returns true if text is 10-26. False otherwise
    public static boolean twoDigit(String text) {
	if (text.length() != 2) {
	    System.out.println("Fatal error in twoDigit");
	    return false;
	}
	int number = Integer.parseInt(text);
	return number >= 10 && number <= 26;
    }

    // Text must be length one
    // Returns true if text is 1-9. False otherwise
    public static boolean oneDigit(String text) {
	if (text.length() != 1) {
	    System.out.println("Fatal error in oneDigit");
	    return false;
	}
	int number = Integer.parseInt(text);
	System.out.println("number: " + number);
	return number > 0 && number <= 9;
    }

    public static int decode(String text) {
	int[] ary = new int[text.length()];
	return decode(text, ary, 0);
    }

    // Notes: can change ary to just holding the last two values

    // Fills in ary[index] based on the following
    // ary[index] += ary[index - 2] if twoDigit()
    // ary[index] += ary[index - 1] if oneDigit()
    // decode is just a glorified for loop
    public static int decode(String text, int[] ary, int index) {
	int total = 0;
	if (index == 0) {
	    // Sets up ary[0]
	    if (oneDigit(text.substring(0, 1))) {
		total += 1;
	    }
	} else if (index == 1) {
	    // Sets up ary[1]
	    total += twoDigit(text.substring(0, 2)) ? 1 : 0;
	    if (oneDigit(text.substring(1, 2))) {
		total += ary[0];
	    }
	} else {
	    // ary[2 - end]
	    if (oneDigit(text.substring(index, index+1))) {
		total += ary[index - 1];
	    }
	    if (twoDigit(text.substring(index - 1, index + 1))) {
		total += ary[index - 2];	
	    }
	}
	ary[index] = total;
	// Base case for decode function
	if (index >= ary.length-1) {
	    return total;
	} else {
	    return decode(text, ary, index + 1);
	}
    }


    public static void main(String[] args) {
	String text = "1111";
	System.out.println("decode of " + text + ": " + decode(text));
    }
}
