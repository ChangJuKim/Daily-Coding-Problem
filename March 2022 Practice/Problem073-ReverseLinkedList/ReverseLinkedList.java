/*
Given the head of a singly linked list, reverse it in-place.

---------------------------------------
Not too bad. Go through the linked list
    At node N, hold onto N+1. Hold onto N+2 while you're at it.
    N+1.next = N
    N+1 = N+2, N = N+1.

    If N+2 is null, then you're done.

---------------------------------------
Finished in 22 minutes. After coding and testing, I realized that there is no need to create a Node inner class.
In fact that kind of defeats the purpose. After all this function is supposed to reverse a Linked List.
Not reverse ONLY MY linked list.

Also the generic type doesn't even make sense.
So A for the algorithm, F for the implementation

*/


 public class ReverseLinkedList {
    private static class Node<T> {
        public Node<T> next;
        public T value;

        public Node(T _value) {
            value = _value;
        }

        public void print() {
            Node<T> n = this;
            System.out.print("[");
            if (n != null) {
                System.out.print(n.value);
                n = n.next;
            }
            while (n != null) {
                System.out.print(", " + n.value);
                n = n.next;
            }
            System.out.println("]");
        }
    }
    
    public static Node<Integer> reverse(Node<Integer> n) {
        if (n == null) return null;
        Node<Integer> n1 = n.next; // n+1
        if (n1 == null) return n;
        Node<Integer> n2 = n1.next; // n+2
        
        n.next = null;
        while (n2 != null) {
            n1.next = n;
            n = n1;
            n1 = n2;
            n2 = n2.next;
        }
        n1.next = n;
        return n1;
    }

    public static void main(String[] args) {
        Node<Integer> root = new Node<Integer>(1);
        Node<Integer> current = root;
        for (int i = 2; i < 10; i++) {
            current.next = new Node<Integer>(i);
            current = current.next;
        }
        root.print();
        root = reverse(root); // Have to change root now that original root is at the end of linked list
        root.print();

        Node<Integer> one = new Node<Integer>(100);
        one.print();
        one = reverse(one);
        one.print();

        Node<Integer> two = new Node<Integer>(20);
        two.next = new Node<Integer>(30);
        two.print();
        two = reverse(two);
        two.print();

        Node<Integer> three = new Node<Integer>(-3);
        three.next = new Node<Integer>(-4);
        three.next.next = new Node<Integer>(-5);
        three.print();
        three = reverse(three);
        three.print();

        Node<Integer> four = new Node<Integer>(2);
        four.next = new Node<Integer>(1);
        four.next.next = new Node<Integer>(0);
        four.next.next.next = new Node<Integer>(-1);
        four.print();
        four = reverse(four);
        four.print();

    }

}
