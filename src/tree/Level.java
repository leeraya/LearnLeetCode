package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author leeray
 * @version 创建时间：2019年3月25日 下午8:16:40 <br>
 *          描述：102. 二叉树的层次遍历<br>
 *          给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
			
			例如:
			给定二叉树: [3,9,20,null,null,15,7],
			
			    3
			   / \
			  9  20
			    /  \
			   15   7
			返回其层次遍历结果：
			
			[
			  [3],
			  [9,20],
			  [15,7]
			]
 */
public class Level {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();//返回值
		if (root == null)
			return res;
		Queue<TreeNode> Q = new LinkedList<TreeNode>();//层次遍历用队列就对啦
		Q.add(root);//装入
		while (!Q.isEmpty()) {
			List<Integer> list = new ArrayList<Integer>();
			int count = Q.size();
			while (count > 0) {
				//遍历这一层的所有元素
				TreeNode t = Q.poll();
				list.add(t.val);
				if (t.left != null)
					Q.add(t.left);
				if (t.right != null)
					Q.add(t.right);
				count--;
			}
			res.add(list);
		}
		return res;
	}
}
