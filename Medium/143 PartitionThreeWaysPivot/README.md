Good morning! Here's your coding interview problem for today.

This problem was asked by Amazon.

Given a pivot x, and a list lst, partition the list into three parts.

The first part contains all elements in lst that are less than x
The second part contains all elements in lst that are equal to x
The third part contains all elements in lst that are larger than x
Ordering within a part can be arbitrary.

For example, given x = 10 and lst = [9, 12, 3, 5, 14, 10, 10], one partition may be [9, 3, 5, 10, 10, 12, 14].

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Thoughts:

IDEA 1:

If you can create a new array (O(n) space), then it shouldn't be too bad.
Go through array and if it's less than value, put it to the left.
If it's greater, put it to the right.
If it's equal, skip.

At the end fill values between the left and right with value

  Runtime: O(n)    (loop through array once)
  Storage: O(n)



If you can't create a new array, then you gotta switch values in place.
Idea 2: Sort smalls, then sort large
  1. left = 0. right = array.length-1.
  2. Loop till left reaches right.
  3. While ary[left] >= value, swap with ary[right]. right -= 1.
  4. left += 1.
  5. Once left == right, sort the large/equal.
     A. right = ary.length-1.
     B. repeat 2-4 except this time, swap with ary[right] while ary[left] == value.

  Runtime: O(n)   (More specifically, goes through the array at most 2 times)
  Storage: O(1)


Time to think: ~5 min
Time to code: 8 min
