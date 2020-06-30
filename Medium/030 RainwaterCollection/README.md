Good morning! Here's your coding interview problem for today.

This problem was asked by Facebook.

You are given an array of non-negative integers that represents a two-dimensional elevation map where each element is unit-width wall and the integer is the height. Suppose it will rain and all spots between two walls get filled up.

Compute how many units of water remain trapped on the map in O(N) time and O(1) space.

For example, given the input [2, 1, 2], we can hold 1 unit of water in the middle.

Given the input [3, 0, 1, 3, 0, 5], we can hold 3 units in the first index, 2 in the second, and 3 in the fourth index (we cannot hold 5 since it would run off to the left), so we can trap 8 units of water.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Idea 1:
    1. Start with two pointers, one from the left and one from the right, maxLeft = maxRight = 0
    2. Until array[left] < maxLeft, increment left. Same for right. Keep updating maxLeft/maxRight
      2.a. Idea is that you can ignore those walls because those areas will never collect water (it just runs off :<)
      2.b. Once array[left] < maxLeft and array[right] < maxRight, the middle areas will collect water.
    3. Start at minimum(maxLeft, maxRight). (for purposes of explanation will assume left < right)
    4. i = left. While(array[i] <= maxLeft)
           total += maxLeft - array[i]
	   array[i] = maxLeft
    5. If array[i] > maxLeft, maxLeft = array[i]. Repeat 3-5 until left and right meet


Idea 1 SIMPLIFIED:
    1. Start with two pointers. leftWall = ary[0]. rightWall = ary[-1]
    2. Increment minimum(leftWall, rightWall).
       2.a. If ary[i] < Wall, collect water.
       2.b. If ary[i] > Wall, update Wall height
    3. Keep going till pointers meet

    Edit: Nevermind, you have to find the left and right walls first


~~~~~~~~~~~~~~~~~~~~~~

Done!
Wasn't too bad, implemented idea 1, then decided to simplify it, then realized I needed
the part that I removed

Did some extensive testing