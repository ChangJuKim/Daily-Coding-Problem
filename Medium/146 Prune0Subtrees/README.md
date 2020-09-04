Good morning! Here's your coding interview problem for today.

This question was asked by BufferBox.

Given a binary tree where all nodes are either 0 or 1, prune the tree so that subtrees containing all 0s are removed.

For example, given the following tree:

   0
  / \
 1   0
    / \
   1   0
  / \
 0   0
should be pruned to:

   0
  / \
 1   0
    /
   1
We do not remove the tree at the root or its left child because it still has a 1 as a descendant.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Idea: DFS
  Basically you just do a DFS and on the callback, make its children null if required

  Pseudocode:
  DFS(Node current):
    if (current is leaf node):
      if (current is 0):
        return true
      else:
        return false
    else:
      if (current.left != null):
        if (DFS(current.left)):
	  current.left = null;
        if (DFS(current.right)):
	  current.right = null;

    if (current is leaf node):
      if (current is 0):
        return true
      else:
        return false


Runtime: O(n)
Storage: O(1)

Time to think: ~5 min?
Time to code: ~8 min?