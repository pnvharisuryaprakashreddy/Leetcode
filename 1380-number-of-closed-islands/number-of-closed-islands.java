class Solution {
    public int closedIsland(int[][] grid) {
        int cnt = 0;
        int res = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 0) {
                    res = dfs(grid, i, j);

                    if (res == 1) {
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }

    public int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length
                || j >= grid[0].length) {
            return 0;
        }

        if (grid[i][j] == 1) {
            return 1;
        }

        grid[i][j] = 1;

        int up = dfs(grid, i - 1, j);
        int down = dfs(grid, i + 1, j);
        int left = dfs(grid, i, j - 1);
        int right = dfs(grid, i, j + 1);

        return up & down & left & right;
    }
}
