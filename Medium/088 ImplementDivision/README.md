Good morning! Here's your coding interview problem for today.

This question was asked by ContextLogic.

Implement division of two positive integers without using the division, multiplication, or modulus operators. Return the quotient as an integer, ignoring the remainder.

~~~~~~~~~~~~~~~~~~~~~~~~~~~

Thoughts:

Availible operations: Addition, Subtraction, Doubling, Halving...? Prolly not Halving

We want to implement integer division: a / b = c
Probably can do something like
  double b and keep going till you get greater than a.
  And do something about it.
  Basically determining the binary version of c

Idea 1:
  Fill in array: [b, 2b, 4b, 8b, ... kb] where k is  power of 2, and (2k)b > a
  Going backwards, add to sum so that you get closer and closer to a.
  At end of array, add together the powers of 2 to get c.

  Uh... example: 100 / 3 = 33
   [3, 6, 12, 24, 48, 96]
  [1*3, 2*3, 4*3, 8*3, 16*3, 32*3]
  96 + 3 < 100.
  return 32 + 1


Finished thinking in... 6 min?
Finished coding in 7 min

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Code works. Forgot to add the 0 case but it works now
Perhaps I should add the divide by 1 case

I was thinking about a way to optimize space...

Idea 1:
  Use bit shifting to replace the powers of 2