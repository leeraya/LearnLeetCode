package sort;

import java.util.Arrays;

/**
 * @author leeray
 * @version 创建时间：2018年12月14日 上午11:02:17 <br>
 *          描述：215. 数组中的第K个最大元素<br>
 *          在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素
 */
public class KthLargest {
	public int findKthLargest(int[] nums, int k) {
		// sort函数的时间复杂度是nlogn
		Arrays.sort(nums);
		return nums[nums.length - k];
	}

	// --------------------------//
	public int findKthLargest_2(int[] nums, int k) {
		bubbleSort(nums);
		return nums[nums.length - k];
	}

	// 冒泡排序 n^2,时间复杂度太高，效率低下
	private void bubbleSort(int[] a) {
		int len = a.length;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len - i - 1; j++) {// 注意第二重循环的条件
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
	}
	
	//插入排序
	private void insertSort(int [] a){
        int len = a.length;
        int insertNum;
        for(int i = 0; i < len; i++){
            insertNum = a[i];   //保存要插入的数
            int j = i - 1;      //保存之前的已经排好的序列的长度
            while(j >= 0 && a[j] > insertNum){
                //将比insertNum大的数移到后面去
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = insertNum;
        }
    }
	
	//快速排序，时间效率最高
	//划分函数
	private int Partition(int[] r , int left , int right){
		int i = left, j = right;
		while(i < j){
			while(i < j && r[i] <= r[j]) j--;//右侧扫描
			if(i < j){
				int temp = r[i];
				r[i] = r[j];
				r[j] = temp;
				i++;
			}
			
			while(i < j && r[i] <= r[j]) i++;
			if(i < j){
				int temp = r[i];
				r[i] = r[j];
				r[j] = temp;
				j--;
			}
		}
		return i;
	}
	
	//快排函数
	private void quickSort(int [] r, int left, int right){
		int pivot;
		if(left < right){
			pivot = Partition(r,left,right);
			quickSort(r, left, pivot - 1);
			quickSort(r, pivot + 1, right);
		}
	}
}
