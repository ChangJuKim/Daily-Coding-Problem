package common;

public class PrintArray {
    public static void printArray(int[] ary) {
	System.out.print("[");
	for (int i = 0; i < ary.length; i++) {
	    if (i == ary.length - 1) {
		System.out.println("" + ary[i] + "]");
	    } else {
		System.out.print("" + ary[i] + ", ");
	    }
	}
    }

    public static void printArray(String[] ary) {
	System.out.print("[");
	for (int i = 0; i < ary.length; i++) {
	    if (i == ary.length - 1) {
		System.out.println(ary[i] + "]");
	    } else {
		System.out.print(ary[i] + ", ");
	    }
	}
    }

    public static void printArray(int[][] ary) {
	System.out.println("[");
	for (int i = 0; i < ary.length; i++) {
	    printArray(ary[i]);
	}
	System.out.println("]");
    }

}
