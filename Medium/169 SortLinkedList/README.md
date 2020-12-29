Good morning! Here's your coding interview problem for today.

This problem was asked by Google.

Given a linked list, sort it in O(n log n) time and constant space.

For example, the linked list 4 -> 1 -> -3 -> 99 should become -3 -> 1 -> 4 -> 99.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`

Well... merge sort is the typical n log n sort. So is quicksort.

For merge sort you can do something like

1. Let mergeSort take 2 arguments, node and length. Node is head of list, length is
   max length of list

2. Basically just divide list and then merge it.

Problem is, wouldn't keeping track of the length be O(log n) space?



For quicksort, you pick a partition, move smaller to left and larger to right,
then quicksort on each of the two sections.
But picking a partition and going to it is O(n)... and you do that O(n) times.



...maybe mergesort is fine. Imma just code it

Time to think: ~8 min
Time to code: ~20 min didn't even finish

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

I lost stamina tbh. This was stressful to think about.
Turns out the solution is mergesort.

I will uh... not really finish the rest...