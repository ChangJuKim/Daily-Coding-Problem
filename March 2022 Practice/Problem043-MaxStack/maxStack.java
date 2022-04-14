public class maxStack {
    /*
    This problem was asked by Amazon.

    Implement a stack that has the following methods:

    push(val), which pushes an element onto the stack
    pop(), which pops off and returns the topmost element of the stack. If there are no elements in the stack, then it should throw an error or return null.
    max(), which returns the maximum value in the stack currently. If there are no elements in the stack, then it should throw an error or return null.
    Each method should run in constant time.
    
    -------------------------------------------------------

    Thoughts:
        the key to this problem is: max and constant time.
        constant time for max is interesting -- normally you'd just hold onto the max value, but what happens when you pop that value?
            We can have a heap... but push and pop will no longer be constant time. Also it's O(log(n)) time to push

        Solution:
            Linked list. Each node in the linked list will hold onto its maximum (at that time).
            This works because you're adding and removing values in a specific order.
                Therefore, if the maximum when you push N is A, it will be A again when you pop so that it's at the top again.

            5, 10, 7,  1,  2
            5, 10, 10, 10, 10
    */

    private listNode head;

    public maxStack() {
        head = null;
    }


    public void push(int value) {
        listNode current = head;
        if (head == null) {
            head = new listNode(value);
            return;
        }
        head.next = new listNode(value);
        head.next.prev = head;
        if (head.max < value) {
            head.next.max = value;
        } else {
            head.next.max = head.max;
        }
        head = head.next;
    }

    // Substituting -1 for throwing an error
    public int pop() {
        if (head == null) {
            return -1;
        }
        int returnValue = head.value;
        head = head.prev;
        if (head != null) {
            head.next = null;
        }
        return returnValue;
    }

    // Substituting -1 for throwing an error
    public int max() {
        if (head == null) {
            return -1;
        }
        return head.max;
    }

    public static void main(String[] args) {
        maxStack myStack = new maxStack();
        myStack.push(5);
        System.out.println("maxValue: " + myStack.max());

        myStack.push(10);
        System.out.println("maxValue: " + myStack.max());

        myStack.push(7);
        System.out.println("maxValue: " + myStack.max());

        myStack.push(1);
        System.out.println("maxValue: " + myStack.max());

        myStack.push(2);
        System.out.println("maxValue: " + myStack.max());

        System.out.println("pop: " + myStack.pop() + " -- maxValue: " + myStack.max());
        System.out.println("pop: " + myStack.pop() + " -- maxValue: " + myStack.max());
        System.out.println("pop: " + myStack.pop() + " -- maxValue: " + myStack.max());
        System.out.println("pop: " + myStack.pop() + " -- maxValue: " + myStack.max());
        System.out.println("pop: " + myStack.pop() + " -- maxValue: " + myStack.max());
        System.out.println("pop: " + myStack.pop() + " -- maxValue: " + myStack.max());
    }
}
