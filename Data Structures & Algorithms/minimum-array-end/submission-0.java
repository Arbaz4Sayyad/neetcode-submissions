class Solution {
    public long minEnd(int n, int x) {

        long result = x;

        // We need to create n - 1 additional numbers
        long k = n - 1;

        int bit = 0;

        while (k > 0) {

            // Find a zero bit in x
            if ((x & (1L << bit)) == 0) {

                // Put the current bit of k into this zero bit
                if ((k & 1) != 0) {
                    result |= (1L << bit);
                }

                // Move to the next bit of k
                k >>= 1;
            }

            bit++;
        }

        return result;
    }
}