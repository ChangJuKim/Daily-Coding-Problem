Good morning! Here's your coding interview problem for today.

This problem was asked by Facebook.

Write a function that rotates a list by k elements. For example, [1, 2, 3, 4, 5, 6] rotated by two becomes [3, 4, 5, 6, 1, 2]. Try solving this without creating a copy of the list. How many swap or move operations do you need?

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Well if you create a copy of the list, you just have to do
NewIndex = (OriginalIndex + K) mod Ary.length

and move everything over.

~~~~~~~~~

Idea 1:
  Let back = 0, front = ary[k].
  ary[k] = ary[0]
  Repeat k/n times if k and n have common factors, ? times if k%n != 0
    back += k
    ary[back+k] = front
  If k and n have no common factors, repeat above loop k/n times but with offset by 1 each time.

  Runtime: O(n) + time to calculate common factors
  Storage: O(1)... uh I guess storage = # common prime factors

Idea 2: Just swap each element by the next one k times
  Runtime: O(kn)
  Storage: O(1)


Alright idea 1
I realized the rotation goes backwards.

Time to think: ~6 min?
Time to code: 36 min :<


~~~~~~~~~~~`

Definitely have a ton of off by 1 errors
Also I looked it up and man I
  1. Wasn't sure exactly what I needed (turns out I only needed GCF/GCD)
  2. Forgot GCD equation (GCD(a, b) == GCD(b, a%b) and recurse until b == 0)

But otherwise my code seems solid and I think is optimal solution.
Am satisfied with it.