public class LargeIntegerStrings {
    // String reprsentation of integers.
    // Supports addition, multiplication, division, subtraction
    
    private String num;
    private boolean isPos;


    public LargeIntegerStrings(String number) {
	num = number;
    }

    public LargeIntegerStrings() {
	num = "";
    }

    public int length() {
	return num.length();
    }

    // Gets the ith last digit
    private int getDigit(int i) {
	return Integer.parseInt(num.substring(length()-i-1, length()-i));
    }

    private int getDigit(String number, int i) {
	return Integer.parseInt(number.substring(number.length()-i-1, number.length()-i));
    }

    private void negate() {
	isPos = !isPos;
    }


    // 1234567
    //     567
    //    

    // CANNOT HANDLE NEGATIVES
    // Returns this + other
    // 123 + 45678 = 45801
    public LargeIntegerStrings add(LargeIntegerStrings other) {
	String result = "";
	int carry = 0;
	for (int i = 0; i < Math.min(length(), other.length()); i++) {
	    // Runs through the numbers backwards (backward logic in getDigit)
	    int digitSum = getDigit(i) + other.getDigit(i) + carry;
	    if (digitSum >= 10) {
		carry = 1;
		digitSum -= 10;
	    } else {
		carry = 0;
	    }
	    result = digitSum + result;
	}
	// Append the remaining digits from the longer integer to the result.
	// Adds the carry if necessary
	int i = Math.max(length(), other.length()) - Math.min(length(), other.length());
	String remaining = length() > other.length() ? num.substring(0, i) : other.num.substring(0, i);
	while (carry == 1) {
	    if (remaining.length() == 0) {
		// If the lengths are the same, just add a 1
		result = "" + carry + result;
		break;
	    } else {
		int digitSum = getDigit(remaining, 0) + carry;
		if (digitSum >= 10) {
		    carry = 1;
		    digitSum -= 10;
		} else {
		    carry = 0;
		}
		result = digitSum + result;
		remaining = remaining.substring(0, remaining.length() - 1);
	    }
	}
	result = remaining + result;
	return new LargeIntegerStrings(result);
    }

    // Returns this - other
    public LargeIntegerStrings subtract(LargeIntegerStrings other) {
	// this might change other.isPos
	other.negate();
	LargeIntegerStrings num = add(other);
	return other;
    }

    private String padZero(String num, int numZeros) {
	for (int i = 0; i < numZeros; i++) {
	    num += "0";
	}
	return num;
    }

    // Returns this * other
    // 1234 * 90 = 111060
    // Can be made much more efficient
    public LargeIntegerStrings multiply(LargeIntegerStrings other) {
	// Lets do this one by one. 4 * 0, 4 * 90, etc
	// 
	LargeIntegerStrings result = new LargeIntegerStrings("0");
	for (int i = 0; i < other.length(); i++) {
	    for (int j = 0; j < length(); j++) {
		int numZeros = i + j; // number of 0's
		String product = "" + (other.getDigit(i) * getDigit(j));
		product = padZero(product, numZeros);
		result = result.add(new LargeIntegerStrings(product));
	    }
	}
	return result;
    }

    public String toString() {
	return num;
    }

    public boolean equals(LargeIntegerStrings other) {
	return num == other.num && isPos == other.isPos;
    }

    public boolean equals(int number) {
	int thisNum = Integer.parseInt(num);
	//if (!isPos) { thisNum *= -1; }
	return thisNum == number;
    }
}
