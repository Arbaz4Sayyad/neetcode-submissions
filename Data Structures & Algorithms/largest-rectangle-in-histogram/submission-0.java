class Solution {
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;

        // Stack stores indices of histogram bars
        Stack<Integer> stack = new Stack<>();

        int maxArea = 0;

        // Traverse all bars
        for (int i = 0; i <= n; i++) {

            // For last iteration use height = 0
            // This forces all remaining bars to be processed.
            int currentHeight = (i == n) ? 0 : heights[i];

            // If current bar is smaller than stack top,
            // calculate rectangles.
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {

                // Height of rectangle
                int height = heights[stack.pop()];

                // Width calculation
                // If stack becomes empty,
                // rectangle extends from 0 to i-1.
                int width;

                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }

                // Update answer
                maxArea = Math.max(maxArea, height * width);
            }

            // Push current index
            stack.push(i);
        }

        return maxArea;
    }
}