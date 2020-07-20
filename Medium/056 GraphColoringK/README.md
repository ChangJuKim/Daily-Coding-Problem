Good morning! Here's your coding interview problem for today.

This problem was asked by Google.

Given an undirected graph represented as an adjacency matrix and an integer k, write a function to determine whether each vertex in the graph can be colored such that no two adjacent vertices share the same color using at most k colors.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Thoughts/etc:
  1. Naive / Brute force
     A. Color first node, go through other nodes and try to color. If it doesn't work,
        backtrack
  2. Naive with Dynamic Programming??
     A. Make 2d array (n x k) where k represents colors, n represents vertices
        Won't work because a node having color i is different when other nodes
	have other colors

  I. Trees are 2+ colorable
  II. Cycles depend on whether they have odd/even nodes
  III. Graphs may have different sections independent of each other
  IV. k >= n: always true


  1. Find independent subgraphs.
     A. Do DFS on a node, mark them visited.
     B. Increment count, find unvisited nodes, repeat.

     O(N) time. O(N) space


  2. Check colorable on each of them.
     I suppose I'll use the brute force method since I can't think of much else


     10 min to finish thinking



     Didn't finish.
     :<
     Probably because I tried to make it so complicated and optimize every small bit

