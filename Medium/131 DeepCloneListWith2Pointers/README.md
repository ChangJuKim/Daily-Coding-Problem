Good morning! Here's your coding interview problem for today.

This question was asked by Snapchat.

Given the head to a singly linked list, where each node also has a ¡°random¡± pointer that points to anywhere in the linked list, deep clone the list.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Idea 1 (iterate twice):
  1. Clone linked list. Ignore random pointer
  2. Loop through each node. Find where it points randomly, look for that node by looping again from start.

  Runtime: O(n^2) due to step 2.

Idea 2 (Hashset):
  1. Clone ignoring random pointer. Add each node to hashset.
  2. Loop through the linked list, and find each node's random pointer in hashset. Connect.
  
  Runtime: O(n). (Actually, O(n * lookup/storage time)).
  Storage: O(n).

That seems kinda cheap so imma look up another method in the 19 min i have left
(Time taken: 16 min)


Idea 3 (Hashmap):
  Something like go through nodes, put (random destination, random source) into hashmap.
  So basically put the nodes and their random pointer to the hashmap except reversed, the
    pointer destination is the key and the node is the value.
  Then loop through and use hashmap to see what points should be pointing to current, and
    connect them.
  Actually, it'd work the same if you stored the (node, pointer destination) as the key
    value pair anyways. Maybe.
  Actually maybe not. Regardless the hashset is better


...Thinking about it, if you put the copied node into hashset (as you should), then you
can't use the original linked list to find the copied node...

Well I can implement my own hash function lmao.

Alright implementing idea 2


~~~~~~~~~~~~~~~~~~

Thinking about it should've just used HashMap<Original node, Cloned node> lol
I ended up trying to implement my own hashset and that took up all my time

