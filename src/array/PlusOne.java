package array;

/**
 * @author leeray
 * @version 创建时间：2018年11月17日 下午5:45:49 <br>
 * 			描述：66. 加一<br>
 * 			给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 
 *          最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * 
 *          你可以假设除了整数 0 之外，这个整数不会以零开头。
 */
public class PlusOne {
	public int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]<9){
                digits[i]+=1;
                return digits;
            }
            digits[i]=0;
        }
        int[] result=new int[digits.length+1];
        result[0]=1;
        return result;
    }
}
