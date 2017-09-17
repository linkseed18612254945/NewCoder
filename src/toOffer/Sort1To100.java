package toOffer;

import java.util.Arrays;

public class Sort1To100
{

    public static void sort(int[] arr)
    {
        if (arr == null || arr.length == 0)
            return;
        int max = arr[0], min = arr[0];
        for (int i = 0; i < arr.length;i += 1)
        {
            if (arr[i] > max)
                max = arr[i];
            if (arr[i] < min)
                min = arr[i];
        }
        int[] record = new int[max - min + 1];
        for (int i = 0; i < arr.length; i += 1)
            record[arr[i] - min] += 1;
        for (int k = 0, i = 0; i < record.length; i += 1)
        {
            for (int j = 0; j < record[i]; j += 1)
            {
                arr[k] = i + min;
                k += 1;
            }
        }
    }

    public static void main(String[] args)
    {
        int[] ages = new int[]{12, 21, 22, 11, 33, 22, 23, 23, 24, 24, 26 ,26, 26, 27, 27, 29, 29, 28 ,21, 22, 27};
        sort(ages);
        System.out.println(Arrays.toString(ages));

    }
}
