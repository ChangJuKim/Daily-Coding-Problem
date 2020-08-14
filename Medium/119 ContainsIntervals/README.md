Good morning! Here's your coding interview problem for today.

This problem was asked by Google.

Given a set of closed intervals, find the smallest set of numbers that covers all the intervals. If there are multiple smallest sets, return any of them.

For example, given the intervals [0, 3], [2, 6], [3, 4], [6, 9], one set of numbers that covers all these intervals is {3, 6}.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`

Thoughts:

1. Find smallest right interval, find largest left interval.


That... should actually do it right...?
Unless it's one interval in which case just one number in that interval will do
Or nested intervals in which case the most nested is required

E.g. [1, 10]. Return [1, 1] or something
[1, 10] [5, 6]. Return [5, 5] or [6, 6]
[1, 10] [5, 6] [7, 8]. Return [6, 7]


1. Find most restrictive.
   E.g. [1, 10] [5, 6]. Most restrictive = [1, 10] => [5, 6]
   E.g. [1, 10] [2, 11]. Most restrictive = [1, 10] => [2, 10]

2. If an interval is outside the restrictive (left > M.R.right, or right < M.R.left)
   Then if (left > M.R.right), new restrictive = [M.R.right, left]
   else, new restrictive = [right, M.R.left]

3. Can no longer shrink restrictive. Can only expand by finding something outside restrictive

Runtime: O(n)
Storage: O(1)

Alright time to code
Time to think: 8 min
Time to code: 10 min
Time to test: 13 min.

Found a bug where if you could shrink at the end, didn't return an interval size 1
Basically [1, 10] [2, 11] should return [2, 2] or something.

Found another bug where [1,1] [2,2] [100,100] should return [1,100] but returned
[2,100] because I wasn't checking for canShrink


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

I guess you can just take smallest rightbound, largest leftbound
And if you canShrink, then shorten to one number interval (e.g. [5,5]).

So I don't need the canShrink parts...?

Okay I removed it and it broke.
And it's cause I ensure my left bound is always smaller than right bound
But if you let left and right bound swap, then you can basically do this idea:

1. left = largest rightbound.
2. right = smallest leftbound.
3. if canShrink (somehow check it), then make it a one size interval: [left, left]
   else return [min(left, right), max(left, right)]
       // Note that left may be less than, equal to, or greater than right
       // Thus the min and max calls