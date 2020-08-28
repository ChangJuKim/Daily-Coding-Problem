Good morning! Here's your coding interview problem for today.

This problem was asked by Amazon.

There exists a staircase with N steps, and you can climb up either 1 or 2 steps at a time. Given N, write a function that returns the number of unique ways you can climb the staircase. The order of the steps matters.

For example, if N is 4, then there are 5 unique ways:

1, 1, 1, 1
2, 1, 1
1, 2, 1
1, 1, 2
2, 2

What if, instead of being able to climb 1 or 2 steps at a time, you could climb any number from a set of positive integers X? For example, if X = {1, 3, 5}, you could climb 1, 3, or 5 steps at a time.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

I looked this up before.

Idea: O(n) storage, O(n) runtime
  1. Create array size n+1. Initialize with all 0's. ary[0] = 1
  2. Start at step 0.
  3. ary[step + possibleSteps] += ary[step] (careful not to be out of bounds). Step++
  4. Repeat step 3 till end of array
  5. Return ary[n] or something