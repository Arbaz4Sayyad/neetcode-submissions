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
    public ListNode reverseList(ListNode head) {
        // ListNode prev = null;
        // ListNode curr = head;

        // while(curr != null){
        //     ListNode forward = curr.next;

        //     curr.next = prev;
        //     prev = curr;
        //     curr = forward;
        // }
        // return prev;
        
        return reverseListHelper(null, head);
    }

    public ListNode reverseListHelper(ListNode prev, ListNode curr){
        // Base case
        if (curr == null) {
            return prev;
        }

        // Save next node before changing curr.next
        ListNode forward = curr.next;

        // Reverse the link
        curr.next = prev;

        // Move pointers forward
        prev = curr;
        curr = forward;

        // Recursive call
        return reverseListHelper(prev, curr);

    }
}