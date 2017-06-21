/*
Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// idea is we use both fast and slow pointer to track the ListNode

public class 141_LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        //Corner Case
        if (head == null || head.next == null) {
        	return false;
        }

        //normal case
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null) {
        	if (slow == fast) {
        		return true;
        	}
        	slow = slow.next;
        	fast = fast.next.next;
        }

        return false;
    }
}