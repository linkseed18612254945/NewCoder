package DP;

import static ArrangeAndCombine.ArrangeAndCombine.combineNumber;

/**
 有n级台阶，一个人每次上一级或者两级，问有多少种走完n级台阶的方法。为了防止溢出，请将结果Mod 1000000007
 给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100000。
 测试样例：
 1
 返回：1
 */
public class GoUpstairs
{
    private final static int MOD = 1000000007;

    public static int countSteps(int n)
    {
        if (n == 0)
            return 0;
        int total = 0, step;
        for (int i = 0; i <= n; i += 1)
        {
            step = (n - i) % 2 == 0 ? (n - i) / 2 : 0;
            if (n - i == 0)
                total += 1;
            else if (step != 0)
                total += combineNumber(step, step + i);
        }
        return total;
    }


    public static int DPCount(int n)
    {
        int[][] dp = new int[2][n + 1];
        for (int i = 0; i < 2; i += 1)
        {
            for (int j = 1; j <= n; j += 1)
            {
                if (j == 1)
                {
                    dp[i][j] = 1;
                    continue;
                }
                if (i == 0)
                {
                    dp[i][j] = 1;
                    continue;
                }
                if (j == 2)
                {
                    dp[i][j] = 2;
                    continue;
                }
                dp[i][j] = (dp[i][j - 1] + dp[i][j - 2]) % MOD;
            }
        }
        return dp[1][n];
    }


    public static void main(String[] args)
    {
        int n = 36196;
        int res = DPCount(n);
        System.out.println(res);
    }
}
