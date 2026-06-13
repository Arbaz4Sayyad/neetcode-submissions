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
// class Solution {

//     // TC: O(N) SC: O(N)
//     // public int pairSum(ListNode head) {
//     //     List<Integer> list = new ArrayList<>();

//     //     // iterate through the ll and add to the list
//     //     while(head != null){
//     //         list.add(head.val);
//     //         head = head.next;
//     //     }

//     //     int i=0;
//     //     int j = list.size()-1;

//     //     int max = Integer.MIN_VALUE;

//     //     while(i < j){
//     //         int sum = list.get(i) + list.get(j);
//     //         max = Math.max(max, sum);

//     //         i++;
//     //         j--;
//     //     }

//     //     return max;
//     // }
// }

class Solution {

    /*
     * Reverse a Linked List
     * ---------------------
     *
     * TC: O(N)
     * SC: O(1)
     *
     * Returns the new head after reversal.
     */
    public ListNode reverseLL(ListNode curr) {

        ListNode prev = null;

        while (curr != null) {

            ListNode next = curr.next;

            // Reverse link
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }

    /*
     * Maximum Twin Sum of a Linked List
     * ---------------------------------
     *
     * Twin Nodes:
     * For a list of size n:
     *
     * index 0 <-> index n-1
     * index 1 <-> index n-2
     * index 2 <-> index n-3
     *
     * Find the maximum twin sum.
     *
     * TC: O(N)
     * SC: O(1)
     *
     * Approach:
     * 1. Find the middle of the linked list.
     * 2. Reverse the second half.
     * 3. Compare nodes from both halves.
     * 4. Compute maximum twin sum.
     * 5. Restore the original list (optional).
     */
    public int pairSum(ListNode head) {

        /*
         * Step 1:
         * Find the middle using Slow-Fast pointers.
         *
         * For even-length lists,
         * slow will point to the first node
         * of the second half.
         */
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        /*
         * Example:
         * 1 -> 2 -> 3 -> 4
         *
         * slow points to 3
         */

        /*
         * Step 2:
         * Reverse second half.
         */
        ListNode p2 = reverseLL(slow);

        /*
         * Save reference so we can restore later.
         */
        ListNode p2Copy = p2;

        /*
         * p1 starts from beginning.
         * p2 starts from reversed second half.
         */
        ListNode p1 = head;

        int max = Integer.MIN_VALUE;

        /*
         * Step 3:
         * Calculate twin sums.
         */
        while (p1 != null && p2 != null) {

            int twinSum = p1.val + p2.val;

            max = Math.max(max, twinSum);

            p1 = p1.next;
            p2 = p2.next;
        }

        /*
         * Step 4 (Optional):
         * Restore original linked list.
         *
         * LeetCode does not require this,
         * but it is a good practice if the
         * caller expects the list unchanged.
         */
        reverseLL(p2Copy);

        return max;
    }
}