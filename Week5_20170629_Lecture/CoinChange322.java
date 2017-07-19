/*
You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Example 2:
coins = [2], amount = 3
return -1.

Note:
You may assume that you have an infinite number of each kind of coin.

Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
*/

public class CoinChange322 {
	public int coinChange(int[] coins, int amount) {
		int[] count = new int[amount + 1];
		Arrays.fill(count, Integer.MAX_VALUE);
		Arrays.sort(coins);
		count[0] = 0;
		return helper(coins, amount, count);
	}

	public int helper(int[] nums, int remain, int[] count) {
		if (count[remain] != Integer.MAX_VALUE) {
			return count[remain];
		}

		int res = Integer.MAX_VALUE;

		for (int i = 0; i < nums.length; i++) {
			if (remain >= nums[i]) {
				int temp = helper(nums, remain - nums[i], count);
				if (temp != -1) {
					res = Math.min(res, temp + 1);
				}
			}			
		}
		count[remain] = (res == Integer.MAX_VALUE ? -1 : res);
		return count[remain];
	}
}