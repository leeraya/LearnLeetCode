package array;

/**
 * @author leeray
 * @version 创建时间：2018年11月20日 下午3:37:23 <br>
 *          描述：55. 跳跃游戏<br>
 *          给定一个非负整数数组，你最初位于数组的第一个位置。
 * 
 *          数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 
 *          判断你是否能够到达最后一个位置。
 * 
 *          示例 1:
 * 
 *          输入: [2,3,1,1,4] 输出: true 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。 <br>
 *          示例 2:
 * 
 *          输入: [3,2,1,0,4] 输出: false 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ，
 *          所以你永远不可能到达最后一个位置。
 */
public class JumpGame {
	public boolean canJump(int[] nums) {
		int len = nums.length;
		int sum = 0;	//sum表示当前所能达到的最远的距离
		for (int i = 0; i < len; i++) {
			sum = Math.max(sum, i + nums[i]);
			if (sum <= i && i != len - 1)	//sum <= i 表示不能往前面走了
				return false;
		}
		return true;
	}
}
