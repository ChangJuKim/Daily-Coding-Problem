Good morning! Here's your coding interview problem for today.

This problem was asked by Google.

On our special chessboard, two bishops attack each other if they share the same diagonal. This includes bishops that have another bishop located between them, i.e. bishops can attack through pieces.

You are given N bishops, represented as (row, column) tuples on a M by M chessboard. Write a function to count the number of pairs of bishops that attack each other. The ordering of the pair doesn't matter: (1, 2) is considered the same as (2, 1).

For example, given M = 5 and the list of bishops:

(0, 0)
(1, 2)
(2, 2)
(4, 0)
The board would look like this:

[b 0 0 0 0]
[0 0 b 0 0]
[0 0 b 0 0]
[0 0 0 0 0]
[b 0 0 0 0]
You should return 2, since bishops 1 and 3 attack each other, as well as bishops 3 and 4.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Idea 1:
  Something about comparing each bishop with each other. O(n^2) time

Idea 2:
  Some kinda hashset for each diagonal in the board.
  Add all bishops to appropriate hashset.
  Then count elements in each hashset.
    Calculate intersections 

  Adding bishops to hashset is O(n)
  Counting elements in hashset is O(n)
  Calculating how many intersections in given diagonal is O(1) => diagonals total = O(n)
  Total time: O(n)... I think?

  There is a problem if bishops are not unique (two bishops have same location)
    since they are counted twice for diagonals (assuming we ignore set restrictions)

Will be implementing this
6 min to think

31 in to code
Actual runtime... gotta check
   Let n = # bishops, x = width of board, y = length of board
   BoardSize = O(n)
   Adding bishops = O(n)
     leftHash = O(1)
     Loop through all bishops = O(n)
   Counting intersections = O(x + y)
     Loop through all diagonals = O(x + y);
     Count intersection in one diagonal = O(1)

   Total runtime: O(n) + O(n) + O(x + y)
                = O(n + x + y)

		Note that x + y is usually less than n
		x+y > n when bishops are far apart, and they're sparse.
		So I suppose in that case, Idea 1 is better.

   Total space: x + y + n