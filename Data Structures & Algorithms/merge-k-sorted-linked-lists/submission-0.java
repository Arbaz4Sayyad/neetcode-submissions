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
    public ListNode mergeKLists(ListNode[] lists) {
        // T: O(nlogn) S: O(n)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(ListNode list : lists){
            while(list != null){
                minHeap.add(list.val);
                list = list.next;
            }
        }   

        // Create a sentinal/dummy node to start
        ListNode dummy = new ListNode(0);
        ListNode merge = dummy;

        while(!minHeap.isEmpty()){
            merge.next = new ListNode(minHeap.remove());
            merge = merge.next;
        }

        // return the next node to sentinal node
        return dummy.next;
    }
}       