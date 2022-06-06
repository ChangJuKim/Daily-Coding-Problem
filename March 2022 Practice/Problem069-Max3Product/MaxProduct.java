/*
Given a list of integers, return the largest product that can be made by multiplying any three integers.

For example, if the list is [-10, -10, 5, 2], we should return 500, since that's -10 * -10 * 5.

You can assume the list has at least three integers.

--------------------------------------

This isn't too bad. Solution can only be 3 positive integers multiplied together, or 2 negative and 1 positive.
Thus keep track of the 3 largest positive integers, and the 2 largest (magnitude) negative numbers.
Then see which is bigger -- the 2nd and 3rd positive product or the 1st and 2nd negative product.
return Bigger * 1st largest positive

---------------------------------------

So after coding and testing, I realized that I had a bug with my positives. 
But also I realized you need to keep track of the negatives. If you have all negatives, you must multiply the 3 smallest ones.
... thus... you must keep track of 3 largest positives, 2 largest negatives, and 3 smallest negatives??

I decided instead it would be better for performance to run through the array once and make sure there's at least one positive.
If there is, then we can go with only 5 variables. If there isn't, we can get the smallest (in magnitude) negatives.
 */

public class MaxProduct {

    // Assumes the product is within the bounds of a Java integer. If not, we would have to use BigInteger or something.
    // BigInteger has something like 10^120 digits off the top of my head. I may be completely wrong, but my understanding is that
    //      it uses strings to represent numbers which allows for much bigger (but also potentially slower) calculations
    public static int maxProduct(int[] ary) {
        for (int i = 0; i < ary.length; i++) {
            if (ary[i] > 0) {
                return getLargest(ary);
            }
        }
        // Edge case where we have no positive integers -- must multiply the 3 smallest negatives together. Or zero.
        return getSmallestNegatives(ary);
    }

    public static int getLargest(int[] ary) {
        int largestPositive, secondPositive, thirdPositive;
        int largestNegative, secondNegative;
        largestPositive = secondPositive = thirdPositive = 0;
        largestNegative = secondNegative = 0;

        for (int i = 0; i < ary.length; i++) {
            if (ary[i] < 0) {
                // A top-down approach. Check the largest value first before moving to smaller ones.
                if (ary[i] < largestNegative) {
                    secondNegative = largestNegative;
                    largestNegative = ary[i];
                } else if (ary[i] < secondNegative) {
                    secondNegative = ary[i];
                }
            } else {
                // A bottom-up approach. Check the smallest values first to know when to exit.
                if (ary[i] < thirdPositive) continue;
                thirdPositive = ary[i];
                if (ary[i] < secondPositive) continue;
                thirdPositive = secondPositive;
                secondPositive = ary[i];
                if (ary[i] < largestPositive) continue;
                secondPositive = largestPositive;
                largestPositive = ary[i];
            }
        }
        return largestPositive * Math.max(secondPositive * thirdPositive, largestNegative * secondNegative);
    }

    // Assumes ary is full of negative (or zero) numbers
    public static int getSmallestNegatives(int[] ary) {
        int smallest, second, third;
        // Without using MIN_VALUE, we'd have to either do some funky logic with ary[0, 1, 2] or something
        smallest = second = third = Integer.MIN_VALUE;
        for (int i = 0; i < ary.length; i++) {
            // I think top down approach makes more sense in my head so I went with this
            if (ary[i] > smallest) {
                third = second;
                second = smallest;
                smallest = ary[i];
            } else if (ary[i] > second) {
                third = second;
                second = ary[i];
            } else if (ary[i] > third) {
                third = ary[i];
            }
        }
        return smallest * second * third;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[] {-10, -10, 5, 2})); // Expected 500
        System.out.println(maxProduct(new int[] {-10, 10, 5, 2})); // Expected 100
        System.out.println(maxProduct(new int[] {-2, -2, -5, -10})); // Expected -20
        System.out.println(maxProduct(new int[] {10, 20, 30, 40})); // Expected 24000
        System.out.println(maxProduct(new int[] {0, 10, 20})); // Expected 0
        System.out.println(maxProduct(new int[] {0, 10, 20, -5})); // Expected 0
        System.out.println(maxProduct(new int[] {0, 10, 20, -5, -10})); // Expected 1000
        System.out.println(maxProduct(new int[] {0, -1, -2, -3, -4, -5})); // Expected 0
    }
    
}
