/*
This problem was asked by Google.

The power set of a set is the set of all its subsets. Write a function that, given a set, generates its power set.

For example, given the set {1, 2, 3}, it should return {{}, {1}, {2}, {3}, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}}.

You may also use a list or array to represent a set.
*/

/*
    Solution:
        1. Get an array of arrays [[]] with an empty array in it
        2. For num in givenSet:
        3.    For ary in the array of arrays:
        4.      Copy ary and in the copy, add num


    x: {{}}
    1: {{}, {1}}
    2: {{}, {1}, {2}, {1, 2}}
    3: {{}, {1}, {2}, {1, 2}, {3}, {1, 3}, {2, 3}, {1, 2, 3}}

    

    Turns out, there's another way -- listed details in powerSet2.
    It should be more efficient since you're not reallocating memory and making the arraylist longer and longer.
    Also no need to clone things -- just pushing values to the right arrays every now and then.
*/

import java.util.ArrayList;

public class powerSet {
    
    public static ArrayList<ArrayList<Integer>> getPowerSet(ArrayList<Integer> set) {
        ArrayList<ArrayList<Integer>> powerSet = new ArrayList<ArrayList<Integer>>();
        powerSet.add(new ArrayList<Integer>());

        for (int setIndex = 0; setIndex < set.size(); setIndex++) {
            int numToAdd = set.get(setIndex);
            // powerSet size changes in the below for loop
            int size = powerSet.size();
            for (int powerSetIndex = 0; powerSetIndex < size; powerSetIndex++) {
                ArrayList<Integer> cloned = (ArrayList)powerSet.get(powerSetIndex).clone();
                cloned.add(numToAdd);
                powerSet.add(cloned);
            }
        }
        return powerSet;
    }

    // Solution #2: Create 2^n empty arrays first
    // Add ith number by skipping 2^i arrays, and placing the number in the next 2^i arrays
    public static ArrayList<ArrayList<Integer>> getPowerSet2(ArrayList<Integer> set) {
        ArrayList<ArrayList<Integer>> powerSet = new ArrayList<ArrayList<Integer>>();
        // Add 2^n arrays
        for (int i = 0; i < Math.pow(2, set.size()); i++) {
            powerSet.add(new ArrayList<Integer>());
        }

        // For ith number, [skip 2^(i-1) times, add number 2^(i-1) times] until you reach end of array
        for (int i = 0; i < set.size(); i++) {
            double blockSize = Math.pow(2, i);
            int j = 0;
            while (j < powerSet.size()) {
                // Skip 2^(i-1) times
                j += blockSize;
                // Add number 2^(i-1) times
                for (int blockIndex = 0; blockIndex < blockSize; blockIndex++) {
                    powerSet.get(j).add(set.get(i));
                    j++;
                }
            }
        }
        return powerSet;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        System.out.println(getPowerSet2(nums));

        nums.add(1);
        System.out.println(getPowerSet2(nums));

        nums.add(2);
        System.out.println(getPowerSet2(nums));
        
        nums.add(3);
        System.out.println(getPowerSet2(nums));
    }
}
