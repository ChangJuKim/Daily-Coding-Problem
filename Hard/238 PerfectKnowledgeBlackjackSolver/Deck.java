import java.util.Random;

/* For testing purposes only */
public class Deck {
    // Normally cards will have a suit and number from 1-13
    // For blackjack, I will record only the number and make J, Q, K == 10
    public int[] cards;


    public Deck() {
	this(52);
    }

    public Deck(int size) {
	cards = new int[size];
	int copies = (int)Math.ceil(size / 13.0);
	for (int i = 0; i < cards.length; i++) {
	    cards[i] = i < copies * 10 ? i/copies + 1 : 10;
	}
    	shuffle();
    }

    public void shuffle() {
	Random rand = new Random();
	for (int i = cards.length-1; i >= 0; i--) {
	    int swapIndex = rand.nextInt(i+1);
	    int temp = cards[i];
	    cards[i] = cards[swapIndex];
	    cards[swapIndex] = temp;
	}
    }

    @Override
    public String toString() {
	String s = "[";
	for (int i = 0; i < cards.length; i++) {
	    s += cards[i];
	    if (i != cards.length-1) {
		s += ", ";
	    }
	}
	s += "]";
	return s;
    }
}
