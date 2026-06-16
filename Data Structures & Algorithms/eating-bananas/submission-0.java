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

    public boolean isPossible(int[] piles, int speed, int hours){
        long totalHours = 0;
        for(int pile : piles){
            totalHours = totalHours + (int)Math.ceil((double) pile / speed);
        }

        return totalHours <= hours;
    }

    public int minEatingSpeed(int[] piles, int h) {
        
        int max = Integer.MIN_VALUE;

        for(int pile : piles){
            max = Math.max(pile, max);
        }

        int start = 1;
        int end = max;

        int ans = 1;

        while(start <= end){
            int mid = start + (end-start)/2;

            if(isPossible(piles, mid, h)){
                ans = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return ans;
    }
}
