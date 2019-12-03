class MyQueue {
    public Stack<Integer> queue;
    public Stack<Integer> stack;
    public int top;
    /** Initialize your data structure here. */
    public MyQueue() {
        queue = new Stack<>();
        stack = new Stack<>();
        top = 0;
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if (stack.isEmpty()) top = x;
        stack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!stack.isEmpty()) {
            queue.push(stack.pop());
        }
        int ans = queue.pop();
        if (!queue.isEmpty()) top = queue.peek();
        else top = 0;
        // taking care of the situation that we peek after pop, check if queue is empty now
        while (!queue.isEmpty()) {
            stack.push(queue.pop());
        }
        return ans;
    }
    
    /** Get the front element. */
    public int peek() {
        return top;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
 
