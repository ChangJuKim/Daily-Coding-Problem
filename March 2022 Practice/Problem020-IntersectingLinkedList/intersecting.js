//import { linkedListNode } from './node';

/*
Good morning! Here's your coding interview problem for today.

This problem was asked by Google.

Given two singly linked lists that intersect at some point, find the intersecting node. The lists are non-cyclical.

For example, given A = 3 -> 7 -> 8 -> 10 and B = 99 -> 1 -> 8 -> 10, return the node with value 8.

In this example, assume nodes with the same value are the exact same node objects.

Do this in O(M + N) time (where M and N are the lengths of the lists) and constant space.
*/

// Idea: If we know length of both linked lists (l and m, l < m) then we can have two pointers, one for each linked list
//       that starts l away from the start. At some point, they will find the same node.

// Solution 1: Run through both linked lists once to get the length. Then do above.

// Solution 2: Create two linked lists: Z = A -> B and Y = B -> A.

// e.g. 
// A = 1 -> 2 -> 3 -> 10 -> 11 -> 12
// B = 5 -> 10 -> 11 -> 12

// Z = 1 -> 2  ->  3 -> 10 -> 11 -> 12 -> 5 -> 10 -> 11 -> 12
// Y = 5 -> 10 -> 11 -> 12 -> 1  -> 2  -> 3 -> 10 -> 11 -> 12


class linkedListNode {
    constructor(number) {
        this.value = number;
        this.next = null;
    }

    add(num) {
        if (this.next === null) {
            this.next = new linkedListNode(num);
        } else {
            let current = this.next;
            while (current.next !== null) {
                current = current.next;
            }
            current.next = new linkedListNode(num);
        }
    }
}

// Need to add a check if it looped already ;; if they don't intersect
function findIntersection(node_a, node_b) {
    let current_a = node_a;
    let current_b = node_b;
    while (current_a.value != current_b.value) {
        // Iterate next for a
        if (current_a.next === null) {
            current_a = node_b;
        } else {
            current_a = current_a.next;
        }

        // Iterate next for b
        if (current_b.next === null) {
            current_b = node_a;
        } else {
            current_b = current_b.next;
        }
    }
    return current_a;
}

let a = new linkedListNode(3);
a.add(7);
a.add(8);
a.add(10);

let b = new linkedListNode(99);
b.add(1);
b.add(8);
b.add(10);



let intersection = findIntersection(a, b);
console.log(intersection.value);

let A = new linkedListNode(1);
A.add(2);
A.add(3);
A.add(-20);
A.add(10);
A.add(11);
A.add(12);

let B = new linkedListNode(5);
B.add(100);
B.add(10);
B.add(11);
B.add(12);
intersection = findIntersection(A, B);
console.log(intersection.value);