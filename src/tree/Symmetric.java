package tree;
/**
* @author leeray
* @version 创建时间：2019年3月25日 下午7:16:14
* <br>描述：101. 对称二叉树<br>
* 给定一个二叉树，检查它是否是镜像对称的。

例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

    1
   / \
  2   2
 / \ / \
3  4 4  3
但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

    1
   / \
  2   2
   \   \
   3    3
说明:

如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
*/
public class Symmetric {
	 public boolean isSymmetric(TreeNode root) {
	        return check(root,root);
	    }
	    
	    //对称二叉树的特点？观察观察？
	    boolean check(TreeNode p,TreeNode q){
	        if(p == null && q == null)
	            return true;
	        if(p != null && q != null && p.val == q.val){
	            return check(p.left,q.right)&&check(p.right,q.left);
	        }else{
	            return false;
	        }
	    }
}
