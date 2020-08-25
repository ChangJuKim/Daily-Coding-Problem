Good morning! Here's your coding interview problem for today.

This problem was asked by Facebook.

Given an array of integers in which two elements appear exactly once and all other elements appear exactly twice, find the two elements that appear only once.

For example, given the array [2, 4, 6, 8, 10, 2, 6, 10], return 4 and 8. The order does not matter.

Follow-up: Can you do this in linear time and constant space?

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Initial thoughts are adding all values and trying something with that...

If it's constant space, you likely want to be able to check if a number appears once
on the spot, without storing it.

I didn't realize the following constraints were a follow-up.

Without follow-up:
  Idea 1: Store numbers in hashmap, if it exists, put false in hashmap.
          Loop through hashmap and get the two numbers that aren't false
	  Runtime: O(n)
	  Storage: O(n)


  Idea 2: For each number try to find it.
          If only appears once it's one of the numbers.
	  Runtime: O(nlogn)
	  Storage: O(1)

  Idea 3: Sort. Then run through and see if there's 2 copies
          Runtime: O(nlogn)
	  Storage: O(1) / O(n)



I think the key here is that it's an array of integers.
I mean, this question could've been asked with strings, chars, treeNodes, etc.
So you should be able to do some math trickery here.

Sum of example above = 48.
Single numbers: 4, 8
48 - 12 = 36. 48 + 12 = 60
Average (of unique numbers): 6
Average (actual): 6 again...

Hm..
Sum = 48.
If you square each element, you get [4, 16, 36, 64, 100, 4, 36, 100]
  Note that I square (and not add each element/multiply each element by something)
  because I want each number to have a different result on the sum

  Sum = 360
  4^2 + 8^2 = 80


2a + 2b + 2c + ... + 2z + A + B = X
2[a + b + c + .. + z] + A + B = X

2a^2 + ... + 2z^2 + A^2 + B^2 = Y
2[a^2 + ... + z^2] + A^2 + B^2 = Y

[a + ... + z]^2 = [a^2 + ... + z^2] + 2[(ab + ... az) + (bc + ... + bz) + ... + (yz)]


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Brandon's solution:

  1. Result = XOR all numbers together.                               O(n)?
  2. Determine first bit in Result that's a 1                         O(log(maxNumber))
       A. You can leftshift a 1 until you reach it
       B. Alternately, (Result &  ~(Result - 1))
  3. Get numbers that contain that bit (e.g. if ary[i] & bit == bit)  O(n)
       A. Number1 = XOR them together                                 O(1)?
  4. Number1 = one of the numbers                                     
  5. XOR Number1 with Result to get Number2                           O(1)?
  
Which is the optimal solution
