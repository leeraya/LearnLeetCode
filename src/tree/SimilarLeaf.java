package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leeray
 * @version 创建时间：2019年3月28日 下午6:37:50 <br>
 *          描述：872. 叶子相似的树<br>
 *          请考虑一颗二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 */
public class SimilarLeaf {
	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		List<Integer> list1 = DFS(root1);
		list = new ArrayList<Integer>();// 置空
		List<Integer> list2 = DFS(root2);
		if (list1.size() != list2.size())
			return false;
		for (int i = 0; i < list1.size(); i++) {
			if (list1.get(i) != list2.get(i))
				return false;
		}
		return true;
	}

	List<Integer> list = new ArrayList<Integer>();

	List<Integer> DFS(TreeNode root) {
		if (root == null)
			return list;
		if (root.left == null && root.right == null)
			list.add(root.val);
		DFS(root.left);
		DFS(root.right);
		return list;
	}
	
}
