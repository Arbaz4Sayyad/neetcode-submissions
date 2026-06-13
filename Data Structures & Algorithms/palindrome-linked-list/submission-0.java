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
    //     while(head != null){
    //         list.add(head.val);
    //         head = head.next;
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
    public ListNode reverseLL(ListNode curr){
        ListNode prev = null;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode p2 = reverseLL(slow);
        ListNode p1 = head;

        while(p1 != null && p2 != null){
            if(p1.val != p2.val){
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
    }
}