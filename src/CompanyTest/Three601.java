package CompanyTest;

import java.util.Scanner;

/**
 * 分装粉笔
 时间限制：C/C++语言 2000MS；其他语言 4000MS
 内存限制：C/C++语言 65536KB；其他语言 589824KB
 题目描述：
 小明一共有n根彩色粉笔，m根白色粉笔，现在可以用a根彩色粉笔和b根白色粉笔组成一盒卖x元，或者c根白色粉笔组成一盒卖y元，或者d根彩色粉笔组成一盒卖z元，小明最多可以用这些粉笔卖多少元？不一定要把所有粉笔卖完，小明只希望利益最大化。
 输入
 第一行2个整数n，m，1≤n,m≤2000；
 第二行4个整数a，b，c，d，1≤a,b,c,d≤1000；
 第三行3个整数x，y，z，1≤x,y,z≤1000。
 输出
 输出一个整数，表示最多可以卖到多少元。

 样例输入
 5 5
 1 2 3 3
 2 1 3
 样例输出
 7
 */
public class Three601
{
    public static int maxValue(int n, int m, int a, int b, int c, int d, int x, int y, int z)
    {
        int p, q;
        p = (m / b) * x + ((n - (m / b) * a) / (a + d)) * z;
        q = (m / c) * y + ((n - (m / c) * a) / (a + d)) * z;

        return Math.max(p, q);
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();

        int res = maxValue(n, m, a, b, c, d, x, y, z);
        System.out.println(res);
    }
}
