package array;

/**
 * @author leeray
 * @version 创建时间：2018年12月14日 下午4:40:37 <br>
 *          描述：605. 种花问题<br>
 *          假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，<br>
 *          它们会争夺水源，两者都会死去。
 * 
 *          给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。 <br>
 *          能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
 */
public class Flowers {
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		int len = flowerbed.length;
		for (int i = 0; i < len; i++) {
			if (canLoad(flowerbed, i)) {
				flowerbed[i] = 1;
				n--;
			}
		}
		return (n <= 0) ? true : false;
	}

	// 编写测定数组指定位置是否可以种树的函数
	private boolean canLoad(int[] nums, int n) {
		if (nums[n] == 1)
			return false;
		int len = nums.length - 1;
		if (nums[n] == 0 && (n - 1 < 0 || nums[n - 1] == 0) && (n + 1 > len || nums[n + 1] == 0)) {
			return true;
		}
		return false;
	}
}
