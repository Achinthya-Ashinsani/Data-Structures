package DataStructure;

class LinkedListStack {
    private Node top;
    private int size;

    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public LinkedListStack() {
        this.top = null;
        this.size = 0;
    }

    // Method to add an item to the stack (push operation)
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        size++;
        System.out.println(data + " pushed to stack");
    }

    // Method to remove an item from the stack (pop operation)
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return Integer.MIN_VALUE;
        }
        int poppedData = top.data;
        top = top.next;
        size--;
        return poppedData;
    }

    // Method to peek at the top item of the stack
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return Integer.MIN_VALUE;
        }
        return top.data;
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Method to get the size of the stack
    public int size() {
        return size;
    }

    // Method to print the stack elements
    public void printStack() {
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        System.out.println("Stack elements:");
        stack.printStack();  // Output: 50 40 30 20 10

        System.out.println(stack.pop() + " popped from stack");  // Output: 50 popped from stack
        System.out.println("Top element is " + stack.peek());    // Output: Top element is 40
        System.out.println("Stack size is " + stack.size());     // Output: Stack size is 4

        stack.printStack();  // Output: 40 30 20 10
    }
}


