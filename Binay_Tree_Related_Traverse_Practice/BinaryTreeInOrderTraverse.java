/*-----------Recrusive Version-------------*/

public class BinaryTreeInOrderTraverse {
	public static void inOrderTraverse(TreeNode rootnode) {
		TreeNode p = rootnode;

		if (p != null) {
			inOrderTraverse(p.leftchild);
			System.out.println(p.value);
			inOrderTraverse(p.rightchild);
		}
		else return;
	}
}

/*-----------Non - Recrusive Version-------------*/

public static void inOrderTraverse(TreeNode rootnode) {
	//Base case
	if (rootnode == null) {
		return;
	}

	//Normal case
	TreeNode current = rootnode;
	Deque<TreeNode> stack = new LinkedList<TreeNode>();
	while (current != null || stack.isEmpty() != true) {
		while(current != null) {
		stack.push(current);
		current = current.leftchild;
	}

	if (current == null) {
		TreeNode node = stack.pop();
		System.out.println(node.value);
		current = node.rightchild;
		}
	}
	

}