/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
*/

public class MinStack155 {

	Deque<Integer> pro;
	Deque<Integer> min;

	/** initialize your data structure here. */
    public MinStack() {
    	//Inilization deque
        pro = new ArrayDeque<>();
        min = new ArrayDeque<>();
    }
    
    public void push(int x) {
        pro.addLast(x);
        if (min.isEmpty()) {
        	min.addLast(x);
        } else {
        	min.addLast(min.peekLast() < x ? min.peekLast() : x);
        }
    }
    
    public void pop() {
        pro.removeLast();
        min.removeLast();
    }
    
    public int top() {
        return pro.peekLast();
    }
    
    public int getMin() {
        return min.peekLast();
    }
}