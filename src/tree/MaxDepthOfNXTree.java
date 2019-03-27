package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author leeray
 * @version 创建时间：2019年3月25日 下午9:34:11 <br>
 *          描述：559. N叉树的最大深度<br>
 *          给定一个 N 叉树，找到其最大深度。
 * 
 *          最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 */
public class MaxDepthOfNXTree {
	public int maxDepthT(Node root) {
		if (root == null)
			return 0;
		// 层次遍历
		Queue<Node> Q = new LinkedList<Node>();
		Q.add(root);
		int level = 0, start = 0, end = 1;
		while (!Q.isEmpty()) {
			Node nd = Q.poll();
			start++;
			for (Node n : nd.children) {
				Q.add(n);
			}
			if (start == end) {
				start = 0;
				end = Q.size();
				level++;
			}
		}
		return level;
	}
	
	public int maxDepth(Node root) {
        if(root == null)
            return 0;
        int level=1;
        for(Node nd : root.children){
            level = Math.max(level,maxDepth(nd)+1);
        }
        return level;
    }
}
