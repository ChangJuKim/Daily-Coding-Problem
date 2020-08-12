Good morning! Here's your coding interview problem for today.

This problem was asked by Cisco.

Given an unsigned 8-bit integer, swap its even and odd bits. The 1st and 2nd bit should be swapped, the 3rd and 4th bit should be swapped, and so on.

For example, 10101010 should be 01010101. 11100010 should be 11010001.

Bonus: Can you do this in one line?

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Thoughts:

You want to do some kinda bit masking and whatnot

Odd bits:  (BITS & 10101010) >> 1
Even bits: (BITS & 01010101) << 1

And then... uh... combine them together


((BITS & 10101010) >> 1) | ((BITS & 01010101) << 1)

Idk what'll happen to the first bit when leftshifted though...
Oh it just becomes a zero so it doesn't matter.

Time to think: ~7 min
Time to code: ~5 min (Took longer to look up byte primitive in java... but it's
                      signed so i ended up using int anyways > . >)