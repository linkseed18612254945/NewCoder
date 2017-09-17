package DP;

import java.util.HashMap;

/**
 * 有数组penny，penny中所有的值都为正数且不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意张，再给定一个整数aim(小于等于1000)代表要找的钱数，求换钱有多少种方法。
 给定数组penny及它的大小(小于等于50)，同时给定一个整数aim，请返回有多少种方法可以凑成aim。
 测试样例：
 [1,2,4],3,3
 返回：2
 */
public class MoneyChange
{
    static private class Change
    {
        int index;
        int aim;
        Change(int index, int aim)
        {
            this.index = index;
            this.aim = aim;
        }
    }

    static HashMap<Change, Integer> changeMemo = new HashMap<>();
    static int[][] changeMatrix;

    public static int recursiveChange(int aim, int[] arr)
    {
        if (aim <= 0 || arr == null || arr.length == 0)
            return 0;
        changeMatrix = new int[arr.length][aim + 1];
        return recursiveChangeHelperWithMemo(aim, arr, 0);
    }

    private static int recursiveChangeHelper(int aim, int[] arr, int x)
    {
        if (x == arr.length - 1)
        {
            if (aim % arr[x] == 0)
                return 1;
            else
                return 0;
        }
        int total = 0;
        for (int i = 0; i * arr[x] <= aim; i += 1)
            total += recursiveChangeHelper(aim - (i * arr[x]), arr, x + 1);
        return total;
    }

    private static int recursiveChangeHelperWithMemo(int aim, int[] arr, int x)
    {
        if (x == arr.length - 1)
        {
            if (aim % arr[x] == 0)
                return 1;
            else
                return 0;
        }
        if (changeMatrix[x][aim] != 0)
            return changeMatrix[x][aim];
        int total = 0;
        for (int i = 0; i * arr[x] <= aim; i += 1)
            total += recursiveChangeHelperWithMemo(aim - (i * arr[x]), arr, x + 1);
        changeMatrix[x][aim] = total;
        return total;
    }

    public static int DPChange(int aim, int[] arr)
    {
        int[][] dp = new int[arr.length][aim + 1];
        for (int i = 0; i < arr.length; i += 1)
        {
            for (int j = 0; j <= aim; j += 1)
            {
                if (j == 0)
                {
                    dp[i][j] = 1;
                    continue;
                }
                if (i == 0)
                {
                    dp[i][j] = j % arr[i] == 0 ? 1: 0;
                    continue;
                }
                for (int k = 0; k * arr[i] <= j; k += 1)
                {
                    dp[i][j] += dp[i - 1][j - k * arr[i]];
                }
            }
        }
        return dp[arr.length - 1][aim];
    }

    public static void main(String[] args)
    {
        int[] arr = new int[]{3, 4, 7};
        int aim = 33;
        int res = DPChange(aim, arr);
        System.out.println(res);
    }
}
