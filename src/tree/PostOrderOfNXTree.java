package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leeray
 * @version 创建时间：2019年3月23日 下午6:31:36 <br>
 *          描述：590. N叉树的后序遍历<br>
 */
public class PostOrderOfNXTree {
	List<Integer> list = new ArrayList<Integer>();

	public List<Integer> postorder(Node root) {
		if (root == null)
			return list;
		for (Node n : root.children) {
			if (n != null)
				postorder(n);
		}
		list.add(root.val);
		return list;
	}
}
