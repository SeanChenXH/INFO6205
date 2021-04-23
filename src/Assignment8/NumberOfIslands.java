package Assignment8;

/**
 * 200. Number of Islands
 * <p>
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 * <p>
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 */
public class NumberOfIslands {

    public static void main(String[] args) {
        //Test 1
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println("Test 1: " + numIslands(grid));//1

        //Test 2
        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println("Test 2: " + numIslands(grid2));//3
    }

    public static int[][] dirs = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    public static int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    public static void dfs(char[][] grid, int r, int c) {
        if (grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';

        for (int[] dir : dirs) {
            int newR = r + dir[0];
            int newC = c + dir[1];

            if (newR >= 0 && newR < grid.length && newC >= 0 && newC < grid[0].length) {
                dfs(grid, newR, newC);
            }
        }
    }
}
