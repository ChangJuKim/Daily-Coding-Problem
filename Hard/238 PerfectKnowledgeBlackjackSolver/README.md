Good morning! Here's your coding interview problem for today.

This problem was asked by MIT.

Blackjack is a two player card game whose rules are as follows:

The player and then the dealer are each given two cards.
The player can then "hit", or ask for arbitrarily many additional cards, so long as their total does not exceed 21.
The dealer must then hit if their total is 16 or lower, otherwise pass.
Finally, the two compare totals, and the one with the greatest sum not exceeding 21 is the winner.
For this problem, cards values are counted as follows: each card between 2 and 10 counts as their face value, face cards count as 10, and aces count as 1.

Given perfect knowledge of the sequence of cards in the deck, implement a blackjack solver that maximizes the player's score (that is, wins minus losses).

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

9/12/2020

I thought I'd start this cause I thought it was interesting. But the others don't want to
go through the effort so I'll be working on it slowly.

It's important to first set up the problem.

Questions:
  1. Given a deck of cards, how are they dealt?
  2. Are cards shuffled between rounds? Does it stop when you reach all 52 cards? Are they
       shuffled if there are insufficient cards, and does the player know what cards
       are next once shuffled?
  3. How many rounds are played?


9/13/2020
I assume that "maximizing player score" means that if I have something like:

Player: K, 6
Dealer: K, 5
Next cards: 4, 6 (You will lose this round no matter what)

So you would either hit or skip depending on what makes you win or lose more in
the future right?


I will assume that
  1. Game ends when you run out of cards (52). If a game cannot be concluded (e.g. dealer
  or player wants to hit but can't) then there is no win or loss for that round.
  2. Deck is not shuffled.
  3. Cards are dealt: Player, Dealer, Player, Dealer.
  4. Dealer will not hit if he has a greater total than the Player
  5. A draw will result in 0 points. Wins = +1, loss = -1

-------------------

Idea:
  1. Have a memo table of size 52.
      A. memo[i] represents MAX score possible if you start a round with the ith card
  2. memo[51], [50], [49] = 0 (since a proper round can't be dealt)
  3. Going backwards, analyze memo[i] and find all possible win/loss/draw combinations.
      A. For each k (0 <= k <= 7 or something idk),
          [win, tie, loss] = [+1, 0, -1].
	  Result = [win/tie/loss] + memo[i+k]
      B. memo[i] = max of all Result
  4. Return memo[0]


Time to think: ~40 min??
Time to code: ... uh... 30 min?


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

That was a lot to code
But it was an interesting problem

My runtime... runtime... uh...

Going through memo table: O(n)
Determining max score: around 5 I'd say
So ultimately.. an O(n) runtime??
That seems wrong cause it seems like it should be higher lol

Runtime: O(n)?
Storage: O(n)

Also I fixed compilation errors but I don't know if it actually works
Someone tell me if it does? :D

Or maybe I'll run this someone when I have more free