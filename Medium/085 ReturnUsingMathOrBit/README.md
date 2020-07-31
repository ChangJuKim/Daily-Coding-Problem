Good morning! Here's your coding interview problem for today.

This problem was asked by Facebook.

Given three 32-bit integers x, y, and b, return x if b is 1 and y if b is 0, using only mathematical or bit operations. You can assume b can only be 1 or 0.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Okay idea 1:
  1. Return  x * b + y * ~b.
  
  The problem is that this uses both math and bit operations... is that allowed??
  I'll assume I can ^^


Well if I can't...

Idea 2:
  1. Well you gotta do something with x * b and y * b...
  Agh whatever I'll implement idea 1.

  OH. x*b + y*(1-b)
  Ey, there we go. This is nice cause b is either 0 or 1.


Time to think: ~7 min
Time to code: ~5 min