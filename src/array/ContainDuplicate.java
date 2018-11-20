package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author leeray
 * @version 创建时间：2018年11月20日 上午10:11:45 <br>
 * 			描述：217. 存在重复元素<br>
 * 			给定一个整数数组，判断是否存在重复元素。
 * 
 *          如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 */
public class ContainDuplicate {
	/*
	 * hash
	 */
	public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length <= 1) return false;
        int len = nums.length;
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < len; i++){
            if(set.contains(nums[i])){
                return true;
            }else{
                set.add(nums[i]);
            }
        }
        return false;
    }
	/*
	 * 排序，然后判断相邻元素是否相等
	 */
	public boolean containsDuplicate_2(int[] nums) {
        if(nums == null || nums.length <= 1) return false;
        Arrays.sort(nums);
        int len = nums.length;
        
        for(int i = 0; i < len - 1; i++){
            if(nums[i] == nums[i + 1]) return true;
        }
        return false;
    }
}
