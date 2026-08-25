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

    public ListNode reverseKGroup(ListNode head, int k) {

        // If list is empty or k = 1,
        // no reversal is required.
        if (head == null || k == 1) {
            return head;
        }

        // Dummy node helps us easily connect
        // previous group with current group.
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // groupPrev points to the node
        // before the current group.
        ListNode groupPrev = dummy;

        while (true) {

            // Find the kth node from groupPrev
            ListNode kth = getKthNode(groupPrev, k);

            // Fewer than k nodes remain.
            // Don't reverse them.
            if (kth == null) {
                break;
            }

            // First node of current group
            ListNode groupNext = kth.next;

            /*
             * Reverse current group.
             *
             * Example:
             *
             * 1 -> 2 -> 3 -> 4
             *
             * For k = 3:
             *
             * 1 -> 2 -> 3
             *
             * becomes
             *
             * 3 -> 2 -> 1
             */
            ListNode prev = groupNext;
            ListNode current = groupPrev.next;

            while (current != groupNext) {

                ListNode next = current.next;

                current.next = prev;

                prev = current;
                current = next;
            }

            // After reversal:
            //
            // groupPrev -> kth -> ... -> oldHead
            //
            // kth becomes the first node of reversed group.
            ListNode oldGroupHead = groupPrev.next;

            groupPrev.next = kth;

            // Move groupPrev to the end of
            // the reversed group.
            groupPrev = oldGroupHead;
        }

        return dummy.next;
    }

    /**
     * Returns the kth node after current.
     *
     * Example:
     *
     * current -> 1 -> 2 -> 3
     *
     * k = 3
     *
     * returns node 3.
     */
    private ListNode getKthNode(ListNode current, int k) {

        while (current != null && k > 0) {

            current = current.next;
            k--;
        }

        return current;
    }
}