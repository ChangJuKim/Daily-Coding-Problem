Good morning! Here's your coding interview problem for today.

This problem was asked by Facebook.

A builder is looking to build a row of N houses that can be of K different colors. He has a goal of minimizing cost while ensuring that no two neighboring houses are of the same color.

Given an N by K matrix where the nth row and kth column represents the cost to build the nth house with kth color, return the minimum cost which achieves this goal.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Approach 1:
  1. From left to right, pick lowest cost values.
  2. If there is a conflict, branch. One will pick lowest for i and 2nd lowest for i+1. The other will pick lowest for i+1, 2nd lowest for i.
  3. If there are further conflicts (picked 2nd lowest for k, k-1 or k+1 also conflicts), branch again with 3rd lowest.
  NOTE: Even if the changes propogate, you will always be choosing from 1st, 2nd, or 3rd lowest