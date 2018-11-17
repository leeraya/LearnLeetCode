package array;

/**
 * @author leeray
 * @version 创建时间：2018年11月17日 上午11:07:48 描述：11. 盛最多水的容器<br>
 *          给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i
 *          的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *          说明：你不能倾斜容器，且 n 的值至少为 2。
 */
public class WaterContainer {
	public int maxArea(int[] height) {
		//双指针法，从两边到中间遍历
		//问题：如何移动双指针才能遍历到最大的容量呢
		/*
		 * 假设：此时left < right right指向某点，且height[right] > height[left],此时right左移
		 * 1.若height[right - 1] > height[left] 那么容器底变短，高度不变（木桶效应 ）总容量变小
		 * 2.若height[right - 1] = height[left] 那么容器底变短，高度不变，总容量变小
		 * 3.height[right - 1] < height[left] 那么容器底变短，高度变矮，总容量变小
		 * 所以得出结论，应该移动较短一边
		 */
		int left = 0, right = height.length - 1, max = 0;
		while(left < right){
			max = Math.max(max, Math.min((right - left) * height[right], (right - left) * height[left]));
			//移动较短的一边
			if(height[left] < height[right]){
				left++;
			}else{
				right--;
			}
		}
		return max;
	}
}
