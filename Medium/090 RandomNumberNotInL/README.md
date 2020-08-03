Good morning! Here's your coding interview problem for today.

This question was asked by Google.

Given an integer n and a list of integers l, write a function that randomly generates a number from 0 to n-1 that isn't in l (uniform).

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

I have two approaches. The runtime of one depends on n, the other depends on l.


Idea 1:
  Go through 0-n and pick a random number based on stream thingy.
  Basically
    1. number = 0. Probability = 1.
    2. For i in [0, n):
       A. If i isn't in l:
            replace number with i with probability 1/Probability.
	    Probability += 1

  Runtime: O(n + lookup in l).
  If you preprocess l to be a hashset, runtime is O(n + l)
    (including the preprocessing step)


Idea 2:
  Pick a random number from [0, n)
  If it's in l, repick.


  Runtime: Depends on how many elements in n are in l.
  
  Let ratio of (elements not in n) to n = k.

  Runtime = 1*(k) + 2*(1-k)(k) + 3*(1-k)^2(k) + ...
  (1-k)Runtime =        1*(1-k)(k) + 2*(1-k)^2(k) + ...
  ---------------
  (k)Runtime = k + (1-k)k + (1-k)^2(k) + ... (from subtraction)
  (k)Runtime = k / 1 - (1-k) = 1.    (from formula of geometric sum)
  Runtime = 1/k

  ...I think. Ah don't forget the hashset time.
  So

  Total Runtime: 1/k + l.


  So basically the greater k is, the longer it takes.
  If k = 0, it never stops (which is a problem)

  To resolve the problem, you can stop after n^2 tries or something.
    That makes it a Monte Carlo solution.
  If you don't stop until you get a solution, it's a
    Las Vegas solution (which may never end)


  Monte Carlo analysis: What number is nice to stop on?
  Assume x = total tries.
  If k != 0, and x tries occur, you return a wrong answer.
    So you return a wrong answer with probability:
       Probability = (1/k)^x
       It's not possible to check what k is.
    So... whatever. n^2 should be a sufficiently large bound.
    I'm not sure how to pick a nice number for x


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Idea 1 is nice in that you know if you have a solution or not. However,
the runtime can be long.

Idea 2 is nice if you know there's few elements in n that are in l.
  (The runtime can be as low as constant)
However, if it's not then the algorithm becomes really long

I will implement both, but I'd say Idea 1 is better because
  1. You know if a random number is possible
  2. The runtime isn't too too bad.


Time to think: ~17 min?
Time to code: 18 min? I was also analyzing what a good value for x would be