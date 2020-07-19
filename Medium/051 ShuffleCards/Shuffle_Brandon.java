import java.util.Random;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;
import java.util.Iterator;
import java.util.Map;

public class Shuffle_Brandon {

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
	/*
	// Part of original code
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
	*/

	// Not part of original code
	int n = 4;
	HashMap<String, Integer> results = createHashMap(n);

	results = getOutcomes(n, results, 0);
    }


    //~~~~~~~~~~~~~~~~~~~~~~~ NOT PART OF ORIGINAL CODE ~~~~~~~~~~~~~~~~~~~

    public static void printHashMap(HashMap<String, Integer> map) {
	Set set = map.entrySet();
	Iterator itr = set.iterator();
	while (itr.hasNext()) {
	    Map.Entry mentry = (Map.Entry)itr.next();
	    System.out.println("(" + mentry.getKey() + ", " + mentry.getValue() + ")");
	}
    }
    
    // Given an array of size n, simulates brandon's approach of
    // swapping each index with any other.
    // Calculates all possibilities and returns it
    // Where abc...n is the int representation of the array (by appending numbers)
    // and # is the number of results that happened that way

    // Creates hashmap of <all possibilities, #results>
    // Please don't make n >= 10.
    public static HashMap<String, Integer> createHashMap(int n) {
	HashMap<String, Integer> results = new HashMap<String, Integer>();
	ArrayList<String> temp_result = new ArrayList<String>();
	temp_result.add("1");
	// Initializes hashmap... by setting up temp_results
	/*
	  Algorithm:
	    1. Loop through n:
	       A. Start with 1.
	       B. Add 2 to 1_, _1
	       C. Loop through each element:
  	          a. For each element (12, 21) add 3 to each part
		     So loop through n again:
	               i. (12_, 1_2, _12) (21_, 2_1, _21)
	*/
	// Digit to add
	for (int digit = 2; digit <= n; digit++) {
	    // Inefficient space and time wise but this is for my sanity
	    ArrayList<String> temp_temp_result = new ArrayList<String>();

	    // Number being updated
	    for (int num = 0; num < temp_result.size(); num++) {
		String number = temp_result.get(num);
		
		// Position
		for (int pos = digit-1; pos >= 0; pos--) {
		    String temp_string = number.substring(0, pos) + digit;
		    if (pos != digit - 1) {
			temp_string = temp_string + number.substring(pos);
		    }
		    temp_temp_result.add(temp_string);
		}
	    }
	    temp_result = temp_temp_result;
	}

	// Actually initializes hashmap
	for (int i = 0; i < temp_result.size(); i++) {
	    results.put(temp_result.get(i), 0);
	}

	// Want 123..n to be 1
	// Generate 123..n
	String s = "" + n;
	for (int i = n-1; i > 0; i--) {
	    s = "" + i + s;
	}
	results.put(s, 1);
	return results;
    }

    // For each string:
    //   Make a swap (with index "swap" and other index), and add to hashmap
    public static HashMap<String, Integer> getOutcomes(int n, HashMap<String, Integer> results, int swap) {
	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	if (swap == n) {
	    return results;
	}
	// Initialize new_results values with 0
	HashMap<String, Integer> new_results = (HashMap<String, Integer>)results.clone();
	Set new_set = new_results.entrySet();
	Iterator new_itr = new_set.iterator();
	while (new_itr.hasNext()) {
	    Map.Entry new_mentry = (Map.Entry)new_itr.next();
	    new_results.put((String)new_mentry.getKey(), 0);
	}

	
	Set set = results.entrySet();
	Iterator itr = set.iterator();
	while (itr.hasNext()) {
	    Map.Entry mentry = (Map.Entry)itr.next();
	    if ((Integer)mentry.getValue() == 0) {
		continue;
	    }
	    String s = (String)mentry.getKey();

	    for (int swap2 = 0; swap2 < n; swap2++) {
		String temp = s;
		System.out.print("(temp, swap1, swap2): (" + temp + ", " + swap + ", " + swap2 + ")");
		// Swap "swap" and "swap2"
		if (swap < swap2) {
		    temp = s.substring(0, swap) + s.charAt(swap2) + s.substring(swap+1, swap2) + s.charAt(swap);
		    //if (swap2 != n-1) {
		    temp = temp + s.substring(swap2 + 1);
		    //}
		}
		// same thing but reversed
		if (swap2 < swap) {
		    temp = s.substring(0, swap2) + s.charAt(swap) + s.substring(swap2+1, swap) + s.charAt(swap2);
		    //if (swap != n-1) {
		    temp = temp + s.substring(swap + 1);
		    //}
		}
		System.out.println(" => " + temp);
		
		// Increase hashmap.get(temp) by 1
		System.out.println(results.get(temp));
		new_results.put(temp, new_results.get(temp) + 1);
	    }
	}
	printHashMap(new_results);
	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	return getOutcomes(n, new_results, swap+1);
    }
}
