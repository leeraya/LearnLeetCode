package array;

/**
 * @author leeray
 * @version 创建时间：2018年12月13日 下午3:58:46 <br>
 *          描述：581. 最短无序连续子数组<br>
 *          给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 
 *          你找到的子数组应是最短的，请输出它的长度。 <br/>
 *          示例 1: 输入: [2, 6, 4, 8, 10, 9, 15] 输出: 5 解释: 你只需要对 [6, 4, 8, 10, 9]
 *          进行升序排序，那么整个表都会变为升序排序。 说明 :
 * 
 *          输入的数组长度范围在 [1, 10,000]。 输入的数组可能包含重复元素 ，所以升序的意思是<=。
 */

/*
 * 要找到这个子数组的范围，先要了解这个范围的beg 和 end 是如何定义的。
 * 
 * 来看这个例子：1 3 5 7 2 4 5 6
 * 
 * a. 当我们找到第一个违反ascending 排序的数字 2的时候，我们不能是仅仅把beg
 * 标记为2的前面一个数字7，而是要一直往前，找到一个合适的位置，找到在最前面位置的比2大的数字，这里是3。
 * 
 * b. 同样的，为了找end， 那么我们要从7的后面开始找，一直找到一个最后面位置的比7小的数字，这里是6。
 * 这样的话，范围就是3到6 是我们要找的子数组。把3到6排序完了之后，整个array 就已经是排序的了。
 * 
 * 
 */
public class ShortestUnsortedContinuousSubarray {
	public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int beg = -1;
        int end = -2; // end is -2 is because it works if the array is already in ascending order
        int min = nums[n-1]; // from right to left
        int max = nums[0];      // from left to right
        
        for(int i=0; i<n; i++)
        {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[n-1-i]);
            
            if(nums[i] < max)
                end = i;
            if(nums[n-1-i] > min)
                beg = n-1-i;
        }
        
        return end - beg + 1; // if array is already in ascending order, -2 - (-1) + 1 = 0
    }
}
