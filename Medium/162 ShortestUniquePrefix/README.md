Good morning! Here's your coding interview problem for today.

This problem was asked by Square.

Given a list of words, return the shortest unique prefix of each word. For example, given the list:

dog
cat
apple
apricot
fish

Return the list:

d
c
app
apr
f

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

And I'm back! It's been a long time since I did these. Feels really rusty.

Thoughts: You'd probably want some kinda trie.
Alternately: (n = length of list, m = length of longest word)

1. Sorting (n log n)
  A. Sort (n log n time)
  B. Go down the list and determine shortest prefix

  Note that this will change the order of answer which might not be what we want.


2. Hashmap / Node combination (n * m)
  A. Create hashmap[letter][Node]
      a. Node contains a list of words with that prefix, and a hashmap[letter][Node]
  B. Go through list.
      a. Append word to hashmap[word[0]].listOfWords
      b. If listOfWords.length == 1:
            go back to B.
	 If listOfWords.length == 2:
	    Do a. with both words in listOfWords (but index 1 now)
	 If listOfWords.length > 2:
	    Do a. with the most recent word only
  C. Go through list again
      a. Unique prefix is hashmap[word[0]].hashmap[word[1]]... until that key no longer exists
      

  Runtime:
    B. gives O(n) time
    B.b. is O(n * m)

  Storage: Kinda large

  I don't like this implementation simply because it's complicated and a lot of
  data structures are used for small reasons


3. Mapping every word (n * m)
  A. Create trie:
      a. Node contains hashmap[letter][Node],  # of words in this branch
  B. Go through list
      a. Loop through characters in Node
      b. Go to/Create hashmap[word[i]] until you reach the end
          i. Increment # of words each time you go through a node
  C. Go through list again
      a. For each word, go through trie until # of words = 1. That's your prefix


  Runtime: O(nm)
  Storage: O(nm)


Time to think: ~15 min?
Time to code: ~20 min