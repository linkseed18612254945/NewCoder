package CompanyTest;

import java.util.ArrayList;
import java.util.Scanner;

public class Lianjia2
{
    public static ArrayList<Integer> sortAndRemove(int n, int[] randomNum)
    {
        int[] numPos = new int[1000];
        for (int i = 0;i < n; i += 1)
        {
            numPos[randomNum[i]] = 1;
        }
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 1000;i += 1)
        {
            if (numPos[i] == 1)
                arr.add(i);
        }
        return arr;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] randomNum = new int[n];
        for (int i = 0;i < n; i += 1)
        {
            randomNum[i] = sc.nextInt();
        }
        ArrayList<Integer> res = sortAndRemove(n, randomNum);
        System.out.println(res.size());
        for (int i = 0; i < res.size(); i += 1)
        {
            if (i == res.size() - 1)
                System.out.print(res.get(i));
            else
                System.out.print(res.get(i) + " ");
        }
    }
}
