package leetcode;

import java.util.HashMap;

import org.junit.Test;

public class TwoSum {
	/*
	 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
	 * 
	 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
	 * 
	 * 说明:
	 * 返回的下标值（index1 和 index2）不是从零开始的。 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。 
	 * 示例:
	 * 输入: numbers = [2, 7, 11, 15], target = 9 输出: [1,2] 解释: 2 与 7 之和等于目标数 9
	 * 。因此 index1 = 0, index2 = 1 。
	 */
	public int[] twoSum(int[] num,int target){
		int[] res = {-1,-1};//作为查找结果的返回值，初始值为-1和-1代表没找到
		//先做判断，如果数组num的长度小于2或者是直接为空，那么直接退出循环
		if(num.length<2 || num == null){
			return res;
		}
		HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
		//以下用循环将num数组中的值存在map中，边存边检查是否符合target条件
		for(int i = 0;i<num.length;i++){
			if(map.containsKey(target-num[i])){//如果此时存的值与map中已经存在的值加在一起等于target，那么它们符合条件
				res[0] = map.get(target - num[i]);
				res[1] = i;
			}
			map.put(num[i], i);
		}
		return res;
	}
	//测试
	@Test
	public void test1(){
		int array[]={2,7,11,19};
		int res[] = twoSum(array, 9);
		for(int i=0;i<res.length;i++){
			System.out.println(res[i]);
		}
	}
}
