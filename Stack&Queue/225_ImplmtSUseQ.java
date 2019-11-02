class MyStack {
    public Queue<Integer> stack;
    public Queue<Integer> tmp;
    int top;
    int size;
    /** Initialize your data structure here. */
    public MyStack() {
        this.stack = new LinkedList<>();
        this.tmp = new LinkedList<>();
        this.size = 0;
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        this.stack.offer(x);
        this.top = x;
        this.size++;
        // System.out.print("Push ");
        // System.out.println(this.top);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        //int ans = this.top;
        // size changes while popping, so use size to store org size;
        for (int i = 0; i < this.size - 1; i++) {
            int a = this.stack.poll();
            this.tmp.offer(a);
            this.top = a;
        }
        int ans = this.stack.poll();
        this.size--;
        while (!this.tmp.isEmpty()) {
            this.stack.offer(this.tmp.poll());
        }
        // System.out.print("Pop ");
        // System.out.println(ans);
        return ans;
    }
    
    /** Get the top element. */
    public int top() {
        return this.top;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return this.stack.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
