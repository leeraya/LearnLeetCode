package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author leeray
 * @version 创建时间：2019年3月26日 下午7:56:14 <br>
 * 			描述：144. 二叉树的前序遍历 <br>
 * 
			 示例:
			
			输入: [1,null,2,3]  
			   1
			    \
			     2
			    /
			   3 
			
			输出: [1,2,3]
			进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class PreOrder {
	//非递归方式实现前序遍历
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> S = new Stack<TreeNode>();
        while(root != null || !S.isEmpty()){
        	if(root != null){
        		//储存节点值
        		res.add(root.val);
        		if(root.right != null)
        			S.add(root.right);
        		root = root.left;
        	}else{
        		root = S.pop();
        	}
        }
        return res;
    }
	
	//通过递归的方式来实现
	List<Integer> list = new ArrayList<Integer>();
	public List<Integer> preorderTraversalTwo(TreeNode root) {
		if(root == null)
			return list;
		list.add(root.val);
		preorderTraversalTwo(root.left);
		preorderTraversalTwo(root.right);
		return list;
	}
}
