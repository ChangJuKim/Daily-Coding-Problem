Good morning! Here's your coding interview problem for today.

This problem was asked by Square.

Given a string and a set of characters, return the shortest substring containing all the characters in the set.

For example, given the string "figehaeci" and the set of characters {a, e, i}, you should return "aeci".

If there is no substring containing all the characters in the set, return null.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Thoughts

1. Well it's a set of character so no duplicates
2. Probably means set size < 1000 or something (including weird characters) which is nice
3. Can just make it a hashset for constant lookup. That's nice.
4. Will want to loop through the string...


Idea 1 (Two pointers):
  1. Left and right pointer start at 0.
  2. Increment left (ensure right >= left) if current char isn't in set
  3. If left is in set, increment right until
     A. All characters in set
          Keep track of substring and compare with shortest so far
	  Move left pointer till you reach a character in set.
     B. Right character equals left character
          Move left pointer till you reach a character in set.
  4.  Check if current contains all characters. If so, return min(this, shortest)
      If not, return shortest

  Runtime: O(stringLength)

You have to loop through all elements in string so I think a O(N) runtime is pretty good

Storage: For constant lookup of how many char elements we have, we should have a HashMap
         of <Char, Int>. Int represents how many of that char we have.
	 We should also have an int representing how many chars are > 0. That way we don't
	 need to loop through HashMap each time we want see if we have all characters.
	 O(charLength)


Time to think: 11 min
Time to code: 24 min


I don't think I organized my code well
I wanted to try using global variables but I didn't use it properly

...so many continue cases...

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

More thoughts

Okay I missed some places to decrement and increment stuff and this is seriously complicated
Half of me wonders if it's cause I organized it poorly, the other half just thinks it's
annoying to keep track of.

I'm stopping for now but I stopped mid-edit so my code is broken

Time to edit code: 20 min (and I broke it)