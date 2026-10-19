
import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    Queue<Integer> q = new LinkedList<>();

    public MyStack() {
    }

    // public void push(int x) {  // O(1)
    //     q.add(x);
    // }

    // public int pop() {  // O(N)
    //     int n = q.size();
    //     for (int i = 1; i < n; i++) {
    //         q.add(q.remove());
    //     }
    //     return q.remove();
    // }

    // public int top() {      // O(N)
    //     int n = q.size();
    //     for (int i = 1; i < n; i++) {
    //         q.add(q.remove());
    //     }
    //     int topElement = q.peek();
    //     q.add(q.remove());
    //     return topElement;
    // }

    public void push(int x) { // O(n)
        // Add x to the front of the queue
        q.add(x);

        int n = q.size();

        for (int i = 1; i <= n - 1; i++) {
            q.add(q.remove());
        }
    }

    public int pop() { // O(1)
        return q.remove();
    }

    public int top() { // O(1)
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
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