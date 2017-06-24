/*
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

1 2 3	 1 4 7	  7 4 1
4 5 6 -> 2 5 8 -> 8 5 2
7 8 9	 3 6 9    9 6 3

----> clockwise 90

Follow up:
Could you do this in-place?
*/

public class RotateImage48 {
	public void rotate(int[][] matrix) {
		/*
		1.	left right:	matrix[i][j] = matrix[i][col-j-1]
		2.	up down:	matrix[i][j] = matrix[row-i-1][j]	
		3.	\ :			matrix[i][j] = matrix[j][i]
		4.	同轴/// :	i + j = k(k = 0,1,2...row + col - 2)
		5.	同轴\\\ :	i - j = k(k= -col + 1...0...row - 1)	
		*/

		//special case
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return;
		}

		//normal case
		int row = matrix.length;
		int col = matrix[0].length;

		// \  swap
		for (int i = 0; i < row; i++) {
			for (int j = 0; j <= i; j++) {
				swap(matrix, i, j, j, i);
			}
		}

		//	middle axle swap left right
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col / 2; j++) {
				swap(matrix, i, j, i, col - j -1);
			}
		}

		return;
	}

	public void swap(int[][] matrix, int i, int j, int x, int y) {
		int temp = matrix[i][j];
		matrix[i][j] = matrix[x][y];
		matrix[x][y] = temp;
	}
}