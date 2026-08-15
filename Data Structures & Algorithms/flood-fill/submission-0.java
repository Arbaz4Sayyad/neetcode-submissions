class Solution {
    // not given in the question so i am declaring
    int rows;  // total number of rows
    int cols;  // total number of rows
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        rows = image.length;
        cols = image[0].length;

        boolean[][] visited = new boolean[rows][cols];
        dfs(sr, sc, color, image[sr][sc], visited, image);
        return image;
    }

    public void dfs(int row, int col, int newColor, int curColor, boolean[][] visited, int[][] image){
        // out of bound cases
        if(row < 0 || row >= rows || col < 0 || col >= cols || image[row][col] != curColor || image[row][col] == newColor){
            return;
        }
        // instead of visited[] we can directly assign new color to row and col like (image[row][col] == newColor) return
        // if(visited[row][col]){
        //     return;
        // }

        image[row][col] = newColor;
        visited[row][col] = true;

        // visit neighbours [Up, right, down, left] here i am using adjList instead of this we can use 4 dfs calls
        // int[][] adjList = {
        //     {row-1, col}, {row, col+1}, {row+1, col}, {row, col-1}};
        // for(int neighbour[] : adjList){
        //     dfs(neighbour[0], neighbour[1], newColor, curColor, visited, image);
        // }

        dfs(row-1, col, newColor, curColor, visited, image); // up
        dfs(row+1, col, newColor, curColor, visited, image); // down
        dfs(row, col-1, newColor, curColor, visited, image); // left
        dfs(row, col+1, newColor, curColor, visited, image); // right
    }
}