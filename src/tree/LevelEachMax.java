package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author leeray
 * @version 创建时间：2019年3月25日 下午10:30:25 <br>
 *          描述：515. 在每个树行中找最大值<br>
 *          您需要在二叉树的每一行中找到最大的值。

			示例：
			
			输入: 
			
			          1
			         / \
			        3   2
			       / \   \  
			      5   3   9 
			
			输出: [1, 3, 9]
 */
public class LevelEachMax {
	public List<Integer> largestValues(TreeNode root) {
		// 还是层次遍历
		List<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;
		Queue<TreeNode> Q = new LinkedList<TreeNode>();
		Q.add(root);
		while (!Q.isEmpty()) {
			int Max = Integer.MIN_VALUE;
			int count = Q.size();
			while (count > 0) {
				TreeNode t = Q.poll();
				Max = Math.max(Max, t.val);
				if (t.left != null)
					Q.add(t.left);
				if (t.right != null)
					Q.add(t.right);
				count--;
			}
			res.add(Max);
		}
		return res;
	}
}
