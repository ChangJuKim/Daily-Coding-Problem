Good morning! Here's your coding interview problem for today.

This problem was asked by Google.

You're given a string consisting solely of (, ), and *. * can represent either a (, ), or an empty string. Determine whether the parentheses are balanced.

For example, (()* and (*) are balanced. )*( is not balanced.

~~~~~~~~~~~~~~~~~~~~~~~~~~~

Without asteriks, you just do

1. int counter = 0.
2. Loop through string. If current = '(', counter += 1. If current = ')', counter -= 1.
    A. If counter is ever < 0, return false
3. Return true if counter == 0. Otherwise return false.

-----------------

With asteriks I feel like you can just have a range of possible values.

1. int[] range = [0, 0].
2. Loop through string.
    A. if current == '(', range[+1, +1]
    B. if current == ')', range[-1, -1]
    C. if current == '*', range[-1, +1]
    D. If rightBound is ever < 0, return false
    E. If leftBound < 0, make leftBound == 0
3. Return true if 0 is within the range. Return false otherwise.

Time to think: 7 min
Time to code: 6 min


[1] => [0, 1, 2] [-1, 0, 1, 2, 3]
