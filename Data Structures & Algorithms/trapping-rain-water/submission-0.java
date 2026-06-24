class Solution {
    // public int trap(int[] height) {
    //     int n = height.length;

        //   0 1 0 2
        // l 0 1 1 2
        // r 2 2 2 2
        // 1
        // T : O(N) S: O(N) 
        // int[] leftMax = new int[n];
		// leftMax[0] = height[0];
		// for(int i=1; i<n; i++) {
		// 	leftMax[i] = Math.max(height[i], leftMax[i-1]);
		// }

        // int[] rightMax = new int[n];
        // rightMax[n-1] = height[n-1];
        // for(int i=n-2; i>=0; i--){
        //     rightMax[i] = Math.max(height[i], rightMax[i+1]);
        // }
        // int trappedWater = 0;
        // for(int i=0; i<n; i++){
        //     int waterLevel = Math.min(leftMax[i], rightMax[i]);
        //     trappedWater += waterLevel - height[i];
        // }
        // return trappedWater;
    // }

    // T : O(N) S: O(1)
    public int trap(int[] height) {
        int n = height.length;
        int trappedWater = 0;
        int left = 0;
        int right = n-1;
        int leftMax = height[0];
        int rightMax = height[n-1];

        while(left <= right){
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if(rightMax < leftMax){
                trappedWater += rightMax - height[right];
                right--;
            }else{
                trappedWater += leftMax - height[left];
                left++;
            }
        }
        return trappedWater;
    }
}