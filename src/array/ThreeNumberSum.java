package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * 15. 三数之和<br>
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0
 * ？找出所有满足条件且不重复的三元组。
 * 
 * 注意：答案中不可以包含重复的三元组。
 * 
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 
 * 满足要求的三元组集合为： [ [-1, 0, 1], [-1, -1, 2] ]
 */

public class ThreeNumberSum {
	public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
    	int n = nums.length;
    	Arrays.sort(nums);
    	for(int i=0;i<n;i++){
    		//排除重复
    		if(i!=0 && nums[i]==nums[i-1]) continue;
    		int sum = 0;
    		int p = i+1,q = n-1;
    		while(p<q){
    			sum = nums[i]+nums[p]+nums[q];
    			if(sum==0){
    				List<Integer> item = new ArrayList<Integer>();
    				item.add(nums[i]);
    				item.add(nums[p]);
    				item.add(nums[q]);
    				list.add(item);
    				while(++p<q && nums[p-1]==nums[p]){
    					
    				}
    				while(--q>p && nums[q+1]==nums[q]){
    					
    				}
    			}
    			else if(sum>0){
    				q--;
    			}
    			else{
    				p++;
    			}
    		}
    	}
    	return list;
    }
}
