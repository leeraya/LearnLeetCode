package math;
/**
* @author leeray
* @version 创建时间：2018年12月26日 下午3:41:15
* <br>描述：191. 位1的个数<br>
*/
//必须将n看成是一个二进制数来解题
public class BitOne {
	public int hammingWeight(int n) {
        int count = 0;
        while(n != 0){
        	/*
        	 * n&(n-1)会发生什么？
        	 * 假设二进制n : 10011 , 那么n-1就是 10010
        	 * 对位相与&
        	 * 	10011
        	 * &10010
        	 * 	10010
        	 * 结果就是把n的最低位1去除了
        	 */
            n &= (n-1);
            count++;
        }
        return count;
    }
}
