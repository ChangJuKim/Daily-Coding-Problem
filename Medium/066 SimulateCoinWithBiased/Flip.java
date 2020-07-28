public class Flip {

    // So I don't get a syntax error
    public static int toss_biased() {
	return 1;
    }

    public static int flip() {
	// First flip
	int first = toss_biased();
	// Second flip
	int second = toss_biased();
	// HH or TT result
	if (first + second != 1) {
	    return flip();
	}
	return first; // Either returns 1 or 0

	/*
	// HT result
	if (first == 1) {
	    return 1;
	}
	// TH result
	return 0;
	*/
    }
}
