Good morning! Here's your coding interview problem for today.

This problem was asked by Google.

Given pre-order and in-order traversals of a binary tree, write a function to reconstruct the tree.

For example, given the following preorder traversal:

[a, b, d, e, c, f, g]

And the following inorder traversal:

[d, b, e, a, f, c, g]

You should return the following tree:

    a
   / \
  b   c
 / \ / \
d  e f  g

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Thoughts/Etc:
  1. First element of preorder is the root
  2. First element of inorder is the leftmost node. This may be the root

  *Preorder is depth-first search, inorder is left->right

  3. Until the inorder iterator reaches the node on the preorder, you can assume
     that the nodes are to the left of the preorder.
  4. Traversing down one array while looking at one String on the other array will
     definitely reach that String eventually


Ideas:
  1. Loop through preorder. Until you find the first element of inorder, keep adding to left
  2. Once you do, loop through inorder and do things



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

35 min total
Took about 5 min to read the problem
Took about 15 min to slowly code while thinking about it

Man didn't finish. Brandon got what is probably the optimal solution by finding the head
in the inorder and splitting up the arrays to the left subtree and right subtree

I'm kinda sad that we're not finishing these and instead limiting to a time limit

Maybe someday I'll finish.