package math;

/**
 * @author leeray
 * @version 1.0
 * @date 2019/9/20 0020 19:10
 * niuke&leetcode
 * <p>
 * 题目描述
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 */
public class FibonacciMethod {
    //第一种：递归调用，内存占用大，效率低。
    public int Fibonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 1;
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    /**
     * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
     *
     * F(0) = 0,   F(1) = 1
     * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
     * 给定 N，计算 F(N)。
     *
     */
    public int fib(int N) {
        if(N == 0)
            return 0;
        if(N== 1)
            return 1;
        int [] cache = new int[N+1];
        cache[0] = 0;
        cache[1] = 1;
        for(int i = 2;i<=N;i++){
            cache[i] = cache[i-1]+cache[i-2];
        }
        return cache[N];
    }
}
