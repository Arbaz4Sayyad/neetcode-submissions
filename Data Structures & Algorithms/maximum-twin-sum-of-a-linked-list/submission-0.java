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
    // public int pairSum(ListNode head) {
    //     List<Integer> list = new ArrayList<>();

    //     // iterate through the ll and add to the list
    //     while(head != null){
    //         list.add(head.val);
    //         head = head.next;
    //     }

    //     int i=0;
    //     int j = list.size()-1;

    //     int max = Integer.MIN_VALUE;

    //     while(i < j){
    //         int sum = list.get(i) + list.get(j);
    //         max = Math.max(max, sum);

    //         i++;
    //         j--;
    //     }

    //     return max;
    // }

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

    public int pairSum(ListNode head) {
        
        // find middle node using slow fast pointer
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse on thet slow node
        
        ListNode p2 = reverseLL(slow);
        ListNode p1 = head;

        int max = Integer.MIN_VALUE;

         // calculate sum
        while(p1 != null && p2 != null){
            int candidate = p1.val + p2.val;
            max = Math.max(max, candidate);

            p1 = p1.next;
            p2 = p2.next;
        }
       
       return max;

    }

}