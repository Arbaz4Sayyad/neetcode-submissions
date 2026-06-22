class Solution {
    public int maxArea(int[] heights) {
        
        int left = 0;
        int right = heights.length-1;
        int maxArea = 0;

        while(left < right){
            // Area = height * width => width = (right-left)
            int height = Math.min(heights[left], heights[right]);
            int width = (right - left);
            // int currentArea = Math.min(heights[left], heights[right]) * (right-left);
            int currentArea = height * width;
            maxArea = Math.max(currentArea, maxArea);

            if(heights[left] < heights[right]){
                left++;
            }else{
                right--;
            }
        }
        return  maxArea;
    }
}