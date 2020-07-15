Good morning! Here's your coding interview problem for today.

This problem was asked by Microsoft.

A number is considered perfect if its digits sum up to exactly 10.

Given a positive integer n, return the n-th perfect number.

For example, given 1, you should return 19. Given 2, you should return 28.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

1. Simplest solution is to keep adding by 1 until you get a perfect number.
   Decrement n by 1
   If n is 0, return

2. Find some rules and apply


~~~~~~~~~~~~~~~~~~~~`

Took ~35 min to finish.

Problem was hard to wrap my head around cause it felt like there were a lot of
edge cases
But once I started implementing rules, it wasn't too bad
I figured that the "edge cases" would actually be handled by the appropriate rules
and wouldn't actully be edge cases

Took ~10 min to test


~~~~~~~~~~~~~~~~~~

Man I looked it up because I wanted to test if my code was correct
(How do you check that the 1000th perfect number is actully 100036??)
And it turns out there's a constant time/space solution
So I'm terribly inefficient here with my O(k * n) solution
where k = # digits in current

Man. I forgot that adding by 9 makes a difference of 0 (usually) in the sum
Alright. That's a bit disappointing.