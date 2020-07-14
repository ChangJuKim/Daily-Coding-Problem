Good morning! Here's your coding interview problem for today.

This problem was asked by Google.

We can determine how "out of order" an array A is by counting the number of inversions it has. Two elements A[i] and A[j] form an inversion if A[i] > A[j] but i < j. That is, a smaller element appears after a larger element.

Given an array, count the number of inversions it has. Do this faster than O(N^2) time.

You may assume each element in the array is distinct.

For example, a sorted list has zero inversions. The array [2, 4, 1, 3, 5] has three inversions: (2, 1), (4, 1), and (4, 3). The array [5, 4, 3, 2, 1] has ten inversions: every distinct pair forms an inversion.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Thoguhts/Ideas/Whatever this section is called now
  1. Use merge sort, and each time you move a smaller element up, you add 1 to the count
     ...eh lets just do 1. Merge sort is O(nlogn) and that's les than n^2
  2. Actually it doesn't mention storage. A solution that really compromises storage cost...
     ...Lets just do merge sort.


  I came up with the idea of using merge sort by... well I thought sorting would be best.
  After all, it's an O(nlogn) operation.
  The only problem with sorting is that you lose the inversions.
  Therefore you need to somehow count inversions while sorting
  Insertion sort / Bubble sort would be nice for counting inversions but they're O(n^2)
  But MergeSort also does the trick



  Timed:
    Finished with no testing in 34 min.
    This includes reading the problem, thinking of solutions, and coding
    Tested and broke because I didn't include previous inversions in my result
      Should be a simple fix
      ~~~~~~~~~~~~~~~~~
      Fixed in ~10 min
      Made merge and split take int[][] arrays
      Basically take an array and inversion
      And made them return an array and inversion
      It's kinda messy but works