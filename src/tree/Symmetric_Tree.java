package tree;

/***
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric
 * around its center).
 * 
 * @author limerick
 * by pre-order
 */
public class Symmetric_Tree {
	
	public boolean isSymmetric(TreeNode root) {
		return root == null || Sym(root.left, root.right);
	}
	
	private boolean Sym(TreeNode left, TreeNode right) {
		if (left == null && right == null) return true;
		if (left == null ^ right == null) return false;
		if (left.val != right.val) return false;
		return Sym(left.left, right.right) && Sym(left.right, right.left);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
