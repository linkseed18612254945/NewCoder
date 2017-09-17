package Others;

import java.util.Arrays;

public class HorseRace
{
    public static int winMost(int[] oppo, int[] horses, int n)
    {
        Arrays.sort(oppo);
        Arrays.sort(horses);
        for (int i = 0, j = 0;i < n; i += 1, j += 1)
        {
            int oppoHorse = oppo[i];
            while (horses[j] <= oppoHorse)
            {
                j += 1;
            }
            if (j == n - 1) return j;
        }
        return n;
    }

    public static void main(String[] args)
    {
        int[] oppo = {1, 2, 3};
        int[] horses = {1, 2, 3};
        int res = winMost(oppo, horses, 3);
        System.out.println(res);
    }
}
