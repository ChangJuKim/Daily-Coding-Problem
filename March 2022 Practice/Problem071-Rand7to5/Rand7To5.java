/*
Using a function rand7() that returns an integer from 1 to 7 (inclusive) with uniform probability,
implement a function rand5() that returns an integer from 1 to 5 (inclusive).

---------------------------

An easy one for once. If it's 6 or 7 then roll again until you get 1-5.

 */

import java.util.Random;
import java.util.ArrayList;

public class Rand7To5 {
    
    public static int rand7() {
        Random rand = new Random();
        return rand.nextInt(7) + 1;
    }

    public static int rand5() {
        int result = rand7();
        while (result > 5) {
            result = rand7();
        }
        return result;
    }

    public static void main(String[] args) {
        // Initializing test
        ArrayList<Integer> results = new ArrayList(); 
        for (int i = 0; i < 10; i++) {
            results.add(0);
        }

        int num = 0;
        for (int i = 0; i < 10000; i++) {
            num = rand5();
            results.set(num, results.get(num) + 1);
        }
        System.out.println(results);
    }
}
