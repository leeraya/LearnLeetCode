package dynamicProgramming;

/**
 * 
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 */
/*
 * 台阶数 -----方法数
 *  1           1
 *  2           2
 *  3           3
 *  4           5
 *  5           8
 */
public class Stairs {
	//斐波那契数列问题。考虑递归，
	public int climbStairs(int n) {
		if(n == 1) return 1;
		if(n == 2) return 2;
		int [] nums = new  int[n + 1];
		nums[1] = 1; nums[2] = 2;
		climb(nums , n);
		return nums[n];
	}
	
	private void climb(int [] nums , int n){
		int x = n - 1, y = n - 2;
		if(x > 2 && nums[x] == 0){
			climb(nums,x - 1);
		}
		if(y > 2 && nums[y] == 0){
			climb(nums,y - 1);
		}
		//为了避免重复计算num[n],当nums[n]已经被计算过之后，直接使用即可
		nums[n] = nums[x] + nums[y];
	}
	//---------------------------------------//
	 public int climbStairs_2(int n) {
	        return climb(n);
	    }
	    /**
	    *f(n) = f(n-1) + f(n-2);
	    * f(0) = 1, f(1) = 2
	    */
	    private int climb(int n) {
	        if (n == 1) {
	            return 1;
	        }
	        if (n == 2) {
	            return 2;
	        }
	        int[] cache = new int[n];
	        cache[0] = 1;
	        cache[1] = 2;
	        for (int i = 2; i < n; i++) {
	            cache[i] = cache[i-1] + cache[i-2];
	        }
	        return cache[n-1];
	    }
}
