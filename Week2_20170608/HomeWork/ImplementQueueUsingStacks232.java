/*
Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
Notes:
You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
*/

/*
		  head							tail
			|_ _ _ _ _ _ _ _ _ _ _ _ _ _ _|
 		pop/push/remove

 stack ----- Deque

 push()		addFirst()
 pop()		removeFirst()
 peek()		peekFirst()									 
*/

public class ImplementQueueUsingStacks232 {

	Deque<Integer> myQueue;
    
    /** Initialize your data structure here. */
    public ImplementQueueUsingStacks232() {
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
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */