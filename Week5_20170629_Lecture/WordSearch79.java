/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/

public class WordSearch79 {
	public boolean exist(char[][] board, String word) {
		if (word == null || word.length() == 0) {
			return true;
		}
		char[] str = word.toCharArray();

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (helper(board, str, i, j, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean helper(char[][] board, char[] str, int i, int j, int pos) {
		if (pos == str.length) {
			return true;
		}

		if (i < 0 || i >= board.length || j < 0 || j >=board[0].length || board[i][j] != str[pos]) {
			return false;
		}

		board[i][j] ^= 256;

		boolean res= helper(board, str, i - 1, j, pos +1) || helper(board, str, i + 1, j, pos + 1) || helper(board, str, i, j - 1, pos + 1) || helper(board, str, i, j + 1, pos + 1);
		board[i][j] ^= 256;
		return res;
	}
}