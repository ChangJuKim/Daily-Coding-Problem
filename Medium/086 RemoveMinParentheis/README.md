Good morning! Here's your coding interview problem for today.

This problem was asked by Google.

Given a string of parentheses, write a function to compute the minimum number of parentheses to be removed to make the string valid (i.e. each open parenthesis is eventually closed).

For example, given the string "()())()", you should return 1. Given the string ")(", you should return 2, since we must remove all of them.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Idea:
  Have a stack. Add to stack if you find an open, remove from stack if you find close.
  (This can be represented as an int)

  Increment answer in the following two ways:
    1. If stack is empty and next is close, answer += 1. Don't make stack negative
    2. At the end of the string, increment answer by # remaining in stack.

Time to think: ~4 min
Time to code: ~3 min