Good morning! Here's your coding interview problem for today.

This problem was asked by Stripe.

Given an array of integers, find the first missing positive integer in linear time and constant space. In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.

For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.

You can modify the input array in-place.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Idea:
Basically you want to take each number and swap it with its correct spot on the array.
  1. If it's the number you want (e.g. you find a 1 in the 0th index), move to next index
     (1st index)
  2. If it's a number within this index and EndOfArray, put it in the correct spot
     (e.g. you find a 3, your current spot is 1, end of array is 10. Swap the 3 with
     element in array[2])
       A. If it's a duplicate (e.g. 3 is already in array[2]), then toss the duplicate
          (as described below)
  3. If the number is 0, negative, less than the index, or greater than EndOfArray, toss it

  TOSSING:
    Swap current number with number at EndOfArray
    EndOfArray -= 1

  4. If EndOfArray = current index
       If current index is the number you want (e.g. value 10 in 9th index), increment
         currentIndex
       Else: return the number (e.g. return 5 if you're at 4th index)


Runtime: O(n). I don't exactly know why but logic/intuition says that it's O(n)
  Fine I'll do the math. Swapping is O(1)
  Each iteration of the loop, you either move an index (O(1)) or swap.
    When you swap, you place a number in the correct spot so later on that number is
    skipped (cause it's correct) or shoved to the end and never seen again.
  Which each number is essentially seen once.

Storage: O(1).


Also I didn't code it cause today we're just talking about it
Well I had extra time so I coded it