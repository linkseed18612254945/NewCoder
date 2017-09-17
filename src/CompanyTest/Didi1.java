package CompanyTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Didi1
{
    public static int maxSum(List<Integer> arr)
    {
        if (arr == null || arr.size() == 0)
            return 0;
        int n = arr.size();
        int[] dp = new int[n];
        int max = arr.get(0);
        for (int i = 0; i < n; i += 1)
        {
            if (i == 0)
                dp[i] = arr.get(i);
            else
            {
                dp[i] = Math.max(arr.get(i), dp[i-1] + arr.get(i));
                if (dp[i] > max)
                    max = dp[i];
            }
        }
        return max;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        List<Integer> arr = new ArrayList<>();
        while (sc.hasNext())
        {
            arr.add(sc.nextInt());
        }
        int res = maxSum(arr);
        System.out.println(res);
    }
}
