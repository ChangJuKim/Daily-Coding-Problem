import java.util.ArrayList;

public class Solver {


    // Deck must be length 52 (at least, greater than 0).
    // Assumes each element is between 1 and 10
    // Also assumes there are 4 of each number {1-9} and 16 of {10}.
    // Uh... I returned the max score but I maybe I want to return the total actions?
    public static int maximizeScore(int[] deck) {
	if (deck.length == 0) {
	    System.out.println("You know... THIS IS AN EMPTY DECK!!");
	    return 0;
	}
	if (deck.length != 52) {
	    System.out.println("You know... this is the wrong number of cards... right?");
	}

	int[] memo = new int[deck.length];

	// Fill in memo table
	for (int i = deck.length - 3; i >= 0; i--) {
	    int maxResult = 0;
	    ArrayList<Integer[]> possibilities = playBlackjack(deck, i);

	    // Check all possibilities and get highest result
	    for (int j = 0; j < possibilities.size(); j++) {
		Integer[] outcome = possibilities.get(j);
		int jResult = outcome[1];
		if (outcome[0] < deck.length) {
		    jResult += memo[outcome[0]];
		}
		maxResult = Math.max(maxResult, jResult);
	    }
	    memo[i] = maxResult;
	}
	return memo[0];
    }


    // Result if player stands
    // Index is top card of deck
    // Returns [index, -1/0/+1]
    public static Integer[] blackjackResult(int[] deck, int playerHand, int dealerHand, int index) {
	if (playerHand > 21) {
	    // Immediate bust
	    return new Integer[] {index, -1};
	}
	while (dealerHand <= 16) {
	    // Wants to hit
	    if (index >= deck.length) {
		return new Integer[] {index, 0}; // no more cards; tie
	    } else {
		dealerHand += deck[index];
		index++;
	    }
	}
	// Done hitting
	if (dealerHand > playerHand) return new Integer[] {index, -1};
	if (dealerHand == playerHand) return new Integer[] {index, 0};
	return new Integer[] {index, 1};
    }


    // Index is the top card of the deck
    public static ArrayList<Integer[]> playBlackjack(int[] deck, int index) {
	ArrayList<Integer[]> possibilities = new ArrayList<Integer[]>();
	
	if (index < 0 || index + 3 >= deck.length) {
	    // Cannot hold an actual game
	    possibilities.add(new Integer[] {deck.length, 0});
	    return possibilities;
	}
	
	// Deal the hands
	int playerHand = deck[index] + deck[index+2];
	int dealerHand = deck[index+1] + deck[index+3];
	index += 4;

	// Try every combination of hits
        possibilities.add(blackjackResult(deck, playerHand, dealerHand, index));
	while (index < deck.length && playerHand <= 21) {
	    playerHand += deck[index];
	    index += 1;
	    possibilities.add(blackjackResult(deck, playerHand, dealerHand, index));
	}
	return possibilities;
    }
}
