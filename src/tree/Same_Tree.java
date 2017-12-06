package tree;
/***
 *  Given two binary trees, write a function to check if they are the same or not.
 *  Two binary trees are considered the same if they are structurally identical and the nodes have the same value. 
 * @author limerick
 *  achieved by pre-order
 */
public class Same_Tree {
	
	public boolean isSameTree(TreeNode p, TreeNode q) {
		//if it is a empty tree or the leaf node
		if (p == null && q == null) return true;
		//p != q
		if (p == null ^ q == null) return false;
		//p != q
		if (p.val != q.val) return false;
		// recursive
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}

}
