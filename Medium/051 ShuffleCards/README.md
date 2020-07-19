Good morning! Here's your coding interview problem for today.

This problem was asked by Facebook.

Given a function that generates perfectly random numbers between 1 and k (inclusive), where k is an input, write a function that shuffles a deck of cards represented as an array using only swaps.

It should run in O(N) time.

Hint: Make sure each one of the 52! permutations of the deck is equally likely.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`
Time: 35 min

I'm actually not sure how to approach this

Thoughts/etc:
  1. Wait... I can uh... okay here.

  Idea 1:
    1. Start at index i = 0. The cards behind i are sorted
    2. At index i, create a random number between i and 51
    3. Swap that card with the one at i.
    4. Increment i.

  That's definitely O(N) time.
  Took 4 min to think of.


  Took 11 min to code



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

By the way, Brandon did the same thing except he chooses a random number between 0 to 51
instead of i to 51.
This doens't create a random shuffle because
He has 52^52 possibilities and he's trying to simulate 52! possiblities which is
impossible because 52^52 doesn't divide by 52!. (For instance, there are prime numbers there
that are not factors of 52).
Does anyone know what his algorithm actually simulates??

Also, if you are still unsure I wrote out all the results of his code for an array size 3.
You get:
[0, 1, 2] = 4 outcomes
[0, 2, 1] = 5 outcomes
[1, 0, 2] = 5 outcomes
[1, 2, 0] = 5 outcomes
[2, 0, 1] = 4 outcomes
[2, 1, 0] = 4 outcomes
Which is not evenly random... but what does it simulate??????
Agh I don't know.


Also, proof of my solution:
Index 0 has n outcomes. It is uniformly randomly selected.
Index 1 has n-1 outcomes. It is uniformly randomly selected from 1 - n.
Index 2 has n-2 outcomes. It is uniformly randomly selected from 2 - n.
...
Index n-1 has n-(n-1) = 1 outcome. It is unformly randomly selected from n-n

For index i, we know 0...i is randomly selected.
Thus for index i+1, we can shrink the array to i+1, ... ,n.

Uh... That's not a solid proof but that's on the right track



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

OKAY
So I wrote brandon's code out
Like, I literally went through all the outcomes and put that into an array
And I have a bug
But this is exciting
Because my bug makes it so that all the results are how you want it, so that
you get a good shuffling
Basically my bug converted brandon's code to good code!!!!!

So I'm ignoring some cases, and if Brandon does the same then he will have good
code!!!

So if we want to find why brandon's code doesn't work, we can see what my bug is!!
Alright code is in a new file: Shuffle_Brandon_Bugged
And correct version is in Shuffle_Brandon
Didn't actually fix bug yet -- I'll stop for tonight