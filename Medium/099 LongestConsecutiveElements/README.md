Good morning! Here's your coding interview problem for today.

This problem was asked by Microsoft.

Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example, given [100, 4, 200, 1, 3, 2], the longest consecutive element sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Hm.
For O(n) complexity you'll prolly want a lot of space
Well

Idea 1:
  1. Loop through and put all elements in a hashset
  2. Get element in hashset. Make left = right = element.
     A. Try to find element - 1  (make that left) and element + 1 (make that right). If
        they exist, remove from hashset.
     B. Keep going till you can't find an element = left-1 and no element right+1
     C. If maxLength < thisLength, max = this
  3. Find next element in hashset and repeat.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Actually I got asked this question already. Skipping. Answer should be above.