package math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leeray
 * @version 1.0
 * @date 2019/9/19 0019 21:46
 * 401. 二进制手表
 */
public class BinaryWatch {
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<String>();
        //从00:00->12:00遍历每个时间点有多少个1
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (getOneNums(i) + getOneNums(j) == num) {
                    res.add(i + ":" + (j < 10 ? "0" + j : j));
                }
            }
        }
        return res;
    }

    private static int getOneNums(int n) {
        int ret = 0;
        while (n != 0) {
            n = n & (n - 1);//可以知道二进制中有多少个1
            ret++;
        }
        return ret;
    }
}
