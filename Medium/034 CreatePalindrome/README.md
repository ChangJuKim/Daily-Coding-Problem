Good morning! Here's your coding interview problem for today.

This problem was asked by Quora.

Given a string, find the palindrome that can be made by inserting the fewest number of characters as possible anywhere in the word. If there is more than one palindrome of minimum length that can be made, return the lexicographically earliest one (the first one alphabetically).

For example, given the string "race", you should return "ecarace", since we can add three letters to it (which is the smallest amount to make a palindrome). There are seven other palindromes that can be made from "race" by adding three letters, but "ecarace" comes first alphabetically.

As another example, given the string "google", you should return "elgoogle".


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`

Man this looks hard

Thoughts:
  1. You can probably separate the input to two cases: strings that have at least
     one repeating character, and strings that have no repeating characters
     1.a. Well this is just for my sanity. It's rare to have more than one pair of
          repeating anyways. Both problems will condense to the original if they're
	  properly implemented
  2. Idea 1: Loop through string and see what it'd be like as the middle of a palindrome.
     Use the minimum size one.
     2.a. Costs are expensive though... lemme calculate
          N to go through string
	  N for each to see what it's like to be in the middle
	  So O(N^2). More specifically it's around N^2 + 2N for actually forming palindrome
	  That cost will encapsulate determining lexicographically earliest one
  