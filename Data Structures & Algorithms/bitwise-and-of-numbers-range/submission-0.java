class Solution {
    public int rangeBitwiseAnd(int left, int right) {

        int shift = 0;

        // Find the common prefix
        while (left != right) {
            left = left >> 1;
            right = right >> 1;
            shift++;
        }

        // Add back the removed zero bits
        return left << shift;
    }
}