Good morning! Here's your coding interview problem for today.

This problem was asked by Slack.

You are given an N by M matrix of 0s and 1s. Starting from the top left corner, how many ways are there to reach the bottom right corner?

You can only move right and down. 0 represents an empty space while 1 represents a wall you cannot walk through.

For example, given the following matrix:

[[0, 0, -1],
 [0, 0, -1],
 [-1, 0, 0]]
Return two, as there are only two ways to get to the bottom right:

Right, down, down, right
Down, right, down, right
The top left corner and bottom right corner will always be 0.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

If there are no walls, you can do some sort of pascal's triangle thing
and basically you get something like
numPaths = (n-1) C (m+n-2)
or something.
That's a O(n) solution
Look at my solution for #62 (Medium) to see more.


Since there are walls, and you don't know where they are, you can't have a constant
time solution (you need to go through the array once at least to see where the walls are).

Unless we have some amazing math and some crazy solution and we're given where the walls
are instead of the array itself, you'll have an O(n^2) solution.


Idea:
  1. Change all 1's to -1. Make the top left a 1.
  2. Loop through the array (going left to right, top to bottom... or
       top->bottom, left->right it doesn't matter)
  3. If current is negative, skip
  4. If right exists and is not negative, then add current to right.
  5. If bot exists and is not negative, then add current to bot.
  6. Once loop is done, return result of bottom right.

Runtime: O(n^2)
Storage: O(1)

Come to think of it, just make the top left -1. Then you can do the above idea
(except of course, changing all negatives->positives, positives->negatives)
And you'll save yourself the trouble of going through the array and making 1's negative