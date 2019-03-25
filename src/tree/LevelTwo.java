package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author leeray
 * @version 创建时间：2019年3月25日 下午9:51:59 <br>
 *          描述：107. 二叉树的层次遍历 II<br>
 *          给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 */
public class LevelTwo {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<List<Integer>> temp = new ArrayList<List<Integer>>();// 存储正序遍历结果
		if (root == null)
			return res;
		Queue<TreeNode> Q = new LinkedList<TreeNode>();
		Q.add(root);
		while (!Q.isEmpty()) {
			List<Integer> list = new ArrayList<Integer>();
			int count = Q.size();
			while (count > 0) {
				TreeNode t = Q.poll();
				list.add(t.val);
				if (t.left != null)
					Q.add(t.left);
				if (t.right != null)
					Q.add(t.right);
				count--;
			}
			temp.add(list);
		}
		// 倒置
		for (int i = temp.size() - 1; i >= 0; i--) {
			res.add(temp.get(i));
		}
		return res;
	}
}
