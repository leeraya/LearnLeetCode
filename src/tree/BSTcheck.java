package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leeray
 * @version 创建时间：2019年3月31日 上午10:50:02 <br>
 *          描述：98. 验证二叉搜索树<br>
 *          给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 
 *          假设一个二叉搜索树具有如下特征：
 * 
 *          节点的左子树只包含小于当前节点的数。 节点的右子树只包含大于当前节点的数。 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class BSTcheck {
	public boolean isValidBST(TreeNode root) {
		inorder(root);// 中序遍历得到序列
		// 验证序列是否完全升序
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i) >= list.get(i + 1))
				return false;
		}
		return true;
	}

	// 中序遍历一遍，如果是二叉搜索树的话，得到的序列是一个升序序列。如果不是升序，那么它不是二叉搜索树。
	List<Integer> list = new ArrayList<Integer>();

	void inorder(TreeNode t) {
		if (t == null)
			return;// 终止条件，如果碰到空节点，那么就返回吧
		inorder(t.left);
		list.add(t.val);
		inorder(t.right);// 中序标准模板
	}
}
