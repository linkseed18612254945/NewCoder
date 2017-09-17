package CompanyTest;

import java.util.Scanner;

public class Lianjia3
{
    public static int minExchange(int n, int[] priorityArr)
    {
        int last = priorityArr[0], current;
        int totalExchange = 0;
        for (int i = 1; i < n; i += 1)
        {
            current = priorityArr[i];
            if (last - current > 0)
                totalExchange += last - current;
            last = current;
        }
        return totalExchange;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] priorityArr = new int[n];
        for (int i = 0; i < n; i += 1)
            priorityArr[i] = sc.nextInt();
        int res = minExchange(n, priorityArr);
        System.out.print(res);
    }
}
