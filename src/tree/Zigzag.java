package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author leeray
 * @version 创建时间：2019年4月3日 下午10:44:11 <br>
 *          描述：103. 二叉树的锯齿形层次遍历<br>
 *          给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

			例如：
			给定二叉树 [3,9,20,null,null,15,7],
			
			    3
			   / \
			  9  20
			    /  \
			   15   7
			返回锯齿形层次遍历如下：
			
			[
			  [3],
			  [20,9],
			  [15,7]
			]
 */
public class Zigzag {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();// 返回值
		if (root == null)
			return res;
		Queue<TreeNode> Q = new LinkedList<TreeNode>();
		List<Integer> list;// 暂时存储一层的节点值
		int level = 0;// 表示第几层
		Q.add(root);
		int start = 0, end = 1;
		while (!Q.isEmpty()) {
			list = new ArrayList<Integer>();
			int count = Q.size();
			while (count-- > 0) {
				start++;
				root = Q.poll();
				list.add(root.val);
				if (root.left != null)
					Q.add(root.left);
				if (root.right != null)
					Q.add(root.right);
				if (start == end) {
					start = 0;
					end = Q.size();
					if (level % 2 == 0) {
						res.add(list);
					} else {
						Collections.reverse(list);
						res.add(list);
					}
					level++;
				}
			}
		}
		return res;
	}
}
