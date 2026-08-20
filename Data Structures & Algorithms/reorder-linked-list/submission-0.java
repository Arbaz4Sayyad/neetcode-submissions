/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */


class Solution {

    public void reorderList(ListNode head) {

        // Edge cases
        if (head == null || head.next == null) {
            return;
        }

        // ------------------------------------------------
        // STEP 1: Find the middle of the linked list
        // ------------------------------------------------

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 'slow' is at the middle
        // Example:
        // 1 → 2 → 3 → 4 → 5
        //         slow
        

        // ------------------------------------------------
        // STEP 2: Reverse the second half
        // ------------------------------------------------

        ListNode second = slow.next;

        // Break the list into two halves
        slow.next = null;

        // Reverse second half
        ListNode prev = null;

        while (second != null) {

            ListNode next = second.next;

            second.next = prev;

            prev = second;
            second = next;
        }

        // 'prev' is the head of reversed second half
        // Example:
        // 1 → 2
        // 5 → 4 → 3
        second = prev;


        // ------------------------------------------------
        // STEP 3: Merge both halves alternately
        // ------------------------------------------------

        ListNode first = head;

        while (second != null) {

            // Save next nodes before changing links
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;

            // Connect first node to second node
            first.next = second;

            // Connect second node to next first node
            second.next = firstNext;

            // Move both pointers forward
            first = firstNext;
            second = secondNext;
        }
    }
}
