Good morning! Here's your coding interview problem for today.

This problem was asked by Facebook.

Given a stream of elements too large to store in memory, pick a random element from the stream with uniform probability.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Let the stream be represented as an array of elements (ary) for convenience

Let result = ary[0]
for (int i):
    ary[i] -> result with probability 1/i

At the end of stream, return result
