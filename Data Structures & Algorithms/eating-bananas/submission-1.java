class Solution {
    // public int minEatingSpeed(int[] piles, int h) {
    //     int min = 1;
    //     int max = Integer.MIN_VALUE;

    //     for(int pile : piles){
    //         max = Math.max(pile, max);
    //     }

    //     for(int speed = min; speed <= max; speed++){
    //         if(isPossible(piles, speed, h)){
    //             return speed;
    //         }
    //     }

    //     return -1;
    // }

    /*
     * Helper Function
     * ---------------
     *
     * Checks whether Koko can finish all piles
     * within the given number of hours using
     * the specified eating speed.
     *
     * TC: O(N)
     * SC: O(1)
     */
    public boolean isPossible(int[] piles, int speed, int hours) {

        long totalHours = 0;

        for (int pile : piles) {

            /*
             * Hours required for current pile:
             *
             * ceil(pile / speed)
             *
             * Example:
             * pile = 7
             * speed = 3
             *
             * 7/3 = 2.33
             * ceil(2.33) = 3 hours
             */
            totalHours += (int) Math.ceil((double) pile / speed);
        }

        return totalHours <= hours;
    }

    /*
     * Koko Eating Bananas
     * -------------------
     *
     * Find the minimum eating speed K
     * such that Koko can finish all bananas
     * within h hours.
     *
     * TC: O(N log M)
     *      N = number of piles
     *      M = maximum pile size
     *
     * SC: O(1)
     *
     * Binary Search on Answer
     */
    public int minEatingSpeed(int[] piles, int h) {

        /*
         * Maximum possible speed.
         *
         * If Koko eats at max pile size,
         * she can finish any pile in one hour.
         */
        int max = Integer.MIN_VALUE;

        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        /*
         * Search Space:
         *
         * Minimum speed = 1
         * Maximum speed = max pile size
         */
        int start = 1;
        int end = max;

        int ans = 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            /*
             * If current speed works,
             * try to find a smaller valid speed.
             */
            if (isPossible(piles, mid, h)) {

                ans = mid;

                // Search left half
                end = mid - 1;
            }

            /*
             * Current speed is too slow.
             * Need higher speed.
             */
            else {

                // Search right half
                start = mid + 1;
            }
        }

        return ans;
    }
}