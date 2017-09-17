package CompanyTest;

import java.util.Scanner;

public class Meituan2
{
    public static boolean find(int[] arr)
    {
        int max = arr[0];
        int sum = 0;
        for (int i = 1;i < arr.length - 1; i += 1)
        {
            if (arr[i] > max)
                max = arr[i];
            sum += arr[i];
        }
        return max <= sum - max;
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
        boolean res = find(arr);
        System.out.println(res? "Yes": "No");
    }
}
