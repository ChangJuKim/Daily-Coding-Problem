Good morning! Here's your coding interview problem for today.

This problem was asked by Amazon.

An sorted array of integers was rotated an unknown number of times.

Given such an array, find the index of the element in the array in faster than linear time. If the element doesn't exist in the array, return null.

For example, given the array [13, 18, 25, 2, 8, 10] and the element 8, return 4 (the index of 8 in the array).

You can assume all the integers in the array are unique.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Thoughts/etc:

Hm... if there was no rotation you can find in O(log(n)) time.
This is because at a certain point you know for certain that the ones to the left
are smaller, and the ones to the right are larger.

In this case, it's the same up to a certain point; afterwards the numbers are all smaller

If you know where the largest/smallest integers are, you can solve in O(log(n)) time.
...If you can find that in less than linear time, we have an algorithm.

For example purposes:
[9, 10, 11, 12, 13, 14, 15, 16, 1, 2, 3, 4, 5, 6, 7, 8]

Idea:
  1. Get two indices. Can be i = length * 1/4 and j = length * 3/4.
     A. If ary[i] < ary[j]:
        We know the max number is to the right of j... or left of i
	We have narrowed our scope by 1/2.
	Get index leftmost.
	   If indexleft < i:
	   Max is to the right of j. Narrowed by 1/2 again
	   Else (indexleft > i):
	   Max is to the left of i.
	   ----------
	   Repeat step 1 again but with a narrower search margin
	   
     B. If i > j:
     	We know the max number is between i and j.
	We hve narrowed our scope by 1/2 (the middle two fourths)
	Repeat step 1 with narrower margin

  2. Find integer using normal split-in-half algorithm but slightly modified
     (only have to change indicies chosen)
     	   Can do this by having (index - maxIntIndex), with wraparound


Took 12 min to think

Finished in 24 min (36 min total)

Didn't manage to test.

Runtime: O(log(n)) (both functions are log(n) time)
Storage cost: O(1)

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

I like this idea so I wrote it down

Karey (and Brandon)'s idea:
   Looks at sorted half (relative to "mid") to see if the number is there or not.
   If it's not, then calls again on unsorted side. If it is, calls again on sorted.
   Basically at any index, either left or right will be sorted.
      Therefore you can make a check comparing the high and low of the sorted side
      so that you can see if it exists there or not


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~