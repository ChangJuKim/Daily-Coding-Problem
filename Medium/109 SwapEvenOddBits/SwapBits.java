public class SwapBits {


    // Swaps even and odd bits
    // Note that I'm using int because byte primitive is signed
    // To extend to ints and stuff, gotta create a function to generate
    // 170 and 85's equivalent with longer bits
    public static int swap(int num) {
	// 170 = 10101010, 85 = 01010101
	return ((num & 170) >> 1) | ((num & 85) << 1);
    }

    public static void main(String[] args) {
	int num = 153;
	System.out.println(swap(num));
    }
}
