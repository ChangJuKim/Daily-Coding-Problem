Good morning! Here's your coding interview problem for today.

This problem was asked by Pinterest.

Given an integer list where each number represents the number of hops you can make, determine whether you can reach to the last index starting at index 0.

For example, [2, 0, 1, 0] returns True while [1, 1, 0, 1] returns False.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Thoughts:

Some kinda dynamic programming thingy. Alternately...

1. Create boolean array size N (canReach). Initialize as all false. Make canReach[0] true.
2. Loop through array.
   A. If canReach[i] is false, skip index i
   B. If canReach[i] is true, make canReach[i + ary[i]] true.

...Wait

Thinking about it more, can't you just...
1. Start at index 0. Let next = ary[0]
2. Go to index next. next = ary[next].
3. Repeat until you reach 0, last index, or past the end of array

...Right?

Oh it's # of hops you CAN make. So
[10, 0, 0] would still be valid. Because it's max # of hops.

---------------------------

Final idea:

1. Int steps = ary[0].
2. Loop current from 0 to ary length
   A. If current = ary length, return true
   B. If steps == 0, return false
   C. (Steps > 0): steps -= 1, current += 1.
        Steps = Max(steps, ary[current])

Basically idea is that you have a number of steps you can progress.
If it's 0, you ran outta steps.
If you can increase your max steps, you do so.

Runtime: O(N)
Storage: O(1)

Time to think: 10 min
Time to code: 7 min

~~~~~~~~~~~~~~~~~

Interestingly Brandon came up with a different solution:
1. Start backwards (current = ary.length - 1)
2. If an index can reach the current, make current that index
3. If you reach 0 return true. Else return false.