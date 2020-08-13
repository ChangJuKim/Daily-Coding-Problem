Good morning! Here's your coding interview problem for today.

This problem was asked by Google.

Given a string of words delimited by spaces, reverse the words in string. For example, given "hello world here", return "here world hello"

Follow-up: given a mutable string representation, can you perform this operation in-place?

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Well... seems kinda simple

Go backwards, if you find a space then I guess append word to the back of the string?
Actually no need to go backwards

So
1. Start = end = 0
2. while (start < word.length):
     while (end != " " or end == word.length):
       end ++
     word = word.substring(start, end) + word.substring(end)
     uh... some problem with start and end indices so start += end-start, end += end-start
     start += 1
3. return word

Time to think: 3 min
Time to code: 8 min
Time for in-place: uh... 24 min+ ?