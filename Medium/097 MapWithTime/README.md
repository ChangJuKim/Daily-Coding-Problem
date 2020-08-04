Good morning! Here's your coding interview problem for today.

This problem was asked by Stripe.

Write a map implementation with a get function that lets you retrieve the value of a key at a particular time.

It should contain the following methods:

set(key, value, time): sets key to value for t = time.
get(key, time): gets the key at t = time.

The map should work like this. If we set a key at a particular time, it will maintain that value forever or until it gets set at a later time. In other words, when we get a key at a time, it should return the value that was set for that key set at the most recent time.


Consider the following examples:

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

d.set(1, 1, 0) # set key 1 to value 1 at time 0
d.set(1, 2, 2) # set key 1 to value 2 at time 2
d.get(1, 1) # get key 1 at time 1 should be 1
d.get(1, 3) # get key 1 at time 3 should be 2

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

d.set(1, 1, 5) # set key 1 to value 1 at time 5
d.get(1, 0) # get key 1 at time 0 should be null
d.get(1, 10) # get key 1 at time 10 should be 1

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

d.set(1, 1, 0) # set key 1 to value 1 at time 0
d.set(1, 2, 0) # set key 1 to value 2 at time 0
d.get(1, 0) # get key 1 at time 0 should be 2


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Thoughts:

Sort commands by time. O(nlogn).
...wait this is asking to implement a map. Not to handle the commands.
Scrap what I said.

One important distinction (that I didn't make at first) is that it's NOT a hashmap.
We can have an array to represent the keys. This has a problem if someone does something
like d.set(100000, 1, 0). Hopefully they don't.
...Maybe I can hash that...

We'd probably want a linked list to represent each time a value changes...
  That way if someone sets at a large time, it's still a fast operation.


Oh

Okay here we go

Key: Use a hashmap of <key, LinkedList<time-value pair> >

Runtime:
  Set O(# commands):
    Setting key = O(1)
    Setting value/time = O(# elements in key). Worst case, O(# set functions)
  Get O(# commands):
    Getting key = O(1)
    Getting value at time = O(# elements in key). Worst case, O(# set functions)

Hm... ideally runtime would be shorter...


~~~~~~~~~~~~~~~~~~~~~~~~~

Notes:
   Would be better to have a binary search tree instead of linked list
     Get would be significantly more complex though
   I suppose a linked list is the same thing as a tree that goes one direction
   

This was a nice refresher. It's been a while since I implemented an object/class.
It was also pretty nice to practice generics and nested classes.
I'm sure I didn't nail the nested classes part but the thought is still there.
So ultimately: good practice on object oriented programming, nested classes, generics



Time to think: Idk... 15 min?
Time to code: ...about 25 min?