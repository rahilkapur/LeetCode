class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid, rows, cols);
                    ++islands;
                }
            }
        }
        return islands;
        
    }
    public void dfs(int i, int j, char[][] grid, int rows, int cols) {
        if (i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(i - 1, j, grid, rows, cols);
        dfs(i + 1, j, grid, rows, cols);
        dfs(i, j - 1, grid, rows, cols);
        dfs(i, j + 1, grid, rows, cols);
    }
}