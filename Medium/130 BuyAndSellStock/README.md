Good morning! Here's your coding interview problem for today.

This problem was asked by Facebook.

Given an array of numbers representing the stock prices of a company in chronological order and an integer k, return the maximum profit you can make from k buys and sells. You must buy the stock before you can sell it, and you must sell the stock before you can buy it again.

For example, given k = 2 and the array [5, 2, 4, 0, 1], you should return 3.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Thoughts
  1. Is it exactly k buys and sells or at least k buys and sells?
     I'll assume you must use k buys and sells. You can't use less

  2. Also note that you're only buying one stock and selling one stock.

  3. This problem can be summed up as follows:
     A. Subtract k values and add k values in the following manner:
        The ith value added/subtracted must be between the
	  i-1 and ith value subtracted/added
	Or something like that

  4. Can you buy and sell the same stock? If so k <= n and if k == n, buy/sell all
        Assume not. If so, it's actually equivalent to not having to use up all k

Well
  1. k <= n/2.
  2. If k == n/2, return sum of evens - (sum of odds)


Idea 1...? (Skips and sums and subtractions and so on). Brute force
  1. # skips = N - 2k.
     (At any point) if skips == 0, return (sum evens) - (sum odds)
     (At any point) if k == 0, return current sum
  2. At a spot, you can skip or buy/sell. branch for both
      A. (Skip): skip -= 1, i += 1. check skip
      B. (Buy/Sell): Total += sign * ary[i]. i += 1, sign = sign * -1. k-= 1. Check k 

Idea 2: Dynamic programming of above:
  Keep memo table size SKIP x 2 x N.
  ary[Skip][sign][N] basically
  Size N represents all indices
  Skip and sign represents a moment of time when you have Skip skips left, and are
    buying/selling
  A lot of space but shouldn't be too bad... I think...

  Otherwise do the same as above

  Note that SKIP = N-2k... so size is (N-2k)*2*N = 2N^2 - 4kN
  ...which is a lot of space. O(N^2) space

Will try to implement Idea 2

I don't even want to think about runtime

Time to think: 24 min
Time to code: 20 min?

~~~~~~~~~~~~~~~~

There's probably quite a few bugs here. I didn't try to run it.

After reading solution, problem was probably at most k times.
There are better solutions out there with
O(kn) time, O(n) space.

Mine is... ah jeez I don't want to think about it.
  Well if I did a BFS method...

Thoughts:
  1. To get from i to i+2, there are 3 ways:
     1. skip twice
     2. skip, buysell / buysell, skip
     3. buysell twice
  2. From i to i+3, there are 4 ways:
     1. skip 3 times
     2. skip 2 times, buysell 1 time
     3. skip 1 time, buysell 2 times
     4. buysell 3 times
So as long as I compute all methods for i+2 from i... i think it's good?
Maybe not.

Regardless I have a pretty long runtime

Probably something like (n+1)(k)...?
...if so that's not bad

Idk this is off the top of my head. If someone verifies then I'd be
  happy to know lol.