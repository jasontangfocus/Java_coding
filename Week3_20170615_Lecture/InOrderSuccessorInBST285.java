/*
Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

Note: If the given node has no in-order successor in the tree, return null.
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
public class InOrderSuccessorInBST285 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode suc = null;
        //special case
        if (root == null || p == null) {
        	return suc;
        }
      	while (root != null) {
      		if (p.val < root.val) {
      			suc = root;
      			root = root.left;
      		} else {
      			root = root.right;
      		}
      	}
      	return suc;
    }
}
/*
public class InOrderSuccessorInBST285 {
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

    /*------Divide and Conquer alternative*/

    //special case

/*    if (root == null) {
    	return null;
    	}

    //normal case
    if (p.val < root.val) {
    	TreeNode left = inorderSuccessor(root.left, p);
    	return left == null ? root : left;
    	} else {
    		return inorderSuccessor(root.right, p);
    	}
	}
}*/