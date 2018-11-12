package dynamicProgramming;

import java.util.*;

/**
 * leetcode-120
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
     例如，给定三角形：
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 */
public class TriangleMinValue {
	public int minimumTotal(List<List<Integer>> triangle){
		//思路：倒着求，设高度为height , 先将height-1的每个数与自己的左右孩子相加
		//求得最小值用于更新原来的值，通过循环向上遍历‘
		int height = triangle.size();
		for( int j = height;j > 1; j--){
			//j表示的是层数，内层循环用于取目标节点与其左右孩子节点的值，并求最小和
			for(int i = 0; i < j - 1; i++ ){
				int root = triangle.get(j - 2).get(i);
				int left = triangle.get(j - 1).get(i);
				int right = triangle.get(j - 1).get(i + 1);
				int minTotal = Math.min(root + left, root + right);
				triangle.get(j - 2).set(i, minTotal);
			}
		}
		return triangle.get(0).get(0);
    }
}
