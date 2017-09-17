package DP;

/**
 * 一个背包有一定的承重cap，有N件物品，每件都有自己的价值，记录在数组v中，也都有自己的重量，记录在数组w中，每件物品只能选择要装入背包还是不装入背包，要求在不超过背包承重的前提下，选出物品的总价值最大。
 给定物品的重量w价值v及物品数n和承重cap。请返回最大总价值。
 测试样例：
 [1,2,3],[1,2,3],3,6
 返回：6
 */
public class ZeroOneBag
{
    public static int getMaxValue(int[] w, int[] v, int n, int cap)
    {
        int[][] dp = new int[n][cap + 1];
        for (int i = 0; i < n; i += 1)
        {
            for (int j = 0;j <= cap; j += 1)
            {
                if (i == 0)
                    dp[i][j] = j >= w[i] ? v[i]: 0;
                else if (j >= w[i])
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n - 1][cap];
    }

    public static void main(String[] args)
    {
        int[] w = new int[]{1, 2, 3};
        int[] v = new int[]{1, 2, 3};
        int n = 3;
        int cap = 6;
        int res = getMaxValue(w, v, n, cap);
        System.out.println(res);
    }
}
