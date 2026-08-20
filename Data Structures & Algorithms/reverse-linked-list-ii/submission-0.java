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

    public ListNode reverseBetween(ListNode head, int left, int right) {

        // If there is no need to reverse
        if (head == null || left == right) {
            return head;
        }

        // Dummy node handles the case where left = 1
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Move prev to the node just before 'left'
        ListNode prev = dummy;

        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // 'current' points to the first node
        // that needs to be reversed
        ListNode current = prev.next;

        // Reverse the sublist
        // We repeatedly take the node after current
        // and move it to the front of the sublist.
        for (int i = 0; i < right - left; i++) {

            // Node that we want to move
            ListNode next = current.next;

            // Remove 'next' from its current position
            current.next = next.next;

            // Insert 'next' immediately after prev
            next.next = prev.next;
            prev.next = next;
        }

        // Dummy's next is the new head
        return dummy.next;
    }
}