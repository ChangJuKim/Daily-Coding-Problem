public class Returning {
    // I actually have no idea what to call this problem

    
    public static int returnXorY(int x, int y, int b) {
	return x*b + y*(1-b);
    }

    /* Testing purposes */
    public static void main(String[] args) {
	System.out.println(returnXorY(10, 100, 1));
	System.out.println(returnXorY(10, 100, 0));
    }
}
