Good morning! Here's your coding interview problem for today.

This problem was asked by Amazon.

Given a node in a binary search tree, return the next bigger element, also known as the inorder successor.

For example, the inorder successor of 22 is 30.

   10
  /  \
 5    30
     /  \
   22    35
   
You can assume each node has a parent pointer.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Thoughts:
  1. If it has a right, go right. Then return leftmost.
  2. If there is no right, check parent. If it's parent's left, return parent
  3. While it's parent's right, keep moving up.
     A. If you reach root, return null. (the node is the largest element)
     B. If it was to a parent's left child, return that parent

	E.g.   	  50 
		 /
		10
		 \
		  30
		   \
		    35 (Given)

 These are all the cases (has rightchild, parent's leftchild, parent's rightchild).

Time to think: 15 min
Time to code: 14 min.

Refined idea so that there are only 2 cases:
  1. Has a rightchild (step 1 of above)
  2. Doesn't. (step 2, 3 of above)


