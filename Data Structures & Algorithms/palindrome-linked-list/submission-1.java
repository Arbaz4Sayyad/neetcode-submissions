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
    // TC: O(N) SC: O(N)
    // public boolean isPalindrome(ListNode head) {
    //     List<Integer> list = new ArrayList<>();
    //     ListNode curr = head;
    //     while(curr != null){
    //         list.add(curr.val);
    //         curr = curr.next;
    //     }

    //     int i = 0;
    //     int j = list.size() - 1;

    //     while(i < j){
    //         if(list.get(i) != list.get(j)){
    //             return false;
    //         }
    //         i++;
    //         j--;
    //     }
    //     return true;
    // }

    // TC: O(N) SC: O(1)

    
    public ListNode getMidPoint(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Find the middle node (second middle for even-length lists)
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode reverseLL(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        // Reverse the linked list iteratively
        while (curr != null) {
            ListNode next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public boolean isPalindrome(ListNode head) {

        // Empty or single-node lists are palindromes
        if (head == null || head.next == null) {
            return true;
        }

        // 1. Find the second half's starting node
        ListNode list2 = getMidPoint(head);

        // 2. Separate the first and second halves
        ListNode temp = head;

        while (temp.next != list2) {
            temp = temp.next;
        }

        temp.next = null;

        // 3. Reverse the second half
        ListNode head2 = reverseLL(list2);

        // 4. Compare both halves
        ListNode temp1 = head;
        ListNode temp2 = head2;

        while (temp1 != null && temp2 != null) {
            if (temp1.val != temp2.val) {
                return false;
            }

            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        // 5. All corresponding values matched
        return true;
    }
}