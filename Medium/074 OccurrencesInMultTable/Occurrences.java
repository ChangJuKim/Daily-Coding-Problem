import java.util.ArrayList;
import java.util.HashSet;

public class Occurrences {

    public static ArrayList<Integer> primeFactorization(int num) {
	ArrayList<Integer> ary = new ArrayList<Integer>();
	ary.add(1);
	int factor = 2;
	while (factor <= num) {
	    if (num % factor == 0) {
		ary.add(factor);
		num = num / factor;
	    }
	    factor += 1;
	}
	return ary;
    }

    public static HashSet<Integer> getDivisors(int num) {
	ArrayList<Integer> primeFactors = primeFactorization(num);
	HashSet<Integer> factors = new HashSet<Integer>();
	int current = primeFactors.get(0);

	factors.add(1);
	for (int i = 0; i < primeFactors.size(); i++) {
	    if (current > primeFactors.get(i)) {
		continue;
	    }
	    current = primeFactors.get(i);
	    for (int j = i+1; j < primeFactors.size(); j++) {
		if (current * primeFactors.get(j) <= num) {
		    factors.add(current * primeFactors.get(j));
		}
	    }
	}
	
	return factors;
    }

    public static int findOccurrences(int N, int X) {
	// Gotta sort divisors somehow
	HashSet<Integer> divisors = getDivisors(X);
	int total = 0;
	int i;
	for (i = divisors.length - 1; i >= divisors / 2; i--) {
	    if (divisors[i] < N) {
		total += 2;
	    }
	}
	// Odd number of factors; X is a perfect square; odd # of occurrences
	if (divisors.length % 2 == 1) {
	    if (divisors[i+1] < N) {
		total -= 1;
	    }
	}
	return total;
    }
}
