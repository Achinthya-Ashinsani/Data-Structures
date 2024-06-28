package DataStructure;

class ArrayQueue {
    private int front, rear, size;
    private int capacity;
    private int[] queue;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        front = this.size = 0;
        rear = capacity - 1;
        queue = new int[this.capacity];
    }

    // Method to add an item to the queue. It changes rear and size
    void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        this.rear = (this.rear + 1) % this.capacity;
        this.queue[this.rear] = item;
        this.size = this.size + 1;
        System.out.println(item + " enqueued to queue");
    }

    // Method to remove an item from queue. It changes front and size
    int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        int item = this.queue[this.front];
        this.front = (this.front + 1) % this.capacity;
        this.size = this.size - 1;
        return item;
    }

    // Method to get front of queue
    int front() {
        if (isEmpty())
            return Integer.MIN_VALUE;
        return this.queue[this.front];
    }

    // Method to get rear of queue
    int rear() {
        if (isFull())
            return Integer.MIN_VALUE;
        return this.queue[this.rear];
    }

    // Method to check if the queue is empty
    boolean isEmpty() {
        return (this.size == 0);
    }

    // Method to check if the queue is full
    boolean isFull() {
        return (this.size == this.capacity);
    }
    
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);

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
