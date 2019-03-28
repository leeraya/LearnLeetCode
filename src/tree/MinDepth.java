package tree;

/**
 * @author leeray
 * @version 创建时间：2019年3月28日 下午5:06:49 <br>
 *          描述：111. 二叉树的最小深度<br>
 *          给定一个二叉树，找出其最小深度。

最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

说明: 叶子节点是指没有子节点的节点。

	示例:
	
	给定二叉树 [3,9,20,null,null,15,7],
	
	    3
	   / \
	  9  20
	    /  \
	   15   7
	返回它的最小深度  2.
 */
public class MinDepth {
	public int minDepth(TreeNode root) {
		return DFS(root);
	}

	int DFS(TreeNode t) {
		if (t == null)
			return 0;
		if (t.left == null && t.right == null)
			return 1;
		if (t.left != null && t.right == null)
			return DFS(t.left) + 1;
		if (t.left == null && t.right != null)
			return DFS(t.right) + 1;
		else {
			int left = DFS(t.left);
			int right = DFS(t.right);
			return Math.min(left, right) + 1;
		}
	}
}
