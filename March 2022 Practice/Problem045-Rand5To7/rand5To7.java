/*
Using a function rand5() that returns an integer from 1 to 5 (inclusive) with uniform probability, 
implement a function rand7() that returns an integer from 1 to 7 (inclusive).


I've done this one before and remember it.
Idea: Get N where N can be one of 25 numbers with uniform probability by calling rand5 twice.
      If N is the last 4 numbers (25 mod 7 === 4), try again.
      Else: return N / 3 (since 25 / 7 === 3).
*/

import java.util.Random;

public class rand5To7 {
    
    // Uses Random.nextInt to return an integer from 1 to 5 with uniform probability
    public static int rand5() {
        Random rand = new Random();
        return rand.nextInt(5) + 1;
    }
    
    // Uses Random.nextInt to return an integer from 1 to N with uniform probability
    public static int randN(int n) {
        Random rand = new Random();
        return rand.nextInt(n) + 1;
    }

    // Uses rand5 to return an integer from 1 to 7 with uniform probability
    public static int rand7() {
        // num = 1 to 25
        int num = (rand5() - 1) * 5 + rand5();
        // num > 21
        while (num > 21) {
            num = (rand5() - 1) * 5 + rand5();
        }
        return num % 7;
    }

    public static void printArray(double[] ary) {
        System.out.print("[");
        for (int i = 0; i < ary.length; i++) {
            if (i == ary.length - 1) {
            System.out.print(ary[i]);
            } else {
            System.out.print("" + ary[i] + ", ");
            }
        }
        System.out.println("]");
        }
    

    public static void main(String[] args) {
        double[] ary = new double[7];
        for (int i = 0; i < 1000000; i++) {
            ary[rand7()] += 1.0;
        }

        double total = 0.0;
        for (int i = 0; i < 7; i++) {
            total += ary[i];
        }
        for (int i = 0; i < 7; i++) {
            ary[i] = ary[i] / total;
        }

        printArray(ary);
    }
}
