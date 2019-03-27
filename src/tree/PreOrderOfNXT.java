package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author leeray
 * @version 创建时间：2019年3月27日 上午10:00:36 <br>
 *          描述：589. N叉树的前序遍历<br>
 *          给定一个 N 叉树，返回其节点值的前序遍历。<br>
 *          说明: 递归法很简单，你可以使用迭代法完成此题吗?<br>
 */
public class PreOrderOfNXT {
	List<Integer> list = new ArrayList<Integer>();

	public List<Integer> preorder(Node root) {
		// 先递归吧
		if (root == null)
			return list;
		list.add(root.val);
		for (Node nd : root.children)
			preorder(nd);
		return list;
	}
	
	//非递归
	public List<Integer> preorderT(Node root) {
        List<Integer> list = new ArrayList<Integer>();
       if(root == null)
           return list;
       Stack<Node> S = new Stack<Node>();
       S.add(root);
       while(!S.isEmpty()){
          root = S.pop();
          list.add(root.val);
           for(int i = root.children.size()-1;i>=0;i--)
               S.add(root.children.get(i));
       }
       return list;
   }
}
