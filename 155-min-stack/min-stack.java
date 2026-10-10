class MinStack {
    Stack<Integer> st ;
    Stack<Integer> Minst ;
    public MinStack() {
        st = new Stack<>();
        Minst = new Stack<>();
    }
    
    public void push(int value) {
        st.push(value);
        if(Minst.size() == 0 || value<Minst.peek()) Minst.push(value);
        else Minst.push(Minst.peek());
    }
    
    public void pop() {
        st.pop();
        Minst.pop();
    
    }
    
    public int top() {
       return st.peek();
    }
    
    public int getMin() {
        return Minst.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */