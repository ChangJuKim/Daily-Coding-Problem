Good morning! Here's your coding interview problem for today.

This problem was asked by Two Sigma.

Using a function rand7() that returns an integer from 1 to 7 (inclusive) with uniform probability, implement a function rand5() that returns an integer from 1 to 5 (inclusive).

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Pretty basic:
If i get a 1, 2, 3, 4, 5: return that number.
Else: reroll.


Storage: O(1)
Runtime: uh... expected runtime is......
  5/7 * 1 + (2/7)(5/7)(2) + (2/7)^2(5/7)(3) + ...

  so SUM^{inf}_{n=1}  (5/7)(2/7)^(n-1) * (n)
  Shouldn't be that bad.

Time to think: 1 min
Time to code and test: ~9 min