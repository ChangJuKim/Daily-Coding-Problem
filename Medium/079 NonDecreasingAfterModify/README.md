Good morning! Here's your coding interview problem for today.

This problem was asked by Facebook.

Given an array of integers, write a function to determine whether the array could become non-decreasing by modifying at most 1 element.

For example, given the array [10, 5, 7], you should return true, since we can modify the 10 into a 1 to make the array non-decreasing.

Given the array [10, 5, 1], you should return false, since we can't modify any one element to get a non-decreasing array.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Idea:
  If array[i] > array[i+1]:
    If (numErrors > 0): return false
    Else: int numErrors = 1
  return true

Runtime:
  O(N)


Thinking time: ~3 min
Coding time: 2 min

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Edit:
  Oh there's an error hahah.
  If we have
    3, 1, 2, 5 then we can't change 1 to a 3 because the new 3 is > 2.
    So this would be false