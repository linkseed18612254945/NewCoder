package CompanyTest;

import DP.LIS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sohu2
{
    static class Mine
    {
        int[] mineNumber = new int[6];

        boolean isAllZero()
        {
            return mineNumber[0] == 0 && mineNumber[1] == 0 &&
                    mineNumber[2] == 0 && mineNumber[3] == 0 &&
                    mineNumber[4] == 0 && mineNumber[5] == 0;
        }
    }

    public static int best(Mine mine)
    {
        int res = 0;
        int[] arr = mine.mineNumber;
        int remain;
        for (int i = 5; i >= 0; i -= 1)
        {
            if (arr[i] <= 0)
                continue;
            if (i == 5)
                res += arr[i];
            if (i == 4)
            {
                res += arr[i];
                arr[0] = arr[0] - arr[i] * 11;
            }
            if (i == 3)
            {
                res += arr[i];
                arr[1] = arr[1] - arr[i] * 5;
                if (arr[1] < 0)
                    arr[0] = arr[0] + arr[1] * 4;
            }
            if (i == 2)
            {
                res += arr[i] / 4;
                remain = arr[i] % 4;
                arr[1] = arr[1] - remain;
                arr[0] = arr[0] - remain * 5;
            }
            if (i == 1)
            {
                res += arr[i] / 9 + 1;
                remain = arr[i] % 9;
                arr[0] = arr[0] - remain * 4;
            }

            if (i == 0)
            {
                res += arr[i] / 36 + 1;
            }
        }
        return res;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        List<Mine> mines = new ArrayList<>();
        while (true)
        {
            Mine newMine = new Mine();
            for (int i = 0;i < 6; i += 1)
                newMine.mineNumber[i] = sc.nextInt();
            if (newMine.isAllZero())
                break;
            mines.add(newMine);
        }
        for (int i = 0;i < mines.size(); i += 1)
        {
            System.out.println(best(mines.get(i)));
        }
    }
}
