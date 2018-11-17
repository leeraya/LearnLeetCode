package array;

import java.util.Arrays;

/**
 * @author leeray
 * @version 创建时间：2018年11月17日 上午11:35:17 
 * 描述：88. 合并两个有序数组<br>
 *          给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。 说明:
 *          初始化 nums1 和 nums2 的元素数量分别为 m 和 n。 你可以假设 nums1 有足够的空间（空间大小大于或等于 m +
 *          n）来保存 nums2 中的元素。
 */
public class CombineTwoArray {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int j = m;
       for(int i = 0; i < n; i++){
    	   nums1[j] = nums2[i];
    	   j++;
       }
       Arrays.sort(nums1);
    }
}
