package DP;

/**
 * 给定两个字符串A和B，返回两个字符串的最长公共子序列的长度。例如，A="1A2C3D4B56”，B="B1D23CA45B6A”，”123456"或者"12C4B6"都是最长公共子序列。
 给定两个字符串A和B，同时给定两个串的长度n和m，请返回最长公共子序列的长度。保证两串长度均小于等于300。
 测试样例：
 "1A2C3D4B56",10,"B1D23CA45B6A",12
 返回：6
 */
public class LCS
{

    public static int getLCS(String A, int n, String B, int m)
    {
        int[][] dp = new int[n + 1][m + 1];
        boolean iFlag = false, jFlag = false;
        for (int i = 1; i <= n; i += 1)
        {
            for (int j = 1; j <= m; j += 1)
            {
                if (i == 1)
                {
                    if (iFlag)
                        dp[1][j] = 1;
                    else if (A.charAt(0) == B.charAt(j - 1))
                    {
                        dp[1][j] = 1;
                        iFlag = true;
                    }
                }
                else if (j == 1)
                {
                    if (jFlag)
                        dp[i][1] = 1;
                    else if (B.charAt(0) == A.charAt(i - 1))
                    {
                        dp[i][1] = 1;
                        jFlag = true;
                    }
                }
                else
                {
                    int temp1 = 0, temp2;
                    if (A.charAt(i - 1) == B.charAt(j - 1))
                        temp1 = dp[i - 1][j - 1] + 1;
                    temp2 = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    dp[i][j] = Math.max(temp1, temp2);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args)
    {
        String A = "zynnqufc";
        int n = 8;
        String B = "ddbauhkw";
        int m = 8;
        int res = getLCS(A, n, B, m);
        System.out.println(res);
    }
}
