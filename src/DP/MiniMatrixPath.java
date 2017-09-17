package DP;

/**
 * 有一个矩阵map，它每个格子有一个权值。从左上角的格子开始每次只能向右或者向下走，最后到达右下角的位置，路径上所有的数字累加起来就是路径和，返回所有的路径中最小的路径和。
 给定一个矩阵map及它的行数n和列数m，请返回最小路径和。保证行列数均小于等于100.
 测试样例：
 [[1,2,3],[1,1,1]],2,3
 返回：4
 */
public class MiniMatrixPath
{
    public static int getPathMin(int[][] mat, int n, int m)
    {
        int[][] dp = new int[n][m];
        dp[0][0] = mat[0][0];
        for (int i = 0; i < n; i += 1)
        {
            for (int j = 0; j < m; j += 1)
            {
                if (i == 0 && j == 0)
                    continue;
                if (i == 0)
                    dp[i][j] = dp[i][j - 1] + mat[i][j];
                else if (j == 0)
                    dp[i][j] = dp[i - 1][j] + mat[i][j];
                else
                    dp[i][j] = Math.min(dp[i - 1][j] , dp[i][j - 1]) + mat[i][j];
            }
        }
        return dp[n - 1][m - 1];
    }

    public static void main(String[] args)
    {
        int[][] mat = new int[][]{{1,2,3}, {1,1,1}};
        int n = 2, m = 3;
        int res = getPathMin(mat, n, m);
        System.out.println(res);
    }
}
