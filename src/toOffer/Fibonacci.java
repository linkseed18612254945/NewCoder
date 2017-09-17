package toOffer;

public class Fibonacci
{
    public static int fib1(int n)
    {
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
        return fib1(n - 1) + fib1(n - 2);
    }

    public static int fib2(int n)
    {
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2;i <= n; i += 1)
            dp[i] = dp[i - 1] + dp[i - 2];
        return dp[n];
    }

    public static int fib3(int n)
    {
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
        int fibN = 1, firstLast = 0, secondLast = 1;
        for (int i = 2; i <= n; i += 1)
        {
            fibN = firstLast + secondLast;
            firstLast = secondLast;
            secondLast = fibN;
        }
        return fibN;
    }

    public static void main(String[] args)
    {
        int res = fib3(20);
        System.out.println(res);
    }
}
