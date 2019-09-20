package array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author leeray
 * @version 1.0
 * @date 2019/9/20 0020 14:12
 * 575. 分糖果
 * 给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。你需要把这些糖果平均分给一个弟弟和一个妹妹。
 * 返回妹妹可以获得的最大糖果的种类数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/distribute-candies
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DistributeCandies {
    public int distributeCandies(int[] candies) {
        int length = candies.length;
        Set<Integer> set = new HashSet<>();
        for (int candy : candies) {
            set.add(candy);
        }
        int size = set.size();//不重复的个数
        //处理size与length的关系
        return (length / 2) >= size ? size : length / 2;
    }
}
