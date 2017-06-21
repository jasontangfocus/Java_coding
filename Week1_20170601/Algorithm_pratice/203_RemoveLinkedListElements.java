/*
Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5

Credits:
Special thanks to @mithmatt for adding this problem and creating all test cases.
*/

public class 203_RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
		//corner case
		if (head == null) {
			return null;	
		}

		//normal case, introduce using dummy node
		ListNode dummmy = new ListNode(-1);
		dummmy.next = head;

		ListNode cur = dummmy;

		while(cur != null && cur.next != null) {
			if (cur.next.val == val) {
				//if the next value behind the cur val was the value to delete.
				//we just need to link the cur.next.next to the cur.next to avoid 
				//the cur.next value, which in other way can be treated as deleted
				cur.next = cur.next.next;
			} else {
				cur = cur.next;
			}
		}
		return dummmy.next;
	}
}