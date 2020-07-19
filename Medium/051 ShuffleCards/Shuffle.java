import java.util.Random;

public class Shuffle {

    // Generates a random number between 1 and n inclusive
    public static int randInt(int n) {
	Random rand = new Random();
	int result = rand.nextInt(n);
	return result + 1;
    }
    
    // Assumes deck is length 52.
    // Actually, it doesn't but deck should still be length 52.
    public static int[] shuffle(int[] deck) {
	for (int i = 0; i < deck.length; i++) {
	    int num = randInt(deck.length - i) + i - 1; // value i - 51 inclusive
	    // Swap cards at indices i and num
	    System.out.println("" + i + ": " + num);
	    int temp = deck[i];
	    deck[i] = deck[num];
	    deck[num] = temp;
	    //System.out.println("" + deck[i] + " <=> " + deck[num]);
	}
	return deck;
    }

    public static void print(int[] ary) {
	System.out.print("[");
	for (int i = 0; i < ary.length; i++) {
	    if (i == ary.length - 1) {
		System.out.print(i);
	    } else {
		System.out.print("" + ary[i] + ", ");
	    }
	}
	System.out.println("]");
    }

    public static void main(String[] args) {
	int[] results = new int[10];
	for (int i = 0; i < 50000; i++) {
	    int temp = randInt(10);
	    results[temp-1] += 1;
	}
	print(results);
	
	int[] ary = new int[52];
	for (int i = 0; i < ary.length; i++) {
	    ary[i] = i;
	}
	ary = shuffle(ary);
	print(ary);
    }
}
