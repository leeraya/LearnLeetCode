package array;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author leeray
 * @version 创建时间：2018年12月11日 下午3:57:42 <br>
 * 			描述：118. 杨辉三角<br>
 * 			给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。在杨辉三角中，每个数是它左上方和右上方的数的和。
 */
public class YangHuiTriangle1 {
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows <= 0) return res;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            list.add(1);
            for (int j = list.size() - 2; j > 0; j--) {
                list.set(j, list.get(j) + list.get(j - 1));
            }
            res.add(new ArrayList<>(list));
        }
        return res;
    }
	
	@Test
	public void test1(){
		List<List<Integer>> res = generate(5);
		System.out.println(res);
	}
}
