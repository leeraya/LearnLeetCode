package tree;

import java.util.HashSet;
import java.util.Set;

/**
 * @author leeray
 * @version 创建时间：2019年3月23日 下午5:40:19 <br>
 *          描述：965. 单值二叉树<br>
 *          如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
 * 
 *          只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 */
public class UnivalTree {

	Set<Integer> set = new HashSet<Integer>();

	public boolean isUnivalTree(TreeNode root) {
		if (root == null)
			return false;

		set.add(root.val);// 保存节点值

		if (root.left != null)
			isUnivalTree(root.left);// 递归

		if (root.right != null)
			isUnivalTree(root.right);// 递归

		if (set.size() > 1)
			return false;
		else
			return true;
	}
}
