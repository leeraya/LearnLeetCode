package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leeray
 * @version 创建时间：2019年3月27日 上午11:12:13 <br>
 * 			描述：257. 二叉树的所有路径 <br>
 */
public class AllPath {
	List<String> res = new ArrayList<String>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null)
            return res;
        post(root,"");
        return res;
    }
    void post(TreeNode t , String s){
        s =s + String.valueOf(t.val);
        if(t.left != null)
            post(t.left,s+"->");
        if(t.right != null)
            post(t.right,s+"->");
        if(t.left == null && t.right == null)
            res.add(s);
    }
}
