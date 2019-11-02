class MyQueue {
    public Stack<Integer> queue;
    public Stack<Integer> stack;
    /** Initialize your data structure here. */
    public MyQueue() {
        this.queue = new Stack<>();
        this.stack = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        // this.stack.push(x);
        while (!this.queue.empty()) {
            this.stack.push(this.queue.pop());
        }
        this.stack.push(x);
        while (!this.stack.empty()) {
            this.queue.push(this.stack.pop());
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int ans = this.queue.pop();
        return ans;
    }
    
    /** Get the front element. */
    public int peek() {
        return this.queue.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return this.queue.empty();
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
