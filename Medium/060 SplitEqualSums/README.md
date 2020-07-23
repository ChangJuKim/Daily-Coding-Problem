Good morning! Here's your coding interview problem for today.

This problem was asked by Facebook.

Given a multiset of integers, return whether it can be partitioned into two subsets whose sums are the same.

For example, given the multiset {15, 5, 20, 10, 35, 15, 10}, it would return true, since we can split it up into {15, 5, 10, 15, 10} and {20, 35}, which both add up to 55.

Given the multiset {15, 5, 20, 10, 35}, it would return false, since we can't split it up into two subsets that add up to the same sum.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Thoughts:
TL:DR really couldn't think of anything

Not sure why it says multiset. Isn't it just an array and you want to split to two?
I suppose set means there's no duplicates... except there are.

Regardless
Get total sum (O(N) time) and divide by two. If it's odd it's impossible
Will want some dynamic programming approach...
Perhaps Nx2 array...?
And ary[i][0] means i is added to first array, ary[i][1] mean it's added to second...?

Well... lets reorganize
There's a O(2^N) solution by trying adding and not adding each index to a sum.
  If sum > desired, return false (assuming no negatives)
  At the end of the array, if sum != desired, return false. Else return true
This should be able to be mitigated by dynamic programming..

...This is trying to go for an O(N) solution
An O(NlogN) solution would have you sort it first.. don't know if that changes anything
...I don't think it does

I'm actully pretty stuck
I can only think of the O(2^n) time solution... where you test each possibility

Hm..
Idea 1:
  Sort.
  Start at largest end and add it to sum
  If smallest number >= 0 and smallest + sum > desired... return false
  Hm... nevermind...
  yeah i'm really stuck


Okay I spent 21 min thinking about this. I really hate coding bad solutions but I
may as well code what I have

...I coded that in 4 min.
Time to spend the other 10 thinking of a better solution

OH I THOUGHT OF A SOLUTION
Idea 2:
  Sort.
  Start at largest end. Add to sum.
    Note that at least one array must have the largest number
    Note also that it is likely to need smaller numbers...............
  Add elements from shorter end......

  ...wait nevermind.... ughhh

[1, 2, 3, 4, 5, 6, 7] => 14


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Looked it up
As I thought it's a dynamic programming problem
But I erred in thinking that the rows and cols should be symmetrical

Idea:
  Create boolean table where rows marked by sum and cols marked by indices of array
  Uh... Basically ary[row][col] = true means it's possible to get a sum = row
    using any subset of values from {ary[0], ary[1], ... ary[col]}
  Check geeks for geeks DP 18 if you want more details. I'm kinda tired rn :<