package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author leeray
 * @version 创建时间：2018年11月26日 下午8:15:54 <br>
 * 			描述：219. 存在重复元素 II<br>
 * 			给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和
 *          j 的差的绝对值最大为 k。
 */
public class ContainsNearbyDuplicate {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length == 0) return false;
        
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i]) && Math.abs(map.get(nums[i]) - i) <= k){
            	return true;
            }
            map.put(nums[i], i);
        }
        return false;	
    }
}
