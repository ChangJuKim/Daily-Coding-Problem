Good morning! Here's your coding interview problem for today.

This problem was asked by Facebook.

Given an N by N matrix, rotate it by 90 degrees clockwise.

For example, given the following matrix:

[[1, 2, 3],
 [4, 5, 6],
 [7, 8, 9]]
 
you should return:

[[7, 4, 1],
 [8, 5, 2],
 [9, 6, 3]]


Follow-up: What if you couldn't use any extra space?

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Rotating with N^2 extra space is pretty easy.
orig[i][j] = new[n-j-1][i]


Without extra space...
Perhaps something like
swap orig[i][j] with orig[n-j-1][i] for half of the indices.

Result:
  1. orig[i][j] is in the correct spot
  2. orig[n-j-1][i]
      a. Is at spot [i][j]
      b. Wants to be at spot [n-i-1][n-j-1]

      c. Every spot that's originally [n-j-1][i] wants to swap to the opposite spot
      d. Make it so if orig[i][j] moved in step 0, then orig[n-i-1][n-j-1] moved as well
         and if only half the indices moved as stated in step 0,
	 then
	   i. Half the spots need to swap as stated in step 2.c
	   ii. Every spot opposite that which needs to swap, also needs to swap.


  3. Basically, if you choose the spots right, then doing step0 swap and stepC swap
     will make everything right.


E.g.

[[1, 2, 3],
 [4, 5, 6],
 [7, 8, 9]]

==>

[[3, 6, 1],
 [8, 5, 2],
 [9, 4, 7]]     (1, 2, 9, 8 are in correct spots. 5 is not considered)

==>

[[7, 4, 1],
 [8, 5, 2],
 [9, 6, 3]]     (swapped 3 and 7, 4 and 6. This makes it in the correct spot)


You can consider this to be:
half the spots rotated clockwise (what we want).
and half the spots rotated counterclockwise (what we don't want).
For the counterclockwise, we rotate another 180 degrees (which is 270 ccw: what we want).


Runtime: O(n^2)... O(n^3) or something if we consider swapping to be O(n)
Storage: O(n^2)


There is one thing I haven't addressed: how do we determine which spots to swap in step 1?
We want specific criteria:
  1. Must be exactly half (rounded down if n is odd)
  2. Any two spots must not be a clockise rotation from each other
     i.e. If I cw rotate the spots, they must reach all other spots (except middle if n=odd)

     a. Easiest way is that I choose 1/4 of the spots,
        The other 1/4 are the flipped versions of the spots.

  1. If it's even, just do a quadrant and flip
      a. ary[0 to n/2 - 1][0 to n/2 - 1]
      b. Flipped: ary[n/2 to n-1][n/2 to n-1]
  2. If it's odd...
      a. Do ary[0][0 to n-2]
         ary[1][1 to n-3]
         ary[2][2 to n-4]
	 ...
      b. Flipped: ary[n-1][n-1 to 1]
                  ary[n-2][n-2 to 2]
		  ary[n-3][n-3 to 3]
		  ...



[[a b c d]
 [e f g h]
 [i j k l]
 [m n o p]]



[[1 2 3 4 5]
 [6 7 8 9 0]
 [a b c d e]
 [f g h i j]
 [k l m n o]]




Time to think + explain: 29 min
Time to code: 15 min

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Okay so there's a much simpler solution...
You flip the rows and then flip along diagonals...
I'm so sad :<
My solution is so wanky

It doesn't even work right now LOL

Okay I won't be debugging this.
