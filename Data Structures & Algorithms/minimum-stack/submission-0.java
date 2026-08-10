class MinStack {

    // Normal stack to store all the elements
    Stack<Integer> stack;

    // Min stack to keep track of the minimum element
    // seen so far
    Stack<Integer> minStack;

    // Constructor
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    // Push an element into the stack
    public void push(int val) {

        // Always push the value into the normal stack
        stack.push(val);

        // If minStack is empty OR the current value
        // is smaller than or equal to the current minimum,
        // push it into minStack as well.
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    // Remove the top element from the stack
    public void pop() {

        // If the element being removed is also the
        // current minimum, remove it from minStack.
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }

        // Remove the element from the normal stack
        stack.pop();
    }

    // Return the top element of the stack
    public int top() {
        return stack.peek();
    }

    // Return the minimum element in O(1) time
    public int getMin() {
        return minStack.peek();
    }
}
