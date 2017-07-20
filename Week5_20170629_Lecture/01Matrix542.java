/*
Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.
Example 1: 
Input:

0 0 0
0 1 0
0 0 0
Output:
0 0 0
0 1 0
0 0 0
Example 2: 
Input:

0 0 0
0 1 0
1 1 1
Output:
0 0 0
0 1 0
1 2 1
Note:
The number of elements of the given matrix will not exceed 10,000.
There are at least one 0 in the given matrix.
The cells are adjacent in only four directions: up, down, left and right.
*/

public class 01Matrix542 {
	int row;
	int col;

	int[] dx = {1, -1, 0, 0};
	int[] dy = {0, 0, 1, -1};

	public int[][] updateMatrix(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return matrix;
		}
		row = matrix.length;
		col = matrix[0].length;
		preSet(matrix);

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == 1) {
					helper(matrix, 1, i, j);
				}
			}
		}
        return matrix;
	}

	public void preSet(int[][] matrix) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == 0) {
					continue;
				}

				boolean flag = false;
				for (int k = 0; k < 4; k++) {
					int x = i + dx[k];
					int y = j + dy[k];
					if (x < 0 || x >= row || y < 0 || y >= col) {
						continue;
					}
					flag |= matrix[x][y] == 0;
				}
				if (!flag) {
					matrix[i][j] = Integer.MAX_VALUE;
				}
			}
		}
	}

	public void helper(int[][] matrix, int dist, int x, int y) {
		if (matrix[x][y] < dist) {
			return;
		}

		if (matrix[x][y] == dist && matrix[x][y] != 1) {
			return;
		}

		//current layer set dist
		matrix[x][y] = dist;

		for (int i = 0; i < 4; i++) {
			int xNext = x + dx[i];
			int yNext = y + dy[i];
			if (xNext < 0 || xNext >= row || yNext < 0 || yNext >= col) {
				continue;
			}
			helper(matrix, dist + 1, xNext, yNext);
		}
	}
}
















