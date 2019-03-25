package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leeray
 * @version 创建时间：2019年3月25日 下午10:42:30 <br>
 * 			描述：145. 二叉树的后序遍历<br>
 * 给定一个二叉树，返回它的 后序 遍历。

		示例:
		
		输入: [1,null,2,3]  
		   1
		    \
		     2
		    /
		   3 
		
		输出: [3,2,1]
		进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class PostOrder {
	List<Integer> res = new ArrayList<Integer>();

	public List<Integer> postorderTraversal(TreeNode root) {
		if (root == null)
			return res;
		postorderTraversal(root.left);
		postorderTraversal(root.right);
		res.add(root.val);
		return res;
	}
}
