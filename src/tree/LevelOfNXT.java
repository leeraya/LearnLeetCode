package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author leeray
 * @version 创建时间：2019年3月27日 上午10:58:38 <br>
 *          描述：429. N叉树的层序遍历<br>
 *          给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 */
public class LevelOfNXT {
	public List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null)
			return res;
		Queue<Node> Q = new LinkedList<Node>();
		Q.add(root);
		int start = 0, end = 1;
		while (!Q.isEmpty()) {
			List<Integer> temp = new ArrayList<Integer>();
			int count = Q.size();
			while (count > 0) {
				root = Q.poll();
				temp.add(root.val);
				for (Node nd : root.children)
					Q.add(nd);
				start++;
				count--;
				if (start == end) {
					res.add(temp);
					start = 0;
					end = Q.size();
				}
			}
		}
		return res;
	}
}
