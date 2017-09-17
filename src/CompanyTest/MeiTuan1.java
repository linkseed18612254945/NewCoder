package CompanyTest;

import java.util.Scanner;

public class MeiTuan1
{
    public static int theK(int[] arr, int n, int k)
    {
        if (arr == null || arr.length == 0|| n == 0)
            return 0;
        int sum, maxL = 0, l;
        for (int i = 0; i < n; i += 1)
        {
            sum = 0;
            l = 0;
            for (int j = i; j < n; j += 1)
            {
                sum += arr[j];
                if (sum % k == 0)
                    l = j - i + 1;
            }
            if (l > maxL)
                maxL = l;
            if (maxL >= n - i)
                return maxL;
        }
        return maxL;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0;i < n; i += 1)
        {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int res = theK(arr, n, k);
        System.out.println(res);
    }
}
