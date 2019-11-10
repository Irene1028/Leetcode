class MinStack {
public:
    /** initialize your data structure here. */
    /* lets use c++ this time */
    
    std::stack<int> min_stack;
    int min = INT_MAX;
    MinStack() {
        std::cout << "I m creating a Min Stack." << std::endl;
    }
    
    void push(int x) {
        if (x <= min) {
            min_stack.push(min);
            min = x;
        }
        min_stack.push(x);
    }
    
    void pop() {
        if (min_stack.top() == min) {
            min_stack.pop();
            min = min_stack.top();
        }
        min_stack.pop();
    }
    
    int top() {
        return min_stack.top();
    }
    
    int getMin() {
        return min;
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(x);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */
