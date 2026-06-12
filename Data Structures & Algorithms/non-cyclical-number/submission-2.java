// class Solution {

//     /*
//      * Happy Number
//      * ------------
//      *
//      * TC: O(log N)
//      * SC: O(log N)
//      *
//      * Store previously seen numbers in a HashSet.
//      * If a number repeats, we've entered a cycle.
//      */
//     public boolean isHappy(int n) {

//         // Stores all previously seen numbers
//         Set<Integer> set = new HashSet<>();

//         while (n != 1) {

//             /*
//              * If n is already present,
//              * we've encountered a cycle.
//              */
//             if (set.contains(n)) {
//                 return false;
//             }

//             // Mark current number as visited
//             set.add(n);

//             // Generate next number
//             n = getSumOfSquares(n);
//         }

//         // Reached 1 => Happy Number
//         return true;
//     }

//     /*
//      * Returns sum of squares of digits
//      *
//      * Example:
//      * 19
//      * => 1² + 9²
//      * => 82
//      */
//     private int getSumOfSquares(int n) {

//         int sum = 0;

//         while (n > 0) {

//             int digit = n % 10;

//             sum += digit * digit;

//             n /= 10;
//         }

//         return sum;
//     }

//     /*
//     I use a HashSet to detect cycles. For each number, I calculate the sum of the squares of its digits. 
//     If the number becomes 1, it is a happy number. If a previously seen number appears again, 
//     the process is looping and will never reach 1, so I return false. 
//     The HashSet helps detect cycles efficiently. This is the standard solution for Happy Number.
//     */
// }

class Solution {

    /*
     * Happy Number - Floyd's Cycle Detection
     * --------------------------------------
     *
     * TC: O(log N)
     * SC: O(1)
     *
     * Slow moves one step:
     * slow = next(slow)
     *
     * Fast moves two steps:
     * fast = next(next(fast))
     *
     * If a cycle exists, slow and fast will meet.
     * If they meet at 1, the number is happy.
     */
    public boolean isHappy(int n) {

        int slow = n;
        int fast = n;

        while(fast != 1){

            // Move slow pointer by one step
            slow = getNextNumber(slow);

            // Move fast pointer by two steps
            fast = getNextNumber(getNextNumber(fast));

            if(fast == 1){
                return true;
            }
            if(slow == fast){
                return false;
            }
        }
        /*
         * If pointers meet at 1,
         * the number is happy.
         */
        return true;
    }

    /*
     * Returns the sum of squares of digits.
     *
     * Example:
     * 19 -> 1² + 9² = 82
     */
    private int getNextNumber(int n) {

        int sum = 0;

        while (n > 0) {

            int digit = n % 10;

            sum += digit * digit;

            n /= 10;
        }

        return sum;
    }
}

/*
I model the Happy Number sequence as a cycle detection problem. 
Each number generates the next number by taking the sum of the squares of its digits. 
I use Floyd's Cycle Detection where the slow pointer moves one step and the fast pointer moves two steps. 
If the number is happy, both pointers eventually meet at 1. Otherwise, they meet somewhere in a cycle. 
This achieves O(1) space compared to the HashSet solution's O(N) space. 
This is the optimal solution for Happy Number.
*/