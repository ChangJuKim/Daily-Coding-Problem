Good morning! Here's your coding interview problem for today.

This problem was asked by Google.

Given an array of integers, return a new array where each element in the new array is the number of smaller elements to the right of that element in the original input array.

For example, given the array [3, 4, 9, 6, 1], return [1, 1, 2, 1, 0], since:

There is 1 smaller element to the right of 3
There is 1 smaller element to the right of 4
There are 2 smaller elements to the right of 9
There is 1 smaller element to the right of 6
There are no smaller elements to the right of 1

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

I mean, one option is this:

Idea 1:
  for (i = array.length-1; i > 0; i--) {
    for (j = i-1; j >= 0; j--) {
      if array[i] < array[j], increment newArray[j];
    }
  }

Basically, for each element (starting from the right):
  Increment newArray[j] for each element larger than it.

Runtime: O(n^2)
Storage: O(n^2)


Idea 2: Sorting
  1. Create two new arrays (answer, sortedAry)
  2. Loop through starting from the last element
      A. Insert element into sortedAry
      B. answer[i] = index of sortedAry

Runtime: O(n^2)    (Looping through array: O(n), finding index and inserting: O(n))
Storage: O(n)   (specifically, 2 * n)


Will implement idea 2

Time to think: 12 min
Time to code: 10 min