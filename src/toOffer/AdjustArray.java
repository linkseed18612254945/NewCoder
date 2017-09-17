package toOffer;

import java.util.Arrays;

public class AdjustArray
{

    public static void adjust(int[] arr)
    {
        if (arr == null || arr.length == 0)
            return;
        int i = 0, j = arr.length - 1;
        while (i < j)
        {
            if (arr[i] % 2 == 0)
            {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j -= 1;
            }
            else
                i += 1;
        }
    }

    public static void main(String[] args)
    {
        int[] arr = new int[]{4, 5, 3 ,1, 2, 9, 8, 1, 7, 5, 6,4, 12, 17};
        adjust(arr);
        System.out.print(Arrays.toString(arr));
    }
}
