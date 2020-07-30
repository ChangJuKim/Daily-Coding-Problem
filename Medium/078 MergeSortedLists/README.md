Good morning! Here's your coding interview problem for today.

This problem was asked by Google.

Given k sorted singly linked lists, write a function to merge all the lists into one sorted singly linked list.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

I actually already saw the solution for this

Solution:
  1. Get pointers to all lists
  2. Get min value, add it. Increment the pointer

Runtime:
  Given n = # elements,
  O(n * k) in the worst case
    This is because in the worst case
    for each element you add, you need to compare k-1 times.
    So O(n*k).

Storage:
  O(n). I mean, you need to return something of length n anyways.
  Excess storage = k I suppose, given that you have pointers for all lists.

Thinkning/Coding: 18 min.

I really need to be more familiar with linked lists
and be more efficient with my code. The way I coded this seems slightly inefficient

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Edit: actually the best solution is min heap
So I guess I never really saw the solution lol

Runtime with min heap is O(nlog(n))
  You just add all the values into the min heap, and remove them all again
So runtime would be better if k >= log(n)

That's interesting.