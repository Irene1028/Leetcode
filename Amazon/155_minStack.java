class MinStack {
    PriorityQueue<Integer> minQueue;
    Stack<Integer> minStack;
    /** initialize your data structure here. */
    /** Keep the insertion order, and can find min **/
    public MinStack() {
        this.minStack = new Stack<>();
        this.minQueue = new PriorityQueue<>();
    }
    
    public void push(int x) {
        minStack.push(x);
        minQueue.offer(x);
    }
    
    public void pop() {
        int out = minStack.pop();
        minQueue.remove(out);
    }
    
    public int top() {
        return minStack.peek();
    }
    
    public int getMin() {
        return minQueue.peek();
    }
}
/*
Time O(1)
Space O(2n)
*/
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
 
 
/* Min Stack */
class MinStack {
    Stack<Integer> minStack;
    int curMin = Integer.MAX_VALUE;
    /** initialize your data structure here. */
    /** One Stack Solution **/
    public MinStack() {
        this.minStack = new Stack<>();
    }
    
    public void push(int x) {
        if (x <= curMin) {
            minStack.push(curMin);
            curMin = x;
        }
        minStack.push(x);
    }
    
    public void pop() {
        if (minStack.pop() == curMin) {
            curMin = minStack.pop();
        }
    }
    
    public int top() {
        return minStack.peek();
    }
    
    public int getMin() {
        return curMin;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
