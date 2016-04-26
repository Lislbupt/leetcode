package com.lisl.code;

/**
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from
 *  the root node down to the farthest leaf node.
 */
public class DepthBinaryTree {
	public static int maxDepth(TreeNode root) {
		if(root==null){
			return 0;
		}
		return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(1);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(1);
		System.out.println(maxDepth(root));
	}
}
