package BinarySearch;

/**
 * 如果更快的求一个整数k的n次方。如果两个整数相乘并得到结果的时间复杂度为O(1)，得到整数k的N次方的过程请实现时间复杂度为O(logN)的方法。
 给定k和n，请返回k的n次方，为了防止溢出，请返回结果Mod 1000000007的值。
 测试样例：
 2,3
 返回：8
 */
public class QuickPower
{
    public static int getPowerRecursive(int m, int n)
    {
        if (n == 0)
            return 1;
        if (n == 1)
            return m;
        if (n % 2 == 0)
            return getPowerRecursive(m * m, n / 2);
        else
            return getPowerRecursive(m * m, (n - 1) / 2) * m;
    }

    public static int getPower(int m, int n)
    {
        long remain = 1L;
        long temp = m;
        while (n != 1){
            if (n % 2 == 1){
                remain *= temp;
                n -= 1;
            }
            temp = temp * temp;
            n /= 2;
        }
        return (int) (remain * temp);
    }

    public static void main(String[] args)
    {
        int m = 2;
        int n = 14;
        int res = getPower(m, n);
        System.out.println(res);
    }
}
