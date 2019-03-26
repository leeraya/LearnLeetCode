package tree;

/**
 * @author leeray
 * @version 创建时间：2019年3月26日 下午9:48:10 <br>
 *          描述：129. 求根到叶子节点数字之和<br>
 *          说明: 叶子节点是指没有子节点的节点。

			示例 1:
			
			输入: [1,2,3]
			    1
			   / \
			  2   3
			输出: 25
			解释:
			从根到叶子节点路径 1->2 代表数字 12.
			从根到叶子节点路径 1->3 代表数字 13.
			因此，数字总和 = 12 + 13 = 25.
 */
public class SUM {
	// 直接把父节点的值*10加到子节点上。
	public int sumNumbers(TreeNode root) {
		return DFS(root, 0);
	}

	int DFS(TreeNode root, int sum) {
		if (root == null)
			return 0;
		
		int result = sum * 10 + root.val;
		
		if (root.left == null && root.right == null)// 到叶子节点了
			return result;
		
		return DFS(root.left, result) + DFS(root.right, result);
	}
}
