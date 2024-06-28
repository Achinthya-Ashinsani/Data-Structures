package DataStructure;

class LinkedListQueue {
    private Node front, rear;
    private int size;

    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public LinkedListQueue() {
        this.front = this.rear = null;
        this.size = 0;
    }

    // Method to add an item to the queue
    void enqueue(int item) {
        Node newNode = new Node(item);
        if (this.rear == null) {
            this.front = this.rear = newNode;
            size++;
            System.out.println(item + " enqueued to queue");
            return;
        }
        this.rear.next = newNode;
        this.rear = newNode;
        size++;
        System.out.println(item + " enqueued to queue");
    }

    // Method to remove an item from queue
    int dequeue() {
        if (this.front == null) {
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        int item = this.front.data;
        this.front = this.front.next;
        if (this.front == null)
            this.rear = null;
        size--;
        return item;
    }

    // Method to get front of queue
    int front() {
        if (this.front == null)
            return Integer.MIN_VALUE;
        return this.front.data;
    }

    // Method to get rear of queue
    int rear() {
        if (this.rear == null)
            return Integer.MIN_VALUE;
        return this.rear.data;
    }

    // Method to check if the queue is empty
    boolean isEmpty() {
        return (this.size == 0);
    }

    // Method to get the size of the queue
    int size() {
        return this.size;
    }
    
    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        System.out.println(queue.dequeue() + " dequeued from queue");
        System.out.println("Front item is " + queue.front());
        System.out.println("Rear item is " + queue.rear());
    }
}
