Good morning! Here's your coding interview problem for today.

This problem was asked by Facebook.

Given a positive integer n, find the smallest number of squared integers which sum to n.

For example, given n = 13, return 2 since 13 = 3^2 + 2^2 = 9 + 4.

Given n = 27, return 3 since 27 = 3^2 + 3^2 + 3^2 = 9 + 9 + 9.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Well you'd want some kinda dynamic programming solution

Base case: n <= 8: return n / 4 + n % 4


Maybe you don't want a dynamic programming solution
...maybe you do
hm


def function(int n, int currentSums, int max_a):
  if (baseCase): return currentSums or something

  Find biggest a such that a^2 < n and a <= max_a
  loop from a to 1:
    potentialMin = function(n-a^2, currentSums+1)
    if (potentialMin != null) 
      min = Math.min(min, potentialMin)
    else:
      continue
  return min

max_a will ensure that we don't have something like

27 = 16 + 9 + 4
27 = 9 + 16 + 4

Basically prevents checking previously checked iterations

Runtime: Pretty bad
Jokes aside, it's... well pretty bad

I wonder if always picking the largest square will return the best solution
No because 16: 4 + 4 + 4 + 4 is better than 9 + 4 + 1 + 1 + 1
Wait i'm an idiot cause 16 = 16
But not for 12: 4 + 4 + 4 is worse than 9 + 1 + 1 + 1


But picking the largest or 2nd largest is always better than picking the 3rd largest
I think...?

~~~~~~~~~~~~~~~~~~~~~~~~~~

I think my runtime is n^2
Because there's a four-square theorem which states that each natural number is at most the sum of 4 squares
maxCurrent will be at most 4 once I find a solution
So basically all my recursion will be max 4 deep
So since each recursion is at most sqrt(n) long, that's sqrt(n)^4 = n^2

Anyways using 4-square theorem will make it a lot faster
And yes, picking the largest isn't the best solution.