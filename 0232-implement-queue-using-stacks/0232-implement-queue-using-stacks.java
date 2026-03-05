import java.util.Stack;

class MyQueue {

    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }
    
    // Push element x to the back of queue
    public void push(int x) {
        inStack.push(x);
    }
    
    // Removes the element from the front of queue and returns it
    public int pop() {
        moveIfNeeded();
        return outStack.pop();
    }
    
    // Get the front element
    public int peek() {
        moveIfNeeded();
        return outStack.peek();
    }
    
    // Returns true if the queue is empty
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
    
    // Transfer elements only when outStack is empty
    private void moveIfNeeded() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }
}