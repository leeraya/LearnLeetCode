package tree;

/**
 * @author leeray
 * @version 创建时间：2019年3月27日 上午9:53:52 <br>
 * 			描述：110. 平衡二叉树<br>
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。

本题中，一棵高度平衡二叉树定义为：

一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。

	示例 1:
	
	给定二叉树 [3,9,20,null,null,15,7]
	
	    3
	   / \
	  9  20
	    /  \
	   15   7
	返回 true 。
 */
public class BalancedTree {
	public boolean isBalanced(TreeNode root) {
		return DFS(root) != -1;
	}

	int DFS(TreeNode t) {
		// 深度优先遍历
		if (t == null)
			return 0;

		int left = DFS(t.left);

		int right = DFS(t.right);

		// 这一步是关键，每一次DFS都是在找当前节点的左右子树的深度
		// 我们可以根据左右深度来判断是否平衡，如果不平衡，直接返回-1
		//如果到某节点返回了-1，那么它的父节点也只能返回-1了;
		if (Math.abs(left - right) > 1 || left == -1 || right == -1)
			return -1;
		return Math.max(left, right) + 1;
	}
}
