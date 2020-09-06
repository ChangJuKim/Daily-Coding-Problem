Good morning! Here's your coding interview problem for today.

This problem was asked by Jane Street.

Suppose you are given a table of currency exchange rates, represented as a 2D array. Determine whether there is a possible arbitrage: that is, whether there is some sequence of trades you can make, starting with some amount A of any currency, so that you can end up with some amount greater than A of that currency.

There are no transaction costs and you can trade fractional quantities.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

The basic idea is trying to determine a positive cycle.
Basically this is just a directed weighted graph and you want to find cycles that will
lead back with a positive value

Thus it doesn't matter if you trade fractional quantities; if you get a solution, you'll
want to trade all of what you have at once anyways


Given example:
[1, 2, 3]
[.5, 1, 4]
[.33, 2, 1]


You get graph:

       <= .5 <=
Node1  => 2  =>   Node2
 | ^             ^  /
 3 |           /   /
 | .33       2   4
 v |      /     /
               v
 Node3


Note that just because you can do it with one currency doesn't mean that you can do it with
all currencies.
E.g.

[1, .0000001, .000001]
[.2, 1, .2]
[.3, 1.1, 1]

If you end up at currency 1, you'll never be able to go back to a different currency
with a profit



Solution (Travelling Salesman):
Note that I found this solution to Travelling Salesman online (before starting this problem).

Idea:
  Find a positive travelling salesman route for *cycles* of length 2, 3, ..., n+1
  If any exist, return true.
  If none exist, return false.

How to solve travelling salesman problem:

High level idea:
  1. You are given 2D array indicating path of length 1.
  2. Using 2D array indicating optimal paths of length n starting at i and ending at j,
     get it for paths length n+1
  3. Stop once you get a path length ary.length.


Implementation:
  1. You have 2D array.
  2. For ary[i][j], get the max (note that it's min for travelling salesman) of all
     ary[i][c] + originalAry[c][j] as long as c has not been travelled on, and c =/= i or j
       How does that work?
       A. Keep 2D array, path.
       B. path[i][j] is a number indicating which nodes have been travelled on
            a. look at binary representation of path[i][j] (= binaryNum)
	    b. if binaryNum[0] == 1, that means it went through node 0.
	     if binaryNum[k] == 1, that means it went through node k.
	    This lets you easily check if a node has already been traversed

       A. ary[i][j] = max(ary[i][c] + originalAry[c][j]) because
            a. Well you do max because you want to max avalue
	    b. ary_n[i][j] means path size n starting at i an going to j.
	         1. ary_{n-1}[i][c] is path size n-1 starting at i and going to c
	         2. so to get the max path, you want to sum each path of length n-1
	            starting/ending at [i, c], with the path length 1 starting/ending at
	            [c, j] t
  3. uh.. that's basically it.
  4. To check the cycle, add ary[i][j] with originalAry[j][i]. This will make it from
     a path starting/ending at [i,j] to a cycle starting/ending at [i][i].
  5. If that cycle is positive or something, return true

Note that I summed to get max, but likely you want to multiply instead and get the max.
If you want to see if the cycle is good, then check if result > 1.


Runtime... oh jeez
So... given ary[n][n]:

Update paths n times (each time extending the path of the array)
  Loop through 2D array to get each path starting and ending at [i][j]
    Determining max, you go through it n times
  Checking if cycle is positive (or greater than one or something) do it n times

So... O(n^3)?

Finished in ~35 min

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Actually I looked back at my the vid I got this from and
Runtime: O(n^2 * 2^n)

And the best solution is Bellman Ford algorithm (for directed weighted graphs,
checking for negative edge weights) and calling it on each source node which is
O(n^3) solution


