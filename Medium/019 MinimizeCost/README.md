Good morning! Here's your coding interview problem for today.

This problem was asked by Facebook.

A builder is looking to build a row of N houses that can be of K different colors. He has a goal of minimizing cost while ensuring that no two neighboring houses are of the same color.

Given an N by K matrix where the nth row and kth column represents the cost to build the nth house with kth color, return the minimum cost which achieves this goal.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Approach 1 (depth first):
  1. From left to right, pick lowest cost values.
  2. If there is a conflict, branch. One will pick lowest for i and 2nd lowest for i+1. The other will pick lowest for i+1, 2nd lowest for i.
  3. If there are further conflicts (picked 2nd lowest for k, but k-1 or k+1 also conflicts), branch again with 3rd lowest.
  NOTE: Even if the changes propogate, you will always be choosing from 1st, 2nd, or 3rd lowest

  Cost:
    Best case (no conflicts): O(N)
    Worst case (insane number of conflicts): O(N^3) [all lowest cost are same color, same with 2nd and 3rd]


Approach 2 (butterfly effect):
  1. From left to right, pick lowest cost values. 2nd lowest if there are conflicts. Calculate
  2. Make first element the 2nd lowest. Make changes by flipping until there's no need. Calculate relative changes to cost from 1.
  3. Make 2nd element 2nd lowest.
  4. Make 2nd element 3rd lowest.
  5. Keep going and so on and so forth
  NOTE: There are ways to optimize which ones you're changing and seeing effects
   	It should be very optimizable


  Cost:
    Best case (no conflicts): O(N)
    Worst case (insane number of conflicts): O(N^3) i think


Approach 3 (creds to Brandon for coming up with it):
  Idea: Update costs as you go through the houses
  1. House 1 costs are the same
  2. House<i><color> cost = min(House<i-1> costs) that don't use same color 