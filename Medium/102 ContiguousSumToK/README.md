Good morning! Here's your coding interview problem for today.

This problem was asked by Lyft.

Given a list of integers and a number K, return which contiguous elements of the list sum to K.

For example, if the list is [1, 2, 3, 4, 5] and K is 9, then it should return [2, 3, 4], since 2 + 3 + 4 = 9.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`

Alright I got it

1. Left = 0, right = 0. Totalsum = ary[0] (totalSum = sum of elements between left, right)
2. If totalSum < K, increment right and add to totalSum
3. If totalSum == K, return array between left and right
4. If totalSum < K, subtract left from totalSum and increment left by 1.
   A. If left > right (left == right when you moved left),
      Increment right and add to totalSum
Return null if left > ary.length

Runtime: O(N) [left and right go through the entire array once]
Storage: O(1)

Time to think: 5 min
Time to code: 11 min

~~~~~~~~~~~~~~~~~~~~~~

Feel like my code is sloppy but not quite sure how to clean it up
Problem is that you have 3 cases:
1. Sum < K => increment right
2. Sum > K and left != right => increment left
3. Sum > K and left == right => increment right

So you gotta cleanly handle it.
Additional problem is that you gotta nicely handle things like left and right edge cases