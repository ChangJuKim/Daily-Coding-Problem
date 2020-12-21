
Good morning! Here's your coding interview problem for today.

This problem was asked by Google.

You are given an array of length n + 1 whose elements belong to the set {1, 2, ..., n}. By the pigeonhole principle, there must be a duplicate. Find it in linear time and space.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

I'll just assume there's only one duplicate number.


Well the solution is just
  sum(array) + n+1 - ((n+1 + n) / 2).

  Basically, get the sum of the array and n+1. This will give the sum 1 + ... + n+1 and the duplicate. Subtracting the
  sum 1 + ... + n+1 will give the duplicate.


Runtime: O(n)
Storage: O(1)

Note that if n is excessively large, you can just subtract the elements of the array from n+1, 1, n, 2, ... and so on.
So as you sum the array, subtract from (1 + ... + n+1)
If that still gives an overflow... man just use BigInteger or something (using strings to represent integers instead).
Or divide everything by 10^x or something. It'll still work with floats.


Time to think: like... 30 sec
Time to code: ~3 min

~~~~~~~~~~~~

Well it took me a while to create test cases... but it works now!