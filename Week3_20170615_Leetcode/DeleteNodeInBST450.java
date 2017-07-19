/*
Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
Note: Time complexity should be O(height of tree).

Example:

root = [5,3,6,2,4,null,7]
key = 3

    5
   / \
  3   6
 / \   \
2   4   7

Given key to delete is 3. So we find the node with value 3 and delete it.

One valid answer is [5,4,6,2,null,null,7], shown in the following BST.

    5
   / \
  4   6
 /     \
2       7

Another valid answer is [5,2,6,null,4,null,7].

    5
   / \
  2   6
   \   \
    4   7

*/

public class DeleteNodeInBST450 {
	public TreeNode deleteNode(TreeNode root, int key) {
		//Edge Case
		if (root == null) {
			return null;
		}

		//Normal Case
		TreeNode cur = root;
		TreeNode parent = root;

		//flag to check if the cur node is the left child of its parent node
		boolean isLeftChild = true;

		while (cur.val != key) {
			parent = cur;

			//go to the left branch
			if (cur.val > key) {
				isLeftChild = true;
				cur = cur.left;	
			} else {
				//go to the right branch
				cur = cur.right;
			}

			//Because this while loop is for current node != key we are looking for, if cur.left or right nodes are all not equal to targe key, which means that we can not find the target key in the BST in order for us to exit this while loop, so when cur equals to null, means no val can be mathced with the key value, so we exit here.
			if (cur == null) {
				return null;
			}
		}

		//when executing to this step, means we have found the matched val to the target key, so we jumped out of the while loop.
		//when the target value needs deleting is the lead node
		if (cur.left == null && cur.right == null) {
			if (cur == root) {
				cur = null;
			} else if (isLeftChild) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		}

		//when the target value has the left child and do not have the right child
		if (cur.right == null && cur.left != null) {
			if (cur == root) {
				root = cur.left;
			} else if (isLeftChild) {
				parent.left = cur.left;
			} else {
				parent.right = cur.left;
			}
		}

		//when the target value has the right child and do not have the left child
		if (cur.left == null && cur.right != null) {
			if (cur == root) {
				root = cur.right;
			} else if (isLeftChild) {
				parent.left = cur.right;
			} else {
				parent.right = cur.right;
			}
		}

		//when the target value both has the left and right child
		else {
			Node successor = getSuccessor(cur);

			if (cur == root) {
				root = successor;
			} else if (isLeftChild) {
				parent.left = successor;
			} else {
				parent.right = successor;
			}

			//need to take care of final connection with cur.left
			successor.left = cur.left;
		}
		return cur;
	}

	private TreeNode getSuccessor(TreeNode keyNode) {
		TreeNode successorParent = keyNode;
		TreeNode successor = keyNode;
		TreeNode cur = keyNode.right;

		//move to left as far as possible in the right subtree
		while (cur != null) {
			successorParent = successor;
			successor = cur;
			cur = cur.left;
		}

		if (successor != keyNode.right) {
			successorParent.left = successor.right;
			successor.right = keyNode.right;
		}
		return successor;
	}
}




































