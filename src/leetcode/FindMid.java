package leetcode;

import java.util.*;

/*
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。

     请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。

     你可以假设 nums1 和 nums2 不同时为空。
 */
public class FindMid {
	 public double findMedianSortedArrays(int[] nums1, int[] nums2){
		 if(nums1 == null && nums2 == null) return 0;
		 double mid = 0;	//中位数的值
		 List<Integer> list = new ArrayList<>();	//list用来装两个数组的值
		 //以下两个循环将数组中的值都放入到list中
		 if(nums1 != null){
			 for(int i = 0;i < nums1.length;i++){
				 list.add(nums1[i]);
			 }
		 }
		 if(nums2 != null){
			 for(int j = 0;j < nums2.length;j++){
				 list.add(nums2[j]);
			 }
		 }
		 Collections.sort(list);	//利用Collections的排序函数sort
		 int length = list.size();
		 if(length % 2 == 0){
			 mid = ((double)list.get(length/2)+(double)list.get((length/2)-1))/2;
		 }else{
			 mid = (double)list.get(length/2);
		 }
		return mid;
	 }
}
