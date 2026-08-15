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
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}

// class Solution {
//     public ListNode middleNode(ListNode head) {
//         // Pass 1: Count the number of nodes
//         int n = 0;
//         ListNode current = head;

//         while (current != null) {
//             n++;
//             current = current.next;
//         }

//         // Pass 2: Move to the middle node
//         current = head;

//         for (int i = 0; i < n / 2; i++) {
//             current = current.next;
//         }

//         return current;
//     }
// }

// class Solution {
//     public ListNode middleNode(ListNode head) {
//         ListNode slow = head;
//         ListNode fast = head;

//         while(fast != null){
//             fast = fast.next;
            
//             if(fast != null) {
//                 fast = fast.next;
//                 slow = slow.next;
//             } 
//         }
//         return slow;
//     }
// }