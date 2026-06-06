class Solution {
    public int mySqrt(int x) {
        int start = 0;
        int end = x;
        int ans = -1;

        while(start <= end){
            int mid = start + (end - start) / 2;
            long prod = (long) mid * mid;
            if(prod == x){
                return mid;
            }else if(prod > x){
                end = mid - 1;
            }else{
                ans = mid; // could be a potential answer
                start = mid + 1;
            }
        }
        return ans;
    }
}