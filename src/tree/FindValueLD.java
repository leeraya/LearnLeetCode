package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author leeray
 * @version 创建时间：2019年3月25日 下午10:21:26 <br>
 * 			描述：513. 找树左下角的值<br>
 * 示例 1:
		
		输入:
		
		    2
		   / \
		  1   3
		
		输出:
		1
 */
public class FindValueLD {
	public int findBottomLeftValue(TreeNode root) {
		// 还是层次遍历
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Queue<TreeNode> Q = new LinkedList<TreeNode>();
		Q.add(root);
		while (!Q.isEmpty()) {
			int count = Q.size();
			List<Integer> temp = new ArrayList<Integer>();
			while (count > 0) {
				TreeNode t = Q.poll();
				temp.add(t.val);
				if (t.left != null)
					Q.add(t.left);
				if (t.right != null)
					Q.add(t.right);
				count--;
			}
			list.add(temp);
		}

		return list.get(list.size() - 1).get(0);
	}
}
