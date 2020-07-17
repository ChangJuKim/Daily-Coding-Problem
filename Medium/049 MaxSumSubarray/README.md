Good morning! Here's your coding interview problem for today.

This problem was asked by Amazon.

Given an array of numbers, find the maximum sum of any contiguous subarray of the array.

For example, given the array [34, -50, 42, 14, -5, 86], the maximum sum would be 137, since we would take elements 42, 14, -5, and 86.

Given the array [-5, -1, -8, -9], the maximum sum would be 0, since we would not take any elements.

Do this in O(N) time.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Thoughts/etc
  Pretty simple. Already have a solution in mind. Reading/thinking took 3 min.
  Idea:
    1. Variables index i = 0, currentSum, maximumSum = 0
    2. At index i, check currentSum.
       A. If it's negative, currentSum = 0
       B. If not, leave it alone
    3. Add currentSum to current index. Increment index, compare currentSum to max

    Idea simplified:
      At any point in the array, you can restart at 0 (contiguous subarray starts here)
      or continue with the current sum (continues the current subarray)
      It's better to restart if the sum is < 0. Otherwise, it's better to continue.


  Runtime: O(N)
  Storage: O(1)
    If I had to return the subarray, it would probably be O(N) storage


Time:
  (As stated above) reading/thinking took 3 min
  Coding and running through test cases (in my head) took about 9 min.
  Actual testing took about 3 min. Test cases displayed as shown