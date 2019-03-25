package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leeray
 * @version 创建时间：2019年3月25日 下午6:18:43 <br>
 *          描述：100. 相同的树<br>
 *          给定两个二叉树，编写一个函数来检验它们是否相同。
 * 
 *          如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 */
public class SameTree {
	// low b做法，太繁琐。
	public boolean isSameTree(TreeNode p, TreeNode q) {
		// 前序遍历二叉树，空节点时list加入"null"
		List<String> list1, list2;
		list1 = preOrder(p);
		res = new ArrayList<String>();// 清空res;
		list2 = preOrder(q);

		if (list1.size() != list2.size())
			return false;

		for (int i = 0; i < list1.size(); i++) {
			if (!list1.get(i).equals(list2.get(i)))
				return false;
		}
		return true;
	}

	// 前序遍历
	List<String> res = new ArrayList<String>();

	List<String> preOrder(TreeNode t) {
		if (t == null) {
			res.add("null");
			return res;
		}

		res.add(String.valueOf(t.val));
		preOrder(t.left);
		preOrder(t.right);
		return res;
	}

	public boolean isSameTreeTwo(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if (p != null && q != null && p.val == q.val) {
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		} else {
			return false;
		}
	}
}
