Good morning! Here's your coding interview problem for today.

This problem was asked by Amazon.

Given an integer k and a string s, find the length of the longest substring that contains at most k distinct characters.

For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb".

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Idea: Start at each character and see what the longest substring is
Notes:
  1. When moving to next letter (and making it the start of longest substring)
     A. Check longest substring (starting at new letter) if you lowered # of letters


Uh.. okay idea:
  1. Let hashMap hold # of each letter in current substring.
  2. Let int distinctChars = # of distinct letters in substring
  3. Have two pointers, start and end.
  4. If start == endOfString, return maxLength (0 if you haven't found anything)
  5. If distinctChars < k,
        A. increment end
        B. hashMap[end]++
	C. if hashMap[end] == 1, increment distinctChars
  6. ElseIf distinctChars == k
        A. Compare longest substring and update maxLength if necessary
	B. while (distinctChars == k)
	     a. hashMap[start]--
	     b. if hashMap[start] == 0, decrement distinctChars
	     c. start++
  7. Repeat 4-6

Time to code/think: 22 min

~~~~~~~~~~~~~~