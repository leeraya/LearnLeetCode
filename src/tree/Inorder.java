package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leeray
 * @version 创建时间：2019年3月25日 下午6:17:15 <br>
 * 			描述：94. 二叉树的中序遍历<br>
 * 给定一个二叉树，返回它的中序 遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]
 */
public class Inorder {
	List<Integer> list = new ArrayList<Integer>();

	public List<Integer> inorderTraversal(TreeNode root) {
		if (root == null)
			return list;
		inorderTraversal(root.left);
		list.add(root.val);
		inorderTraversal(root.right);

		return list;
	}
}
