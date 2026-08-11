/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

class Solution extends GuessGame {

    public int guessNumber(int n) {

        int low = 1;
        int high = n;

        while (low <= high) {

            // Avoid integer overflow
            int mid = low + (high - low) / 2;

            int result = guess(mid);

            // result = 0 → we found the number
            if (result == 0) {
                return mid;
            }

            // result = -1 → our guess is too high
            else if (result == -1) {
                high = mid - 1;
            }

            // result = 1 → our guess is too low
            else {
                low = mid + 1;
            }
        }

        return -1;
    }
}