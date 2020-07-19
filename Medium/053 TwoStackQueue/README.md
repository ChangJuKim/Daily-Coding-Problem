Good morning! Here's your coding interview problem for today.

This problem was asked by Apple.

Implement a queue using two stacks. Recall that a queue is a FIFO (first-in, first-out) data structure with the following methods: enqueue, which inserts an element into the queue, and dequeue, which removes it.


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Not implementing (for now) because Brandon and Karey went ahead and finished but I didn't.

Idea:
  Enqueue: insert into first stack
  Dequeue: Pop from second stack. If second stack is empty, pop from first stack and push to second until first is empty