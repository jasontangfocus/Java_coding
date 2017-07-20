/*
You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first turn to remove the stones.

Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of stones in the heap.

For example, if there are 4 stones in the heap, then you will never win the game: no matter 1, 2, or 3 stones you remove, the last stone will always be removed by your friend.

Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
*/
//DP
public class NimGame292 {
	public boolean canWinNim(int n) {
		return canWinNimDP(n);
	}

	public boolean canWinNimDP(int n) {
		if (n <= 3) {
			return true;
		}

		boolean[] dp = new boolean[4];
		dp[0] = false;
		dp[1] = true;
		dp[2] = true;
		dp[3] = true;

		for (int i = 4; i <= n; i++) {
			//rolling array
			dp[i % 4] = !(dp[(i - 1) % 4] && dp[(i-2) % 4] && dp[(i-3) % 4]);
		}
		return dp[n % 4];
	}
}

//memory search
public boolean canWinNim(int n) {
	return helper(n, new HashMap<>());
}

public boolean helper(int n, Map<Integer, Boolean> map) {
	if (n <= 0) {
		return false;
	}

	if (map.containsKey(n)) {
		return map.get(n);
	}

	boolean canNextWin = true;
	for (int i = 1; i <= 3; i++) {
		canNextWin &= helper(n - i, map);
	}

	map.put(n, !canNextWin);
	return !canNextWin;
}













