package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leeray
 * @version 创建时间：2019年3月30日 上午11:49:16 <br>
 *          描述：897. 递增顺序查找树<br>
 *          给定一个树，按中序遍历重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。

		示例 ：
		
		输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]
		
		       5
		      / \
		    3    6
		   / \    \
		  2   4    8
		 /        / \ 
		1        7   9
		
		输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
		
		 1
		  \
		   2
		    \
		     3
		      \
		       4
		        \
		         5
		          \
		           6
		            \
		             7
		              \
		               8
		                \
		                 9  		 
		
		提示：

给定树中的结点数介于 1 和 100 之间。
每个结点都有一个从 0 到 1000 范围内的唯一整数值。
 */
public class BSTupup {
	public TreeNode increasingBST(TreeNode root) {
		inorder(root);
		TreeNode res = new TreeNode(list.get(0));
		TreeNode hd = res;
		int index = 1;
		while (index < list.size()) {
			hd.right = new TreeNode(list.get(index));
			hd = hd.right;
			index++;
		}
		return res;
	}

	List<Integer> list = new ArrayList<Integer>();

	void inorder(TreeNode t) {
		if (t == null)
			return;
		inorder(t.left);
		list.add(t.val);
		inorder(t.right);
	}
}
