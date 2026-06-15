class Solution {
    // T: O(logN) S: O(1)
    public int mySqrt(int x) {
        int start = 0;
        int end = x;

        int ans = 0;

        while(start <= end){
            int mid = start + (end - start) / 2;

            long square = (long) mid * mid;

            if(square > x){
                end = mid - 1;
            }else{
                ans = mid; // could be a potential answer
                start = mid + 1;
            }
        }

        return ans;
    }
    
    // T: O(N) S: O(1)
    // public int mySqrt(int x) {
    //     int ans = 0;
    //     for(int num = 1; num <= x; num++){
    //         long val = (long) num * num;

    //         if(val > x){
    //             break;
    //         }

    //         ans = num;
    //     }
    //     return ans;
    // }

}