Good morning! Here's your coding interview problem for today.

This problem was asked by Facebook.

Implement regular expression matching with the following special characters:

. (period) which matches any single character
* (asterisk) which matches zero or more of the preceding element
That is, implement a function that takes in a string and a valid regular expression and returns whether or not the string matches the regular expression.

For example, given the regular expression "ra." and the string "ray", your function should return true. The same regular expression on the string "raymond" should return false.

Given the regular expression ".*at" and the string "chat", your function should return true. The same regular expression on the string "chats" should return false.

~~~~~~~~~~~~~~~~~~~~~~~

From my understanding:
  1. . is just any character
  2. * is any 0 or more of the previous character
        .* is any length of any characters
        a* means you have 0-infinite a's
        *** is basically just one asterik


Well...
1. Condense all consecutive asteriks to one asterik


Idea 1:
  1. Loop through regular expression and string.
       A. If regex[i] == character, check it fits and increment both pointers
       B. If regex[i] == . increment both pointers
       C. If regex[i] == * then... you have problems
            1.

Idea 2:
  1. Get all consistent substrings
      A. consistent substrings = strings that don't have . or *
      B. and end of string doesn't have a * following it.
  2. Check that they all exist in the string, and get their start indices. Return false
     if at least one doesn't exist
  3. Ensure that the start indices don't overlap and that they're in order
  4. Loop through string and regex, skipping over consistent substrings.
  5. You have 4 cases:
      A. .  ensure you can move both indices over by 1.
      B. a* count number of 'a' after that regex. Ensure string has at least that many and
            skip over the rest

Man idk.


~~~~~~~~~~~~~~~~~~~~~

Definitely did not get it
Solution is to use dynamic programming and go backwards.
I totally missed going backwards. 