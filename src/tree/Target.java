package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
* @author leeray
* @version 创建时间：2019年3月25日 上午11:08:04
* <br>描述：653. 两数之和 IV - 输入 BST<br>
* 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。

案例 1:

输入: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

输出: True
*/
public class Target {
	public boolean findTarget(TreeNode root, int k) {
        Queue<TreeNode> Q = new LinkedList<TreeNode>();
        List<Integer> list = new ArrayList<Integer>();
        Q.add(root);
        //层次遍历
        while(!Q.isEmpty()){
            root = Q.poll();
            list.add(root.val);
            if(root.left != null)
                Q.add(root.left);
            if(root.right != null)
                Q.add(root.right);
        }
        for(int i = 0;i < list.size();i++){
            for(int j = i + 1;j<list.size();j++){
                if(list.get(i) + list.get(j) == k)
                    return true;
            }
        }
        return false;
    }
	
	 public boolean findTargetTwo(TreeNode root, int k) {
	        Queue<TreeNode> Q = new LinkedList<TreeNode>();
	        List<Integer> list = new ArrayList<Integer>();
	        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	        Q.add(root);
	        //层次遍历
	        while(!Q.isEmpty()){
	            root = Q.poll();
	            list.add(root.val);
	            if(root.left != null)
	                Q.add(root.left);
	            if(root.right != null)
	                Q.add(root.right);
	        }
	      //这里是利用二叉搜索树的特点，不会有重复元素出现。时间复杂度降到O(n);
	        for(int i = 0;i < list.size();i++){
	            if(map.containsKey(k - list.get(i)))
	                return true;
	            map.put(list.get(i),1);
	        }
	        return false;
	    }
}
