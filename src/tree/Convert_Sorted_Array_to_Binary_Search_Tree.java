package tree;

/***
 * Given an array where elements are sorted in ascending order, convert it to a
 * height balanced BST.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 * 
 * @author limerick
 *
 */
public class Convert_Sorted_Array_to_Binary_Search_Tree {
	
    public TreeNode sortedArrayToBST(int[] nums) {
		return createTree(nums, 1, nums.length);
	}

	private TreeNode createTree(int[] nums, int left, int right) {
		if (left <= right) {
			int mid = (left + right) / 2;
			TreeNode treeNode = new TreeNode(nums[mid]);
			treeNode.left = createTree(nums, left, mid - 1);
			treeNode.right = createTree(nums, mid + 1, right);
			return treeNode;
		}
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
