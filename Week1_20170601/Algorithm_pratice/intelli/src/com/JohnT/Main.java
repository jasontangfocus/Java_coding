package com.JohnT;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List nums = new ArrayList();
        nums.add(1);
        nums.add(2);
        hasCycle(nums);


    }

    public static boolean hasCycle(ListNode head) {
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
