package DataStructure;

class DoublyLinkedList {
    private Node head, tail;

    private class Node {
        int data;
        Node prev, next;

        Node(int data) {
            this.data = data;
            this.prev = this.next = null;
        }
    }

    // Method to add a node at the end of the list
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Method to remove a node from the list
    public void remove(int data) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.data == data) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
            return;
        }
        Node temp = head;
        while (temp != null && temp.data != data) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Node not found");
        } else {
            if (temp.next != null) {
                temp.next.prev = temp.prev;
            } else {
                tail = temp.prev;
            }
            if (temp.prev != null) {
                temp.prev.next = temp.next;
            }
        }
    }

    // Method to print the list from head to tail
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Method to print the list from tail to head
    public void printListReverse() {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.printList();         // Output: 1 2 3 4
        list.printListReverse();  // Output: 4 3 2 1
        list.remove(3);
        list.printList();         // Output: 1 2 4
        list.printListReverse();  // Output: 4 2 1
        list.remove(1);
        list.printList();         // Output: 2 4
        list.printListReverse();  // Output: 4 2
        list.remove(5);           // Output: Node not found
    }
}
