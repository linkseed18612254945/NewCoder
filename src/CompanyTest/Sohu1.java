package CompanyTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sohu1
{
    public static List<Integer> kolakoski(int[] arr, int n, int m)
    {
        List<Integer> res = new ArrayList<>();
        int indexGroup = 0, insertNum, k = 0;
        int circleNum;
        while (res.size() < n)
        {
            insertNum = arr[k % m];
            if (res.size() <= indexGroup)
                circleNum = insertNum;
            else
                circleNum = res.get(indexGroup);
            for (int j = 0; j < circleNum; j += 1)
                res.add(insertNum);
            indexGroup += 1;
            k += 1;
        }
        return res;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < m; i += 1)
            arr[i] = sc.nextInt();
        List<Integer> res = kolakoski(arr, n, m);
        for (int i = 0;i < n; i += 1)
        {
            if (i != n - 1)
                System.out.println(res.get(i));
            else
                System.out.print(res.get(i));
        }
    }
}
