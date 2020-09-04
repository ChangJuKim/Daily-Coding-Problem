Good morning! Here's your coding interview problem for today.

This problem was asked by Google.

Given an array of numbers and an index i, return the index of the nearest larger number of the number at index i, where distance is measured in array indices.

For example, given [4, 1, 3, 5, 6] and index 0, you should return 3.

If two distances to larger numbers are the equal, then return any one of them. If the array at i doesn't have a nearest larger integer, then return null.

Follow-up: If you can preprocess the array, can you do this in constant time?

~~~~~~~~~~~~~~~~~~~~~~~~

Basically you want to do two pointers, one forward and one backward.
For each pointer, if current is greater then return number of steps
else keep moving along
If you reach the end, return null
Get results of both pointers and return the min.
O(n) runtime.
O(1) storage

If you preprocess it...

I mean you can run the above idea for each element and store the result in an array.
Then when someoene gives you an index you have a O(1) time to return the answer
O(n^2) runtime. Worst case is actually an array of all equal values.

I've had some other ideas... but they all become O(n^2) anyways...

If there are no duplicates, I can reach something like a O(n) runtime or O(nlogn) runtime
Otherwise, I run into a O(n^2) runtime (usually for this case: [6, 6, 6, 6, 6... 6, 7])

I'll code the above...

~~~~~~~~~~~~~~~~~~~~~~~~~~~

Actual solution (O(n) time):
  1. (going to the right): have a new array size n, have a stack. 
  2. Loop through array.
      A. If stack is empty, put current into stack
      B. Otherwise, while current > stack.peek:
           result[stack.pop] = current
      C. Once you're done push current into stack
  3. At end of array, all other values are null

  You'll end up with an array in which each index is the next biggest value to the right
  (I didn't mention but you want index of next biggest element in the array)
  E.g. [2, 1, 10, 1, 3, 4] => [2, 2, NULL, 4, 5, NULL]

  Now do the same with the left
  E.g. [2, 1, 10, 1, 3, 4] => [NULL, 0, NULL, 2, 2, 2]

  And now given an index (e.g. 4), return the closest one (5)

  O(n) solution (preprocessed)