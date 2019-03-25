package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
* @author leeray
* @version 创建时间：2019年3月24日 下午4:46:17
* <br>描述：637. 二叉树的层平均值<br>
* 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.

示例 1:

输入:
    3
   / \
  9  20
    /  \
   15   7
输出: [3, 14.5, 11]
解释:
第0层的平均值是 3,  第1层是 14.5, 第2层是 11. 因此返回 [3, 14.5, 11].
注意：

节点值的范围在32位有符号整数范围内。
*/
public class LevelAverage {
	/**
	 * 这里考察的就是层次遍历了
	 * @param root
	 * @return
	 */
	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> list = new ArrayList<Double>();
        Queue<TreeNode> Q = new LinkedList<TreeNode>();
        Q.add(root);
        while(!Q.isEmpty()){
       	 double sum = 0;//节点值的和
       	 int count = Q.size();//获得此层的节点数目
       	 //遍历此层的所有节点
       	 for(int i = 0; i < count;i++){
       		 root = Q.poll();
       		 sum += root.val;
       		 if(root.left != null)
       			 Q.add(root.left);
       		 if(root.right != null)
       			 Q.add(root.right);
       	 }
       	 list.add(sum / count);
        }
        return list;
	}
}
