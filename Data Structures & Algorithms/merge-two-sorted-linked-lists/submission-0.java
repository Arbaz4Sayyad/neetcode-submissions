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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // Dummy node makes it easier to build the result list
        ListNode dummy = new ListNode(-1);

        // 'current' points to the last node in the merged list
        ListNode current = dummy;

        // Compare nodes from both lists
        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {
                // Take node from list1
                current.next = list1;
                list1 = list1.next;
            } else {
                // Take node from list2
                current.next = list2;
                list2 = list2.next;
            }

            // Move current forward
            current = current.next;
        }

        // One list may still have remaining nodes
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        // Dummy's next is the actual head
        return dummy.next;
    }
}