package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
* @author leeray
* @version 创建时间：2019年3月25日 下午8:34:52
* <br>描述：104. 二叉树的最大深度<br>
* 给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

说明: 叶子节点是指没有子节点的节点。

		示例：
		给定二叉树 [3,9,20,null,null,15,7]，
		
		    3
		   / \
		  9  20
		    /  \
		   15   7
		返回它的最大深度 3 。
*/
public class MaxDepth {
	public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
       int left = 0 , right=0;
       left = maxDepth(root.left);
       right = maxDepth(root.right);
       int depth = (left > right)?left:right;
       return depth+1;
    }
	
	public int maxDepthTwo(TreeNode root) {
        if(root == null)
            return 0;
        //层次遍历
        Queue<TreeNode> Q = new LinkedList<TreeNode>();
        Q.add(root);
        int level = 0,start = 0,end = 1;
        while(!Q.isEmpty()){
            TreeNode t = Q.poll();
            start++;
            if(t.left != null)
                Q.add(t.left);
            if(t.right != null)
                Q.add(t.right);
            if(start == end){
                start = 0;
                end = Q.size();
                level++;
            }
        }
        return level;
    }
	
	//递归解法
	int level = 0;
    public int maxDepthT(TreeNode root) {
        if(root == null)
            return 0;
       int left = maxDepth(root.left);
       int right = maxDepth(root.right);
       return Math.max(left,right)+1;
    }
}
