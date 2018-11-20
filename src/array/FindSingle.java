package array;
/**
* @author leeray
* @version 创建时间：2018年11月20日 下午5:14:34
* <br>描述：136. 只出现一次的数字<br>
*/
public class FindSingle {
	public static int singleNumber(int[] nums) {        
        int result=0;
        for(int i=0;i<nums.length;i++){
            result^=nums[i];
        }
        return result;
    }
}
