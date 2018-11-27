package math;

/**
 * @author leeray
 * @version 创建时间：2018年11月27日 下午8:18:40 <br>
 *          描述：168. Excel表列名称<br>
 *          给定一个正整数，返回它在 Excel 表中相对应的列名称。
 * 
 *          例如，
 * 
 *          1 -> A<br>
 *          2 -> B<br>
 *          3 -> C<br>
 *          ... <br>
 *          26 -> Z<br>
 *          27 -> AA<br>
 *          28 -> AB ...
 */
public class ExcelTitle {
	public String convertToTitle(int n) {
        String temp="";
		  while(n>0) {
			  char s=(char) ((n-1)%26+'A');
			  temp=s+temp;
			  n=(n-1)/26;
		  }
		  return temp;
    }
}
