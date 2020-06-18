import java.util.Random;

public class UniformProbability {

    
    // Using an int[] to simulate a stream
    public static int uniform(int[] stream) {
	int result = stream[0];
	Random rand = new Random();
	for (int i = 0; i < stream.length; i++) {
	    if (rand.nextInt(i+1) == 0) {
		result = stream[i];
	    }
	}
	return result;
    }

    // Returns [0, 1, 2, ... , size-1]
    public static int[] stream(int size) {
	int[] stream = new int[size];
	for (int i = 0; i < size; i++) {
	    stream[i] = i;
	}
	return stream;
    }

    public static void printArray(int[] ary) {
	String printed = "[";
	for (int i = 0; i < ary.length; i++) {
	    if (i == ary.length-1) {
		printed += ary[i] + "]";
	    } else {
		printed += ary[i] + ", ";
	    }
	}
	System.out.println(printed);
    }

    public static void main(String[] args) {
	int[] stream = stream(10);
	int[] results = new int[10];
	int testCases = 1000000;
	for (int i = 0; i < testCases; i++) {
	    results[uniform(stream)] += 1;
	}
	printArray(results);
    }
}
