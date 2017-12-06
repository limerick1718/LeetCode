package tree;

/***
 * Given a binary tree, find its maximum depth. The maximum depth is the number
 * of nodes along the longest path from the root node down to the farthest leaf
 * node.
 * 
 * @author limerick
 * by pre-order
 */
public class Maximum_Depth_of_Binary_Tree {
	
	public int maxDepth(TreeNode root) {
		// recursive terminal condition
		if (root == null) return 0; 
		return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
