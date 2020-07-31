Good morning! Here's your coding interview problem for today.

This problem was asked by Microsoft.

Given an array of numbers, find the length of the longest increasing subsequence in the array. The subsequence does not necessarily have to be contiguous.

For example, given the array [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15], the longest increasing subsequence has length 6: it is 0, 2, 6, 9, 11, 15.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Decided to think about it. And then I found an O(n^2) solution so going to code it

Idea:
  Start at back (or front and reverse everything) and see length if subsequence
  starts at that index

  1. Create array size n. (lets call it L). This holds the length if subsequence starts at
     that index
  2. i = ary.length - 1. Loop till i < 0. Fill in L[i]:
      A. L[i] = 1.
      B. k = i+1. Loop till k = array.length
      C. if (ary[i] < ary[k]):
           L[i] = max(L[i], L[k] + 1)
  3. Return max lengths

  Basically:
  Create a length array. For the example above, it becomes
  ary = [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15]
  L =   [6, 4, 5,  3, 5,  3, 4,  2, 4, 3, 3,  2, 3,  2, 2,  1]

  How to fill in L:
    L[end] = 1.
    You're considering appending ary[i] to any of the subsequences in the following indices
    So if ary[i] < ary[i+k] (k >= 1), then you want to consider making ary[i] be part of
    the subsequence of ary[i+k].

    So you keep track of the max length you have so far (starts at 1)
    And see if you're smaller than anyone else. If you are, then see if appending yourself
    to their subsequence is longer than what you currently have.
    Note that if I'm checking i+k, i+k is the smallest value of the subsequence
    i+k represents. So if you're smaller than i+k, you're definitely smaller than the rest.

  

  