/*
A number is considered perfect if its digits sum up to exactly 10.

Given a positive integer n, return the n-th perfect number.

For example, given 1, you should return 19. Given 2, you should return 28.

--------------------------------------

First thoughts:
    N can be infinitely large because you can have 19, 190, 1900, 19000, etc.
    If we want to have a very fast computation time, but don't care about the first load time then we can of course go through
every number and save the results in an array or something. Then, finding the nth perfect number is the same as finding the nth
number in the array.
    I don't think there's any mathematical computation to get the nth perfect number.
    Thus the best way is probably some kind of dynamic programming solution.

    If we start with a perfect number, say 19
    We can get other perfect numbers from there.
        1. Subtract 1 from the ones digit, add 1 to the tens digit => 28
            a. If ones digit is 0 or tens digit is 9:
                Add 1 to the next valid digit 
                    Digit is valid if it is not a 9, and if there is a non-zero digit to the right of it.
                    A valid digit can be a new digit 
                Turn everything to the right of that valid digit into a 0.
                Make the 1s digit (10 - sum of all other digits).

    Perfect numbers (to think about edge cases and help come up with above algorithm)
    19
    28
    37
    46
    55
    64
    73
    82
    91
    109
    118
    127
    136
    145
    154
    163
    172
    181
    190
    208
    217
    226
    235
    244
    253
    262
    271
    280
    307
    ...
    901
    910
    1009
    ...
    7001020
    7001101
    7001110
    7001200
    7002001
    ...
    8000002
    8000011
    8000020
    8000101
    8000110
    8000200
    8001001
    ...
    9000001
    9000010
    9000100
    9001000

    --------------------------------------

    Final thoughts
    I had a lot of off-by-1 errors because n starts at 1, and arrays start at 0.
    Also had a few errors in my getValidDigit and getNextNum
    This took me about... an hour 20 minutes to code and test. But I'm glad I got it to work.
    Seems like between 10000 and 50000, my code does much better than the simple one for testing.
    And of course, since it saves in an array it does better on repeated calls.

    My runtime is O(n) and my space complexity is O(n).
    I just realized there's a O(1) time and space algorithm. Turns out there is a mathematical way of getting it.
    And here I was feeling so proud of myself hahah.
 */

import java.util.ArrayList;
import java.util.Arrays;

public class NthPerfectNumber {
    private static ArrayList<Integer> ary = new ArrayList<Integer>(Arrays.asList(19, 28, 37, 46, 55, 64, 73, 82, 91, 109));

    public static int nthPerfect(int n) {
        n = n-1;
        if (ary.size() > n) {
            return ary.get(n);
        }

        int num = 108; // placeholder
        int validDigit = 2; // 0 = ones digit. 1 = tens digit, 2 = hundreds digit... 
        while (ary.size() <= n) {
            num = ary.get(ary.size() - 1);
            if (num % 10 != 0) {
                ary.add(num + 9);
            } else {
                validDigit = getValidDigit(num);
                ary.add(getNextNum(num, validDigit));
            }
        }

        return ary.get(n);
    }

    // Finds the first valid digit you can add 1 to. Can be a new digit
    public static int getValidDigit(int num) {
        int validDigit = 0;
        boolean onlyZeroRight = true;
        while (onlyZeroRight || num % 10 == 9) {
            if (num % 10 != 0) {
                onlyZeroRight = false;
            }
            num = num / 10;
            validDigit += 1;
        }
        return validDigit;
    }

    // Adds 1 to the validDigit's spot, and makes everything to the right 0. Fills ones digit to make sure it still sums to 10.
    private static int getNextNum(int num, int validDigit) {
        int powerTen = (int)Math.pow(10, validDigit);
        num = num + powerTen; // Add 1 to digit
        num = num / powerTen; // Making everything to the right of digit 0
        int countTotal = num;
        int total = 0;
        while (countTotal > 0) {
            total = total + countTotal % 10;
            countTotal = countTotal / 10;
        }
        num = num * powerTen; // Finished making everything to the right of digit 0
        num = num + 10 - total; // Add to ones digit
        return num;
    }

    // NOT MY CODE -- CREDIT TO https://tutorialspoint.dev/algorithm/mathematical-algorithms/n-th-number-whose-sum-of-digits-is-ten
    // COPIED FOR TESTING PURPOSES
    public static int findNth(int n) 
    { 
        int count = 0; 
        for (int curr = 1;; curr++) { 
  
            // Find sum of digits in current no. 
            int sum = 0; 
            for (int x = curr; x > 0; x = x / 10) 
                sum = sum + x % 10; 
  
            // If sum is 10, we increment count 
            if (sum == 10) 
                count++; 
  
            // If count becomes n, we return current 
            // number. 
            if (count == n) 
                return curr; 
        } 
    }

    public static void main(String[] args) {
        int n = 1;
        int result = nthPerfect(n);
        System.out.println("Printing " + n + ": " + result + ". Verifying that ary is saved: " + (ary.get(n-1) == result));
        
        n = 10;
        result = nthPerfect(n);
        System.out.println("Printing " + n + ": " + result + ". Verifying that ary is saved: " + (ary.get(n-1) == result));
        
        n = 25;
        result = nthPerfect(n);
        System.out.println("Printing " + n + ": " + result + ". Verifying that ary is saved: " + (ary.get(n-1) == result));

        n = 30;
        result = nthPerfect(n);
        System.out.println("Printing " + n + ": " + result + ". Verifying that ary is saved: " + (ary.get(n-1) == result));

        System.out.println(ary);

        System.out.println(findNth(1));
        System.out.println(findNth(10));
        System.out.println(findNth(25));
        System.out.println(findNth(30));
    }
}
