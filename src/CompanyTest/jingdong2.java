package CompanyTest;

import java.util.Scanner;

public class jingdong2
{
    public static int totalCase(int n)
    {
        int sum = 0;
        for (int a = 1; a <= n; a += 1)
        {
            for (int b = 1; b <= n; b += 1)
            {
                for (int c = 1; c <= n; c += 1)
                {
                    for (int d = 1; d <= n; d += 1)
                    {
                        if (Math.pow(a, b) == Math.pow(c, d))
                            sum += 1;
                    }
                }
            }
        }
        return sum % 1000000007;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = totalCase(n);
        System.out.println(res);
    }
}
