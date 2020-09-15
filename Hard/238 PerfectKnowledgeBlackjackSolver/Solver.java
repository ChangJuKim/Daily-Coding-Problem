import java.util.ArrayList;
import java.util.LinkedList;

public class Solver {
    // previousIndex records how to get each value of memo
    public static LinkedList<Integer> previousIndex;
    public static int[] memo;
    

    // Deck must be length 52 (at least, greater than 0).
    // Assumes each element is between 1 and 10
    // Also assumes there are 4 of each number {1-9} and 16 of {10}.
    // Uh... I returned the max score but I maybe I want to return the total actions?
    public static int maximizeScore(int[] deck) {
	previousIndex = new LinkedList<Integer>();
	if (deck.length == 0) {
	    System.out.println("You know... THIS IS AN EMPTY DECK!!");
	    return 0;
	}
	if (deck.length != 52) {
	    System.out.println("You know... this is the wrong number of cards... right?");
	}

	memo = new int[deck.length];

	// Fill in memo table
	for (int i = deck.length - 3; i >= 0; i--) {
	    int maxResult = Integer.MIN_VALUE;
	    int prevIndex = -1;
	    ArrayList<Integer[]> possibilities = playBlackjack(deck, i);

	    // Check all possibilities and get highest result
	    /* Note that j = x means hit x times. Possibilities shows the result of that */
	    for (int j = 0; j < possibilities.size(); j++) {
		Integer[] outcome = possibilities.get(j);
		int jResult = outcome[1];
		if (outcome[0] < deck.length) {
		    jResult += memo[outcome[0]];
		}
		if (jResult > maxResult) {
		    maxResult = jResult;
		    prevIndex = outcome[0];
		}
	    }
	    memo[i] = maxResult;
	    previousIndex.addFirst(prevIndex);
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
	if (dealerHand > 21 || dealerHand < playerHand) return new Integer[] {index, 1};
	if (dealerHand == playerHand) return new Integer[] {index, 0};
	return new Integer[] {index, -1};
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

    /* Testing purposes */

    // This will mimic playBlackjack
    public static void replay(int[] deck) {
	System.out.print("Deck: ");
	printArray(deck);
	System.out.print("Memo: ");
	printArray(memo);
	System.out.println("Previous Indices: " + previousIndex);
	System.out.println("Maximum score: " + maximizeScore(deck) + "\n\n");
        
	int index = 0;
	int index_prev = 0;
	int score = 0;
	int round = 1;
	// Start a new hand
	while (index + 3 < deck.length) {
	    System.out.println("Round " + 1 + ":");
	    System.out.println("  Player: " + deck[index] + " + " + deck[index+2] + " = " + (deck[index] + deck[index+2]));
	    System.out.println("  Dealer: " + deck[index+1] + " + " + deck[index+3] + " = " + (deck[index+1] + deck[index+3]) + "\n");
	    int playerHand = deck[index] + deck[index+2];
	    int dealerHand = deck[index+1] + deck[index+3];
	    index += 4;


	    // Player turn
	    previousIndex.set(index_prev, previousIndex.get(index_prev) - 4);
	    System.out.println("  Player hits " + previousIndex.get(index_prev) + " times.");
	    // hit "previousIndex" number of times
	    /* I realize I should've put previousIndex in array instead of linked list*/
	    for (int i = 0; i < previousIndex.get(index_prev); i++) {
		if (index == deck.length) {
		    System.out.println("ERROR: NOT ENOUGH CARDS");
		    return;
		}
		System.out.print("  Player gets a " + deck[index]);
		playerHand += deck[index];
		System.out.println(". New total: " + playerHand);
		index++;
	    }

	    System.out.println();
	    // Dealer actions
	    if (playerHand > 21) {
		System.out.println("  Player bust!");
	    } else {
		while (dealerHand <= 16) {
		    if (index == deck.length) {
			System.out.println("No more cards: Tie!");
			break;
		    } else {
			System.out.print("  Dealer gets a " + deck[index]);
			dealerHand += deck[index];
			System.out.println(". New total: " + dealerHand);
			index++;
		    }
		}
	    }

	    // Judging phase
	    if (index != deck.length) {
		System.out.println("  Player: " + playerHand);
		System.out.println("  Dealer: " + dealerHand);
		if (dealerHand > 21 || dealerHand < playerHand) {
		    System.out.print("  Player wins. ");
		    score += 1;
		} else if (dealerHand == playerHand) {
		    System.out.print("  Tie. ");
		} else {
		    System.out.print("  Player loses. ");
		    score -= 1;
		}
	    }

	    // Setup for next round
	    index_prev = previousIndex.get(index_prev);
	    round++;
	    System.out.println("Score: " + score);
	    System.out.println("~~~~~~~~~~~~~~~~~~~~~");

	}
	System.out.println("No more cards. Player score: " + score);

    }

    public static void printArray(int[] ary) {
	String s = "[";
	for (int i = 0; i < ary.length; i++) {
	    s += ary[i];
	    if (i != ary.length-1) {
		s += ", ";
	    }
	}
	s += "]";
	System.out.println(s);
    }
    
    public static void main(String[] args) {
	Deck deck = new Deck(26);
	System.out.println(deck);
	System.out.println(maximizeScore(deck.cards));

	System.out.println("~~~~~~~~~~~~~~~~~~~~");
	replay(deck.cards);
    }
}
