Good morning! Here's your coding interview problem for today.

Given a real number n, find the square root of n. For example, given n = 9, return 3.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Well...

I remember something like

loop:
  if a^2 = n, return a
  else a = a/2 + something + something something

Some kind of formula
That exists on wikipedia


Anyways
1. Check negative numbers, 0 and 1

Idea 1 (left/right bounds):
     Left = n/4. Loop: If left^2 > n, left = left/2
     Right = left * 2
     Loop:
       If left^2 == n: return left
       Middle = (left + right) / 2.
       If middle^2 > n, right = middle. Else left = middle


Idea 2 (Get closer):
     Current = n/2 or something, idk
     Loop:
       If current^2 = n, return current
       current^2 = squared.
       current = current + (n - squared)/2


Uh... idea 2 seems cleaner so lets do that.
Note that dividing by 2 or something can change to make it more efficient

Time to think: 10 min

Time to code: 5 min

~~~~~~~~~~~~~~~~

