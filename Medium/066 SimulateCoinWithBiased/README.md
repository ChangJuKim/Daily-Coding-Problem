Good morning! Here's your coding interview problem for today.

This problem was asked by Square.

Assume you have access to a function toss_biased() which returns 0 or 1 with a probability that's not 50-50 (but also not 0-100 or 100-0). You do not know the bias of the coin.

Write a function to simulate an unbiased coin toss.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

This reminds me of a riddle
I have some time so I'll write it out
It's the "Can you solve the dark coin riddle?" on Youtube:
  You have 100 coins
  You know there are exactly 20 heads right now
  But the lights turn off, sense of touch is off, etc

  ...uh
  Separate them into 2 piles so that the number of heads is equal in each pile
  You can flip any coin so that heads becomes tails and tails become heads
  Yeah.


Anyways
Well... solution is to use two flips to make it equivalent.
Basically you can't make a mapping of

Biased Heads => Unbiased Heads,
Biased Tails => Unbiased Tails

Instead you gotta do something like
Biased Heads + Biased Tails = Unbiased Heads.

Regardles, I know the solution

Solution:
  Flip twice. 4 outcomes
    H-H => Reflip
    T-T => Reflip
    H-T => Unbiased Heads
    T-H => Unbiased Tails

Solution explained:
  If flipping twice is a square, then it's something like this

       H        T
   _________________
   |	      |    |
   |          |    |
 H |	HH    | HT |
   |	      |    |
   |	      |    |
   |__________|____|
 T |	TH    | TT |
   |__________|____|

   So you can never do anything with a HH, TT result because you don't know
   how large or small their area is. You do know however that no matter how
   biased, TH and HT have equal probability of occuring






   Finished thinking/explaining in 13 min
   Finished coding in 2 min
     ...well there wasn't much to code
