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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // Dummy node to simplify result construction
        ListNode dummy = new ListNode(0);

        ListNode current = dummy;

        // Carry from the previous addition
        int carry = 0;

        // Continue while either list has nodes
        // or there is still a carry
        while (l1 != null || l2 != null || carry != 0) {

            // Get value from l1
            int value1 = (l1 != null) ? l1.val : 0;

            // Get value from l2
            int value2 = (l2 != null) ? l2.val : 0;

            // Add both digits and carry
            int sum = value1 + value2 + carry;

            // Current digit
            int digit = sum % 10;

            // Carry for next position
            carry = sum / 10;

            // Create node for current digit
            current.next = new ListNode(digit);

            // Move current forward
            current = current.next;

            // Move l1 if possible
            if (l1 != null) {
                l1 = l1.next;
            }

            // Move l2 if possible
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        return dummy.next;
    }
}
