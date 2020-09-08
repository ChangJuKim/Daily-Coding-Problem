Good morning! Here's your coding interview problem for today.

This problem was asked by Apple.

Gray code is a binary code where each successive value differ in only one bit, as well as when wrapping around. Gray code is common in hardware so that we don't see temporary spurious values during transitions.

Given a number of bits n, generate a possible gray code for it.

For example, for n = 2, one gray code would be [00, 01, 11, 10].

~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Reminds me of towers of hanoi or something.
Well I looked in the wiki article here: https://en.wikipedia.org/wiki/Gray_code
for reference and ideas. wiki article was linked in the original problem.
Below idea is taken from the table there.


Idea:
grayCode(n):
  return [0 + grayCode(n-1), 1 + grayCode(n-1)_Flipped]

grayCode(1) = [0, 1]
grayCode(2) = [00, 01, 11, 10]
grayCode(3) = [000, 001, 011, 010, 110, 111, 101, 100]

Need:
  1. FillZeros: places leading zeros until it is n bits
  2. Some memo table

~~~~~~~~~~~~~~~~~

Closing thoughts
Ling did a method that was different and quite interesting.
Will not describe here cause uh... that's not the point of this section.

My code breaks if you call greyCode multiple times and for a smaller n because my
memoTable used to be a 2D array instead of a 1D array (and it would hold grayCode(1),
grayCode(2), ... grayCode(n-1), grayCode(n).
Thus you just had to call grayCode(x < n) to get it.
But I changed it from a 2d array to a 1d array so you lose previous greyCode(x)'s.

If you wanted to call grayCode multiple times, then you'd want to change it from a
ArrayList<String> to ArrayList<ArrayList<String>>


My code could be cleaner and better. The idea is sound though.