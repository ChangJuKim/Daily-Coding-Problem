Good morning! Here's your coding interview problem for today.

This problem was asked by Google.

The edit distance between two strings refers to the minimum number of character insertions, deletions, and substitutions required to change one string to the other. For example, the edit distance between ¡°kitten¡± and ¡°sitting¡± is three: substitute the ¡°k¡± for ¡°s¡±, substitute the ¡°e¡± for ¡°i¡±, and append a ¡°g¡±.

Given two strings, compute the edit distance between them.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Man
First off I have to say that this was listed as a hard problem on other sites
> . >

Brandon and I skipped this when we first encountered it after thinking about it
But we came back to it after looking at 034 (Palindrome problem) and noticing
that it was similar, and looked up this problem.

It's basically brute force but with dynamic programming to make runtime better.
But it's still brute force. Bleh

There is an interesting optimization in which you reduce space from O(n * m) to O(2n)
But overall... the core solution is just brute force. Isn't that boring?

Alright thoughts/rant over

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Notes:
  1. When comparing two characters of a string, you can either
     1. Delete the first
     2. Delete the second
     3. Replace one with the other
  2. When deleting a letter, no need to worry about it anymore.
     When replacing, no need to worry about both letters

Solution:
  Space complexity: O(n * m)
  Time complexity: O(n * m)


There's another solution I found that reduces space complexity to O(2n)
(Without loss of generality, assume that n <= m)

The key is that determining ary[x][y] relies only on
   1. ary[x-1][y-1]
   2. ary[x][y-1]
   3. ary[x-1][y]

So you can only hold two rows and remember which one is the "previous" row
and update the other depending on contents of previous