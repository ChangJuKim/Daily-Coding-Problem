Good morning! Here's your coding interview problem for today.

This problem was asked by Uber.

Implement a 2D iterator class. It will be initialized with an array of arrays, and should implement the following methods:

next(): returns the next element in the array of arrays. If there are no more elements, raise an exception.
has_next(): returns whether or not the iterator still has elements left.
For example, given the input [[1, 2], [3], [], [4, 5, 6]], calling next() repeatedly should output 1, 2, 3, 4, 5, 6.

Do not use flatten or otherwise clone the arrays. Some of the arrays can be empty.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


Uh.. imma just start coding.

Next will be something like
1. Examine length of array. If possible, move index forward or something




Time to code: 14 min


~~~~~~~~~~~~~~~~~~~

Overall, not too bad. I wonder though if there's a better way than
using ary[i][j] to get an element (such as pointers or dereferencing)...

Cause isn't calling ary[i][j]   (i+j) time anyways?