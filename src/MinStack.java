/**
 * 155. Min Stack
 */
public class MinStack {

    Stack<Integer> store;
    Stack<Integer> min;

    public MinStack() {
        store = new Stack<Integer>();
        min = new Stack<Integer>();
    }
    
    public void push(int val) {
        store.push(val);
        if (!min.isEmpty()) {
            int currentMin = min.peek();
            if (val <= currentMin) min.push(val);
        } else {
            min.push(val);
        }
    }
    
    public void pop() {
        int val = store.peek();
        store.pop();
        if (val == min.peek()) min.pop();
    }
    
    public int top() {
        return store.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}