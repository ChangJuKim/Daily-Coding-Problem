class linkedListNode {
    constructor(number) {
        this.value = number;
        this.next = null;
    }

    add(num) {
        if (this.next === null) {
            this.next = new linkedListNode(num);
        } else {
            current = this.next;
            while (current.next !== null) {
                current = current.next;
            }
            current.next = new linkedListNode(num);
        }
    }
}