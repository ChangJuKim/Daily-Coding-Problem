import java.util.HashSet;
import java.util.Random;

public class RandomInt {

    /* 
       Idea 1: Go through 0-n and pick a random number not in l 
       Runtime: O(n). Preprocessing step is O(l)
    */
    // Assumes l is in a hashset.
    public static Integer streamPicking(int n, HashSet<Integer> l) {
	Random rand = new Random();
        if (n <= 0) {
	    return null;
	}
	int current = -1;
	int probability = 1;
	
	for (int i = 0; i < n; i++) {
	    if (!l.contains(i)) {
		if (rand.nextInt(probability) == 0) { // 1/probability to replace current
		    current = i;
		    probability += 1;
		}
	    }
	}
	// All values in [0, n) are in l
	if (current == -1) {
	    return null;
	}
	return current;
    }


    /*
       Idea 2: Repick from 0-n until you find something not in l
       Runtime: If k = (# elements in [0,n) not in l) / n
                O(1/k). Preprocessing step is O(l)

       I implemented a stopping limit of n^2 so that it doesn't run forever.
       As a result, there is a error probability of (1/k)^(n^2)
         In which you say there is no solution, when there is
     */
    // Assumes l is in a hashset
    public static Integer repicking(int n, HashSet<Integer> l) {
	Random rand = new Random();
	int current = rand.nextInt(n);
	int x = n * n;   // Stopping value
	while(x != 0 && l.contains(current)) {
	    current = rand.nextInt(n);
	    x -= 1;
	}
	return current;
    }
}
