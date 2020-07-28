Good morning! Here's your coding interview problem for today.

This problem was asked by Apple.

Suppose you have a multiplication table that is N by N. That is, a 2D array where the value at the i-th row and j-th column is (i + 1) * (j + 1) (if 0-indexed) or i * j (if 1-indexed).

Given integers N and X, write a function that returns the number of times X appears as a value in an N by N multiplication table.

For example, given N = 6 and X = 12, you should return 4, since the multiplication table looks like this:

| 1 | 2  | 3  | 4  | 5  | 6  |

| 2 | 4  | 6  | 8  | 10 | 12 |

| 3 | 6  | 9  | 12 | 15 | 18 |

| 4 | 8  | 12 | 16 | 20 | 24 |

| 5 | 10 | 15 | 20 | 25 | 30 |

| 6 | 12 | 18 | 24 | 30 | 36 |

And there are 4 12's in the table.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Idea (based off X):
  1. Get divisors of X
  2. Go through half the divisors in descending order
     A. If divisor < N:
          Add total by 2.
  3. If # divisors is odd, and the middle divisor (sqrt of X) is less than N,
          Subtract total by 1.
  Return

  Runtime: Depends on how we get divisors of X

Idea (based off N):
  1. Form NxN table
  2. Count how many are X
  Runtime: O(N^2)

*by the way not sure if this actually runs

Brandon/Karey's idea:
  1. Loop through N
     A. If X is divisible by i and X / i <= N
        total += 1;

