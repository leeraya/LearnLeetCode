package math;

/**
 * @author leeray
 * @version 创建时间：2018年12月22日 下午4:24:24 <br>
 * 			描述：367. 有效的完全平方数<br>
 * 			给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 * 
 *          说明：不要使用任何内置的库函数，如 sqrt。
 */
public class ValidSqrt {
	public boolean isPerfectSquare(int num) {
        if(num <= 1) return true;
        int i = 2;
        while(i * i != num){
            if(i * i > num || Integer.MAX_VALUE / i < i){
                return false;
            }
            i++;
        }
        return true;
    }
}
