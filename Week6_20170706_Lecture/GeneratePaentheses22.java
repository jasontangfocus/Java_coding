/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
*/

public class GeneratePaentheses22 {
	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		helper(res, new String(), n, 0);
		return res;
	}

	public void helper(List<String> res, String str, int n, int counter) {
		if (counter == 0 && str.length() == 2 * n) {
			res.add(new String(str));
			return;
		}
		if (counter < 0 || counter > n || str.length() > 2 * n) {
			return;
		}
		if (counter > 0 && counter < n) {
			helper(res, str + "(", n, counter + 1);
			helper(res, str + ")", n, counter - 1);
		} else if (counter == 0) {
			helper(res, str + "(", n, counter + 1);
		} else {
			helper(res, str + ")", n, counter - 1);
		}
		return;
	}
}


























