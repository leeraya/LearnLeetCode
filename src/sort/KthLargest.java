package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.junit.Test;

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

	// 插入排序
	private void insertSort(int[] a) {
		int len = a.length;
		int insertNum;
		for (int i = 0; i < len; i++) {
			insertNum = a[i]; // 保存要插入的数
			int j = i - 1; // 保存之前的已经排好的序列的长度
			while (j >= 0 && a[j] > insertNum) {
				// 将比insertNum大的数移到后面去
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = insertNum;
		}
	}

	// 快速排序，时间效率最高
	// 划分函数
	private int Partition(int[] r, int left, int right) {
		int i = left, j = right;
		while (i < j) {
			while (i < j && r[i] <= r[j])
				j--;// 右侧扫描
			if (i < j) {
				int temp = r[i];
				r[i] = r[j];
				r[j] = temp;
				i++;
			}

			while (i < j && r[i] <= r[j])
				i++;
			if (i < j) {
				int temp = r[i];
				r[i] = r[j];
				r[j] = temp;
				j--;
			}
		}
		return i;
	}

	// 快排函数
	private void quickSort(int[] r, int left, int right) {
		int pivot;
		if (left < right) {
			pivot = Partition(r, left, right);
			quickSort(r, left, pivot - 1);
			quickSort(r, pivot + 1, right);
		}
	}

	// 计数排序
	private void CountNumSort(int[] a) {
		int maxn = Integer.MIN_VALUE;
		// 先要求得绝对值最大的数，以它为界限
		for (int i = 0; i < a.length; i++) {
			maxn = Math.max(maxn, Math.abs(a[i]));
		}
		int temp1[] = new int[maxn + 1];
		int temp2[] = new int[maxn + 1];
		// 要考虑负数的情况，此时要使用temp2来装负数
		for (int i = 0; i < a.length; i++) {
			if (a[i] >= 0) {
				temp1[a[i]]++;
			} else {
				temp2[Math.abs(a[i])]++;
			}
		}
		int index = 0;
		for (int i = temp2.length - 1; i >= 0; i--) {
			while (temp2[i] > 0) {
				a[index] = i * (-1);
				index++;
				temp2[i]--;
			}
		}
		for (int i = 0; i < temp1.length; i++) {
			while (temp1[i] > 0) {
				a[index] = i;
				index++;
				temp1[i]--;
			}
		}
	}

	// 桶排序,第一种分桶策略
	public void bucketSort(int[] arr) {

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
			min = Math.min(min, arr[i]);
		}

		// 桶数
		int bucketNum = (max - min) / arr.length + 1;
		ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
		for (int i = 0; i < bucketNum; i++) {
			bucketArr.add(new ArrayList<Integer>());
		}

		// 将每个元素放入桶
		for (int i = 0; i < arr.length; i++) {
			int num = (arr[i] - min) / (arr.length);
			bucketArr.get(num).add(arr[i]);
		}

		// 对每个桶进行排序
		for (int i = 0; i < bucketArr.size(); i++) {
			Collections.sort(bucketArr.get(i));
		}

		// 4.合并数据
		int j = 0;
		for (ArrayList<Integer> aa : bucketArr) {
			for (int i : aa) {
				arr[j++] = i;
			}
		}
	}

	// 桶排序，第二种分桶策略
	public void bucketSort_2(int[] A) {
		// 1. 构造桶
		// 1.1 确定桶的个数n
		int n = A.length;
		// 1.2 声明并初始化一个List，存放链表；
		List<ArrayList<Integer>> Blist = new ArrayList<>(n);
		for (int i = 0; i < n; i++)
			Blist.add(new ArrayList<Integer>());
		// 2.将数组中的元素放到桶中
		// 2.1 确定元素的最值
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int a : A) {
			max = Math.max(max, a);
			min = Math.min(min, a);
		}
		// 2.2 确定每个元素放入桶的编号并放进去
		for (int i : A) {
			// 加1是为了保证index< A.length，防止程序抛出IndexOutofBoundsEx;
			int index = (int) ((i - min) / (max - min + 1.0) * A.length);
			// 2.2.2 放入对应的桶中
			Blist.get(index).add(i);
		}
		// 3.桶内排序
		for (int i = 0; i < Blist.size(); i++) {
			Collections.sort(Blist.get(i));
		}
		// 4.合并数据
		int j = 0;
		for (ArrayList<Integer> arr : Blist) {
			for (int i : arr) {
				A[j++] = i;
			}
		}
	}

	/*
	 * 计数排序虽然时间复杂度只有O(n),但是它要占用很多空间，空间复杂度往往会很大。
	 */
	@Test
	public void test1() {
		int array[] = new int[1000];
		for (int i = 0; i < 100; i++) {
			array[i] = new Random().nextInt(100);
		}
		long start = System.nanoTime();
//		CountNumSort(array);
//		 quickSort(array, 0, array.length - 1);
		 bucketSort(array);
//		 bucketSort_2(array);
		long end = System.nanoTime();
		System.out.println((end - start) / 1000);
		/*
		 * for(int a : array){ System.out.print(a+"\t"); }
		 */
	}
}
