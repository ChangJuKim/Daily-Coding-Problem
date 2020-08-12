Good morning! Here's your coding interview problem for today.

This problem was asked by Facebook.

Given a binary tree, return all paths from the root to leaves.

For example, given the tree:

   1
  / \
 2   3
    / \
   4   5

Return [[1, 2], [1, 3, 4], [1, 3, 5]].

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Thoughts:

Honestly do something like
1. Current = [1]
2. If Node == leaf: add current to array
3. Else: add node to current, do DFS


Time to think: ~3 min
Time to code: ~6 min
Time to test: 8 min (and debug; had to clone the array)
