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
    // public ListNode removeNthFromEnd(ListNode head, int n) {
    //     int currJumps = n;
    //     ListNode currNode = head;
    //     while(currJumps > 0){
    //         currNode = currNode.next;
    //         currJumps--;
    //     }

    //     ListNode dummy = new ListNode(0);
    //     dummy.next = head;

    //     ListNode prev = dummy;

    //     while(currNode != null){
    //         currNode = currNode.next;
    //         prev = prev.next;
    //     }
    //     prev.next = prev.next.next;
    //     return dummy.next;
    // }

    // T: O(2N) S: O(1)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode curr = head; // to caculate length of the linked list
        int length = 0;
        
        while(curr != null){
            length++;
            curr = curr.next;
        }

        ListNode temp = dummy; // to calculate the predeccessor
        int jumps = 0;
        int diff = length - n;
        while(jumps < diff){
            temp = temp.next;
            jumps++;
        }
        temp.next = temp.next.next;

        return dummy.next;
    }
}