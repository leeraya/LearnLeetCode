package tree;

import java.util.List;

/**
 * @author leeray
 * @version 创建时间：2019年3月23日 下午6:30:47 <br>
 * 			描述：N叉树的节点结构<br>
 */
public class Node {
	public int val;
	public List<Node> children;

	public Node() {
	}

	public Node(int _val, List<Node> _children) {
		val = _val;
		children = _children;
	}
}
