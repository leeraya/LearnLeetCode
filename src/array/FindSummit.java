package array;

/**
 * @author leeray
 * @version 创建时间：2018年11月19日 下午7:03:20 <br>
 * 			描述：162. 寻找峰值<br>
 * 			峰值元素是指其值大于左右相邻值的元素。
 * 
 *          给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 * 
 *          数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 * 
 *          你可以假设 nums[-1] = nums[n] = -∞。
 */
public class FindSummit {
	public int findPeakElement(int[] nums) {
        int len = nums.length;
        
        if(len == 0) return -1;
        
        if(len == 1) return 0;
        
        if(nums[0] > nums[1]) return 0;
        
        if(nums[len - 1] > nums[len - 2]) return len - 1;
        
        for(int i = 1; i < len - 1; i++){
            if(nums[i] > nums[i - 1] && nums[i] > nums[i + 1])  return i;
        }
        
        return 0;
    }
}
