Good morning! Here's your coding interview problem for today.

This problem was asked by Facebook.

Given a list of integers, return the largest product that can be made by multiplying any three integers.

For example, if the list is [-10, -10, 5, 2], we should return 500, since that's -10 * -10 * 5.

You can assume the list has at least three integers.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Idea 1: loop through array and find 3 largest values, 2 smallest negatives
 Compare the product of the 2 smallest negatives with 2nd and 3rd largest value
 Multiply that greater product with largest value
 Runtime: O(n)

Idea 2: Find 3 largest values, 2 smallest negatives (O(log(n)))
  Same as above
  Runtime: O(log(n))
  Actually, array has to be sorted already so searching is actually O(n)
  So this is the same idea as above :(
