package tree;

/**
 * @author leeray
 * @version 创建时间：2019年3月27日 上午10:50:50 <br>
 * 			描述：404. 左叶子之和<br>
 * 计算给定二叉树的所有左叶子之和。
	
	示例：
	
	    3
	   / \
	  9  20
	    /  \
	   15   7

在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 */
public class LeftLeaves {
	public int sumOfLeftLeaves(TreeNode root) {
		int sum = 0;
		if (root == null)
			return sum;
		if (root.left != null && root.left.left == null && root.left.right == null)
			sum += root.left.val;
		return sum + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
	}
}
