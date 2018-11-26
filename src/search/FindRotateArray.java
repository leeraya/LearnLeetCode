package search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leeray
 * @version 创建时间：2018年11月26日 下午9:43:16 <br>
 *          描述：154. 寻找旋转排序数组中的最小值 II<br>
 *          假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * 
 *          ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 
 *          请找出其中最小的元素。
 * 
 *          注意数组中可能存在重复的元素。
 * 
 *          示例 1：
 * 
 *          输入: [1,3,5] 输出: 1 <br>
 *          示例 2：
 * 
 *          输入: [2,2,2,0,1] 输出: 0
 */
public class FindRotateArray {
	public int findMin(int[] nums) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(nums[0]);
		// 去除重复的元素再进行查找
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1]) {
				list.add(nums[i]);
			}
		}
		
		int[] tp = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			tp[i] = list.get(i);
		}
		
		int res = tp[0];
		for (int i = 1; i < tp.length; i++) {
			if (tp[i] < tp[i - 1]) {
				return tp[i] < res ? tp[i] : res;
			}
		}
		return res;
	}
	//--------------------------------------//
	public int findMin_2(int[] nums) {

        int res = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < nums[i - 1]){
                return nums[i] < res ? nums[i] : res;
            }
        }
        return res;
    }
}
