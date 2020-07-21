Good morning! Here's your coding interview problem for today.

This problem was asked by Amazon.

Given a string s and an integer k, break up the string into multiple lines such that each line has a length of k or less. You must break it up so that words don't break across lines. Each line has to have the maximum possible amount of words. If there's no way to break the text up, then return null.

You can assume that there are no spaces at the ends of the string and that there is exactly one space between each word.

For example, given the string "the quick brown fox jumps over the lazy dog" and k = 10, you should return: ["the quick", "brown fox", "jumps over", "the lazy", "dog"]. No string in the list has a length of more than 10.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Doesn't seem too bad.

Thoughts:
  You want to just add words until you can't and go to newline
  If a word is length > k, you return null
  This probably feels easy because we've done a similar problem before
    That problem had us do uh... split sentence and add spacing
    Oh, text justify
  Anyways might want to preprocess string to an array of words
    That'll be O(N) time which is nice


Finished in 19 min total.

Will start testing
Testing finished in 4 min


~~~~~~~~~~~~~~~~~~~

I guess my problem takes N space which can be optimized.
Wait, actually that's not a problem because the answer requires O(N) space anyways
Whatever I'll work on a version 2 here
It's called "SentenceToLinesLessSpace"
...it's basically the same. Except the way I get the word.
Didn't test the 2nd version