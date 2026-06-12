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

// class Solution {

//     /*
//      * Approach 1: HashSet
//      * -------------------
//      *
//      * Store every visited node in a HashSet.
//      *
//      * If we encounter the same node again,
//      * it means the linked list contains a cycle.
//      *
//      * TC: O(N)
//      * SC: O(N)
//      */
//     public boolean hasCycle(ListNode head) {

//         // Stores all visited nodes
//         Set<ListNode> set = new HashSet<>();

//         ListNode curr = head;

//         while (curr != null) {

//             /*
//              * If current node is already present,
//              * we have visited it before.
//              *
//              * Therefore, a cycle exists.
//              */
//             if (set.contains(curr)) {
//                 return true;
//             }

//             // Mark current node as visited
//             set.add(curr);

//             // Move to next node
//             curr = curr.next;
//         }

//         /*
//          * Reached end of list.
//          * No cycle found.
//          */
//         return false;
//     }
// }

class Solution {

    /*
     * Floyd's Cycle Detection Algorithm
     *
     * TC: O(N)
     * SC: O(1)
     *
     * Slow moves 1 step.
     * Fast moves 2 steps.
     *
     * If a cycle exists,
     * they will eventually meet.
     */
    public boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;          // 1 step
            fast = fast.next.next;     // 2 steps

            // Cycle detected
            if (slow == fast) {
                return true;
            }
        }

        // Fast reached null => no cycle
        return false;
    }
}