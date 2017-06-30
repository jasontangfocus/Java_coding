public class BinaryTreePreOrderTraverse {
	public static void preOrderTraverse(TreeNode rootnode) {
		TreeNode p = rootnode;
		if (p != null) {
			System.out.println(p.value);
			preOrderTraverse(p.leftchild);
			preOrderTraverse(p.rightchild);
		}
		else return;
	}
}

/*----------non-recursive----------*/

public static void preOrderTraverse(TreeNode rootnode) {
	//Base case
	if (rootnode == null) {
		return;
	}

	//normal case
	TreeNode p = rootnode;
	Deque<TreeNode> stack = new ArrayList<TreeNode>();
	stack.push(p);

	while (stack.isEmpty() != true) {
		p = stack.pop();
		System.out.println(p.value);
		if (p.rightchild != null) {
			stack.push(p.rightchild);
		}
		if (p.leftchild != null) {
			stack.push(p.leftchild);
		}

	}
}