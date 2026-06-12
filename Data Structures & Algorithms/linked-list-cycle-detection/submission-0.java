/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

class Solution {

    /*
     * Approach 1: HashSet
     * -------------------
     *
     * Store every visited node in a HashSet.
     *
     * If we encounter the same node again,
     * it means the linked list contains a cycle.
     *
     * TC: O(N)
     * SC: O(N)
     */
    public boolean hasCycle(ListNode head) {

        // Stores all visited nodes
        Set<ListNode> set = new HashSet<>();

        ListNode curr = head;

        while (curr != null) {

            /*
             * If current node is already present,
             * we have visited it before.
             *
             * Therefore, a cycle exists.
             */
            if (set.contains(curr)) {
                return true;
            }

            // Mark current node as visited
            set.add(curr);

            // Move to next node
            curr = curr.next;
        }

        /*
         * Reached end of list.
         * No cycle found.
         */
        return false;
    }
}