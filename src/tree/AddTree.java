package tree;

/**
 * @author leeray
 * @version 创建时间：2019年3月28日 下午5:04:34 <br>
 *          描述：538. 把二叉搜索树转换为累加树<br>
 *          给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，
 *          使得每个节点的值是原来的节点值加上所有大于它的节点值之和。

			例如：
			
			输入: 二叉搜索树:
			              5
			            /   \
			           2     13
			
			输出: 转换为累加树:
			             18
			            /   \
			          20     13
 */
public class AddTree {
	public TreeNode convertBST(TreeNode root) {
		RIL(root);
		return root;
	}
//先访问右节点，然后访问根节点，保存累加值，最后访问左节点。
	int preNum = 0;

	void RIL(TreeNode t) {
		if (t == null)
			return;
		RIL(t.right);
		t.val += preNum;
		preNum = t.val;
		RIL(t.left);
	}
}
