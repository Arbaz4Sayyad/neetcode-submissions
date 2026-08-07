class Solution {
    public int reverse(int x) {

        int reverse = 0;

        while (x != 0) {

            // Get the last digit
            int digit = x % 10;

            // Check for positive overflow
            if (reverse > Integer.MAX_VALUE / 10 ||
                (reverse == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }

            // Check for negative overflow
            if (reverse < Integer.MIN_VALUE / 10 ||
                (reverse == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }

            // Add digit to reversed number
            reverse = reverse * 10 + digit;

            // Remove last digit from x
            x = x / 10;
        }

        return reverse;
    }
}