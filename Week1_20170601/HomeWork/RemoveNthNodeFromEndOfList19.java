/*
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
*/

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		this.val = x;
	}
}

public class RemoveNthNodeFromEndOfList19 {
	public ListNode removeNthNodeFromEnd(ListNode head, int n) {
		//special case
		if (head == null || head.next == null) {
			return null;
		}

		//normal case
		//remove the Nth from the end of the list, which means we can remove the (lenth - nth)th starting from the beginning
		
		// deque<> stack = new ArrayDeque<>();

		ListNode dummy = new ListNode(0);
		
		//pointer pointer
		ListNode slow = dummy;

		//fast pointer
		ListNode fast = dummy;

		dummy.next = head;

		while (n > 0) {
			fast = fast.next;
			n--;
		}

		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}

		slow.next = slow.next.next;
		return dummy.next;

	}
}