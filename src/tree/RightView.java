package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author leeray
 * @version 创建时间：2019年3月26日 下午8:40:07 <br>
 * 			描述：199. 二叉树的右视图<br>
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

		示例:
		
		输入: [1,2,3,null,5,null,4]
		输出: [1, 3, 4]
		解释:
		
		   1            <---
		 /   \
		2     3         <---
		 \     \
		  5     4       <---
 */
public class RightView {
	// 树的层次遍历
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null)
			return list;
		List<List<Integer>> lil = new ArrayList<List<Integer>>();
		Queue<TreeNode> Q = new LinkedList<TreeNode>();
		Q.add(root);
		while (!Q.isEmpty()) {
			List<Integer> temp = new ArrayList<Integer>();
			int count = Q.size();
			while (count > 0) {
				root = Q.poll();
				temp.add(root.val);
				if (root.left != null)
					Q.add(root.left);
				if (root.right != null)
					Q.add(root.right);
				count--;
			}
			lil.add(temp);
		}
		for (List<Integer> l : lil) {
			list.add(l.get(l.size() - 1));
		}
		return list;
	}
}
