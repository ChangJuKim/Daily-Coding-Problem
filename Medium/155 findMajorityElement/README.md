Good morning! Here's your coding interview problem for today.

This problem was asked by MongoDB.

Given a list of elements, find the majority element, which appears more than half the time (> floor(len(lst) / 2.0)).

You can assume that such element exists.

For example, given [1, 2, 1, 1, 3, 4, 0], return 1.

~~~~~~~~~~~~~~~~~~~~~~

Hm...
I think the example is broken.

Well you can always do:

Idea 1:
  Have a hashmap storing how many times each element appears
  Loop through list and for each element, increment the number of times it appears
  If any appear more than floor(len(lst) / 2.0) times then return it

  O(n) time, O(n) space

Idea 2:
  Sort array.
  Go through array and keep track of maxCounter
  Keep a counter and that counts how many times the current number appears.
  If it's greater than maxCounter, update maxCounter
  return

  O(nlogn) time, O(1) space

Not coding, looking it up to see if we missed anything

~~~~~~~~~~~~~~~~~`

Looked it up cause it seemed simple
Turn out there's a O(n) time, O(1) space algorithm!

Basically loop through array and keep track of currentElement, and count
If ary[i] == currentElement, count += 1. Otherwise count -= 1;
If count == 0, make currentElement the next value.
At end of array, current element is basically majority element.

Definitely would not have gotten this
Well... maybe