/*
Given the root of a binary tree, return a deepest node. For example, in the following tree, return d.

    a
   / \
  b   c
 /
d

-------------------------------------
Initial thoughts:
    If it's in an array form then we can just loop from the back until we find a node.
        Though potentially that would be very expensive as the back 90% of the array maybe empty
    Alternately, we can keep jumping in halves -- if it's a node then jump to the back half of the array. Otherwise, the front half 
        This will have a faster consistent runtime of O(log(N))

    Also nodes in the very back may be inactive -- we deleted a node in spot N, and simply decided that
        nodes in 2N and 2N+1 (and thier children) are all considered deleted too.
    In that case, this array algorithm would not be effective.

    So other than array method, only way I can think of is to just go through the entire tree.
    I've heard that recursion can be more expensive than iteration... so as an added challenge I will be trying to do this iteratively.
        To do this iteratively... we can either use a DFS or a BFS. But in either case you're looping through the entire tree so I guess
        it doesn't matter which.
            BFS requires a queue... and I'm honestly not as familiar with a BFS than a DFS so DFS is what I will be implmeneting.
            On second thought, DFS is much easier to do with recursion. So BFS it is.

    -----------------------------------------------------

    Looked it up and turns out BFS has a space complexity of O(n).
    I should've seen that coming. So it'd ideally be best to do an iterative approach of a DFS. Somehow.
 */

import java.util.LinkedList;
import java.util.Queue;


public class DeepestNode {
    private static class Node {
        public Node left;
        public Node right;
        private int value;

        public Node(int _value) {
            left = right = null;
            value = _value;
        }
    }

    // Breadth-first search
    // If multiple nodes in deepest, returns the leftmost one
    public static Node deepestNode(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        // return null if tree is empty
        Node deepest = null;
        // # nodes on this level and next level
        int remainingNodes = 1;
        int nextRemainingNodes = 0;
        // Not necessary... but still nice to track
        int depth = 0;
        while (queue.peek() != null) {
            deepest = queue.poll();
            remainingNodes -= 1;
            if (deepest.right != null) {
                queue.add(deepest.right);
                nextRemainingNodes += 1;
            }
            if (deepest.left != null) {
                queue.add(deepest.left);
                nextRemainingNodes += 1;
            }
            if (remainingNodes == 0) {
                remainingNodes = nextRemainingNodes;
                depth += 1;
            }
        }

        return deepest;
    }

    public static void main(String[] args) {
        Node root = new Node(0);
        root.left = new Node(1);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.left.right = new Node(4);
        root.left.left.left = new Node(5);
        root.right.right = new Node(-1);
        root.right.right.right = new Node(-2);
        System.out.println("Deepest node is: " + deepestNode(root).value);
    }
}
