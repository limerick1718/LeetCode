package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/***
 * Given a binary tree, return the bottom-up level order traversal of its nodes'
 * values. (ie, from left to right, level by level from leaf to root).
 * 
 * @author limerick
 * by BFS
 */
public class Binary_Tree_Level_Order_Traversal_II {
	
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		LinkedList<TreeNode> queue = new LinkedList<>();
		if (root == null) return result;
		queue.add(root);
		while (!queue.isEmpty()) {
			// the size of last level
			int size = queue.size();
			ArrayList<Integer> arrayList = new ArrayList<>();
			// only loop the number of last level
			for (int i = 0; i < size; i ++) {
				// remove the node of last level
				TreeNode node = queue.poll();
				if (node.left != null) queue.add(node.left);
				if (node.right != null) queue.add(node.right);
				arrayList.add(node.val);
			}
			result.add(0, arrayList);
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
