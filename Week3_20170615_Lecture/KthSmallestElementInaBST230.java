/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ? k ? BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

Credits:
Special thanks to @ts for adding this problem and creating all test cases.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//Iteration version
public class kthSmallestElementInaBST230 {
    public int kthSmallest(TreeNode root, int k) {
        //special case
        if (root == null) {
        	return -1;
        }

        //normal case
        Deque<TreeNode> stack = new ArrayDeque<>();
        while(root != null) {
        	stack.addFirst(root);
        	root = root.left;
        }

        while(!stack.isEmpty()) {
        	TreeNode cur = stack.removeFirst();
        	//counter
        	k--;
        	if (k == 0) {
        		return cur.val;
        	}
        	cur = cur.right;
        	while (cur != null) {
        		stack.addFirst(cur);
        		cur = cur.left;
        	}
        }
        return -1;
    }
}

//Recrusion Version
public class kthSmallestElementInaBST230 {

	private int count;
	private int value;

	public int kthSmallest(TreeNode root, int k) {
		//special case 
		if (root == null) {
			return -1;
		}
		this.count = k;
		helper(root);
		return this.value;
	}

	public void helper(TreeNode root) {
		//special case
		if (root == null) {
			return;
		}

		//normal case
		helper(root.left);
		this.count--;
		if (this.count == 0) {
			this.value = root.val;
			return;
		}
		helper(root.right);
		return;
	}
}
