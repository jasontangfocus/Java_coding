/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3
*/

public class NumberofIslands200 {
	public int numberIslands(char[][] grid) {
		//Base case
		if (grid == null || grid.length == 0) {
			return 0;
		}

		//normal case
		int num = 0;
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '0') {
					continue;
				}
				helper(grid, i, j);
				num++;
			}
		}
		return num;
	}

	public void helper(char[][] grid, int x, int y) {
		if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0') {
			return;
		}

		grid[x][y] = '0';

		helper(grid, x - 1, y);
		helper(grid, x + 1, y);
		helper(grid, x, y - 1);
		helper(grid, x, y + 1);

		return;
	}
}