class Solution {
    public int numSquares(int n) {
        if(n <= 3) {
            return n;
        }

        int[] minimumPerfectSquare = new int[n + 1];
        
        Arrays.fill(minimumPerfectSquare, Integer.MAX_VALUE);

        minimumPerfectSquare[0] = 0;
        minimumPerfectSquare[1] = 1;
        minimumPerfectSquare[2] = 2;
        minimumPerfectSquare[3] = 3;

        for (int i = 4; i <= n; i++) {

            for (int j = 1; j * j <= i; j++) {
                minimumPerfectSquare[i] = Math.min(minimumPerfectSquare[i], 1 + minimumPerfectSquare[i - j*j]);
            }
        }

        // If still infinity, amount cannot be formed
        return minimumPerfectSquare[n];
    }
}