Good morning! Here's your coding interview problem for today.

This problem was asked by Microsoft.

Given a dictionary of words and a string made up of those words (no spaces), return the original sentence in a list. If there is more than one possible reconstruction, return any of them. If there is no possible reconstruction, then return null.

For example, given the set of words 'quick', 'brown', 'the', 'fox', and the string "thequickbrownfox", you should return ['the', 'quick', 'brown', 'fox'].

Given the set of words 'bed', 'bath', 'bedbath', 'and', 'beyond', and the string "bedbathandbeyond", return either ['bed', 'bath', 'and', 'beyond] or ['bedbath', 'and', 'beyond'].

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Going to assume the dictionary is in a HashSet. If it is not (for instance, if it's in an array), we can preprocess it into a hashset. It will take absurdly long but ideally you'd only preprocess it once and then afterwards you don't deal with the array dictionary.

Idea 1:
  1. Start at beginning, test all substrings starting at index i = 0
  2. Once you find a word, branch (i = 0, and i = newIndex)
     2.a. If boolean[i] is true (after branching), just break because a previous recursion went through that as a starting point
     2.b Update boolean[i] as true
  3. Continue until you reach end of string
     3.a. If you found a valid word, true. Else false.