class Solution {
    int rows;
    int cols;

    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        int islands = 0;

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    dfs(i, j, grid, visited);
                    islands++;
                }
            }
        }
        return islands;
    }

    public void dfs(int row, int col, char[][] grid, boolean[][] visited){
        
        // dead ends or out of bound
        if(row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == '0' || visited[row][col]){
            return;
        }

        visited[row][col] = true;
        // visit neighbours [Up, right, down, left] here i am using adjList instead of this we can use 4 dfs calls

        int[][] adjList = {
            {row-1, col}, {row, col+1}, {row+1, col}, {row, col-1}};
        for(int neighbour[] : adjList){
            dfs(neighbour[0], neighbour[1], grid, visited);
        }
        
        
        // 4 Operations
        // solve(grid, i-1, j, n, m); // up
        // solve(grid, i+1, j, n, m); // down
        // solve(grid, i, j-1, n, m); // left
        // solve(grid, i, j+1, n, m); // right
    }
}