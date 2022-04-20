/*
Given a array of numbers representing the stock prices of a company in chronological order, write a function that
calculates the maximum profit you could have made from buying and selling that stock once. You must buy before you can sell it.

For example, given [9, 11, 8, 5, 7, 10], you should return 5, since you could buy the stock at 5 dollars and sell it at 10 dollars.

------------------------------------------------------------

This seems like a dynamic programming problem.
I think the solution is:
    Create an array of size N. ary[i] will hold the best profit if you sell at i
    So given the example, ary = [0, 2, 0, 0, 2, 5]
    
    Fill out the array by:
        if (min > given[i]) {
            min = given[i]
            ary[i] = 0;
        } else {
            ary[i] = given[i] - min
        }

        --------------------------------------------------------

    Post-code thoughts: turns out you didn't need the array. Just hold the current maximum profit in a variable
*/

public class maxProfit {

    public static int getProfit(int[] ary) {
        if (ary.length == 0) {
            return 0;
        }
        // Maximum profit cannot be less than 0 since you can sell and buy the same stock
        int maxProfit = 0;
        int min = ary[0];
        for (int i = 0; i < ary.length; i++) {
            if (ary[i] > min) {
                maxProfit = Math.max(maxProfit, ary[i] - min);
            } else {
                min = ary[i];
            }
        }
        return maxProfit;
    }

    public static void printArray(int[] ary) {
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
        int[] test1 = new int[] {9, 11, 8, 5, 7, 10};
        System.out.println(getProfit(test1)); // returns 5
        
        int[] test2 = new int[] {0, 0, 0};
        System.out.println(getProfit(test2)); // returns 0

        int[] test3 = new int[] {};
        System.out.println(getProfit(test3)); // returns 0

        int[] test4 = new int[] {100};
        System.out.println(getProfit(test4)); // returns 0

        int[] test5 = new int[] {5, 4, 3, 2, 1};
        System.out.println(getProfit(test5)); // returns 0

        int[] test6 = new int[] {1, 2, 3, 4, 5};
        System.out.println(getProfit(test6)); // returns 4
    }
}