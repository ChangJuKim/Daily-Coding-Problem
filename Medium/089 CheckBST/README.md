Good morning! Here's your coding interview problem for today.

This problem was asked by LinkedIn.

Determine whether a tree is a valid binary search tree.

A binary search tree is a tree with two children, left and right, and satisfies the constraint that the key in the left child must be less than or equal to the root and the key in the right child must be greater than or equal to the root.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Didn't end up doing this.

Idea:
  1. Start at root node with leftBound = -inf, rightBound = +inf
  2. Verify that leftNode is null or between leftBound and this value. If not, return false
     Verify that rightNode is null or between rightBound and this value. If not, return false
  3. Repeat step 2 for left/right node (as long as it's not null)
  Return true