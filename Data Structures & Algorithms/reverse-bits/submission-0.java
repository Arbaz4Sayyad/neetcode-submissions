public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {

        int result = 0;

        // Process exactly 32 bits
        for (int i = 0; i < 32; i++) {

            // Shift result left to make space for the next bit
            result <<= 1;

            // Extract the last bit of n and add it to result
            result |= (n & 1);

            // Unsigned right shift n to process the next bit
            // >>> fills the leftmost bit with 0
            n >>>= 1;
        }

        return result;
    }
}