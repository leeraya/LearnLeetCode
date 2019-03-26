package tree;

/**
 * @author leeray
 * @version 创建时间：2019年3月26日 下午7:35:04 <br>
 *          描述：226. 翻转二叉树<br>
 *          翻转一棵二叉树。
 */
public class ReverseTree {
	// 递归解决吧
	// 一开始想的是交换节点的值来达到反转二叉树，但是做法太繁琐了
	// 还是直接换结点的比较好
	public TreeNode invertTree(TreeNode root) {
		if (root == null)
			return root;
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		invertTree(root.left);
		invertTree(root.right);
		return root;
	}
}
