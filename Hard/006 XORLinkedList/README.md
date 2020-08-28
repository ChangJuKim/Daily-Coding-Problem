Good morning! Here's your coding interview problem for today.

This problem was asked by Google.

An XOR linked list is a more memory efficient doubly linked list. Instead of each node holding next and prev fields, it holds a field named both, which is an XOR of the next node and the previous node. Implement an XOR linked list; it has an add(element) which adds the element to the end, and a get(index) which returns the node at index.

If using a language that has no pointers (such as Python), you can assume you have access to get_pointer and dereference_pointer functions that converts between nodes and memory addresses.

~~~~~~~~~~~~~~~~~~~~~~~

This isn't much of a problem imo.
The main problem is how you implement get(index)
In other words, how you implement iterating through the list.

(Karey's idea):
  To get the next node from current:
    When you start at the head, current = head; previous = null
    next = previous XOR current.XORNode
    make previous = current, current = next.
    Continue


You can optimize my code by holding a last pointer. And a length int.
But if you're stingy enough on memory to only have a single pointer for a doubly linked
  list then perhaps you don't want to?

