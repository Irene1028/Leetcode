class MaxStack {
    Stack<Integer> maxStack;
    Stack<Integer> tmpStack;
    int max = Integer.MIN_VALUE;
    /** initialize your data structure here. */
    public MaxStack() {
        maxStack = new Stack<>();
        tmpStack = new Stack<>();
    }

    public void push(int x) {
        if (x >= max) {
            maxStack.push(max);
            max = x;
        }
        maxStack.push(x);
    }

    public int pop() {
        int ret = maxStack.peek();
        if (maxStack.pop() == max) {
            max = maxStack.pop();
        }
        System.out.println("pop ret and max");
        System.out.println(ret);
        System.out.println(max);
        return ret;
    }

    public int top() {

        System.out.println(maxStack.peek());
        return maxStack.peek();
    }

    public int peekMax() {
        System.out.println(max);
        return max;
    }

    public int popMax() {
        System.out.println(max);
        while (maxStack.peek() != max) {
            tmpStack.push(maxStack.pop());
        }
        int ret = maxStack.pop();
        max = maxStack.pop();
        System.out.print("new Max = ");
        System.out.println(max);
        while (!tmpStack.isEmpty()) {
            // if (tmpStack.peek() > max) {
            //     max = tmpStack.pop();
            // }
            this.push(tmpStack.pop());
            if (maxStack.peek() > max) {
                max = maxStack.peek();
            }
        }
        System.out.print("real Max = ");
        System.out.println(max);
        return ret;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
