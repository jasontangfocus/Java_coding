/*
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
*/

public class MergeTwoSortedLists21 {
	public ListNode mergeTwoLists(ListNode l1 ,ListNode l2) {
		//special situation
		if (l1 == null && l2 != null) {
			return l2;
		} else if (l2 == null && l1 != null) {
			return l1;
		} else if (l1 == null && l2 == null) {
			return null;
		}

		//normal consideration
		if (l1.val < l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
	}}