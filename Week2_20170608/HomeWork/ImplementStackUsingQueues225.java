/*
Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
Notes:
You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
*/

public class ImplementStackUsingQueues225 {

     Deque<Integer> myQueue;
    
    /** Initialize your data structure here. */
    public ImplementStackUsingQueues225() {
        myQueue = new ArrayDeque<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        myQueue.addFirst(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (myQueue.peekFirst() == null) {
            myQueue.pollFirst();
        }
        return myQueue.pop();
    }
    
    /** Get the top element. */
    public int top() {
        return myQueue.getFirst();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return myQueue.isEmpty();
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