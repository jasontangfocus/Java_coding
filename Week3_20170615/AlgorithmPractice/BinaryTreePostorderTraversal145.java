/*
Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].
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
public class BinaryTreePostorderTraversal145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        //special case
        if (root == null) {
        	return new ArrayList<>();
        }

        //normal case

        //use deque instead of stack and always add root node first
        Deque<TreeNode> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        stack1.addFirst(root);

        while(!stack1.isEmpty()) {
        	TreeNode cur = stack1.removeFirst();
        	stack2.addFirst(cur.val);
        	if (cur.left != null) {
        		stack1.addFirst(cur.left);
        	}
        	if (cur.right != null) {
        		stack1.addFirst(cur.right);
        	}
        }

        return new ArrayList<Integer>(stack2);
    }
}