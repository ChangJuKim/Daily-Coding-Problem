Good morning! Here's your coding interview problem for today.

This problem was asked by Facebook.

Given an unordered list of flights taken by someone, each represented as (origin, destination) pairs, and a starting airport, compute the person's itinerary. If no such itinerary exists, return null. If there are multiple possible itineraries, return the lexicographically smallest one. All flights must be used in the itinerary.

For example, given the list of flights [('SFO', 'HKO'), ('YYZ', 'SFO'), ('YUL', 'YYZ'), ('HKO', 'ORD')] and starting airport 'YUL', you should return the list ['YUL', 'YYZ', 'SFO', 'HKO', 'ORD'].

Given the list of flights [('SFO', 'COM'), ('COM', 'YYZ')] and starting airport 'COM', you should return null.

Given the list of flights [('A', 'B'), ('A', 'C'), ('B', 'C'), ('C', 'A')] and starting airport 'A', you should return the list ['A', 'B', 'C', 'A', 'C'] even though ['A', 'C', 'A', 'B', 'C'] is also a valid itinerary. However, the first one is lexicographically smaller.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`

Thoughts

Idea 1 (try all):
  Do recursive function, run through all possible results. Want a depth-first recursion.
  Runtime: Worse case, O(n^2) where n is locations (e.g. a completely filled graph)
  There should be a dynamic way to optimize this


Idea 2 (Something to do with matrices):
  Create a nxn matrix (n = all locations). Matrix[x][y] += K if there are K flights
  from x to y.
  Perhaps shorten (e.g. if A only goes to B, B only goes to C, then erase those two and
  make a path from A to C)
  ....?

Idea 3 (Graph Theory):
  This is akin to the following problem:
  Given a directed graph (more than one edge is allowed), find a path that uses all
  edges, starting at node A.
  I'm sure there's something to do with a blossom algorithm... oh that's for bipartite matching
    I thought it was weird that cycles depended on even number or odd number of nodes


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`

Took 35 minutes; 20 minutes to think about it and 15 to try implementing idea 1