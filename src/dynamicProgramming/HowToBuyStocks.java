package dynamicProgramming;

/**
 * 
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * 
 * 注意你不能在买入股票前卖出股票。
 * 
 * 示例 1:
 * 
 * 输入: [7,1,5,3,6,4] 输出: 5 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出， 最大利润
 * = 6-1 = 5 。 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 *
 */
public class HowToBuyStocks {
	//暴力法
	public int maxProfit(int[] prices) {
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < prices.length - 1; i++){
            for(int j = i + 1;j < prices.length; j++){
                maxSum = Math.max(prices[j] - prices[i] , maxSum);
            }
        }
        if(maxSum < 0) return 0;
        return maxSum;
    }
	//-------动态规划法--------------------------------//
	//思想就是只进行一次数组遍历，在遍历过程中确定在当前情况下的最小股价，然后求当前最大利润。
	public int maxProfit_2(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }
}
