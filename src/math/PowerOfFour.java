package math;

/**
 * @author leeray
 * @version 创建时间：2018年12月20日 下午4:48:44 <br>
 * 			描述：342. 4的幂<br>
 */
public class PowerOfFour {
	public boolean isPowerOfFour(int num) {
		if(num <= 0)
			return false;
		//注意：== 的优先级比&的优先级要高
		return (num&(num - 1)) == 0 && (num & 0x55555555) == num;
	}
}
