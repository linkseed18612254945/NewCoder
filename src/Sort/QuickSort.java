package Sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort
{

    public static void sort(int[] arr)
    {
        if (arr == null || arr.length == 0)
            return;
        Random random = new Random();
        quickSort(arr, 0, arr.length - 1, random);
    }

    private static void quickSort(int[] arr, int lo, int hi, Random random)
    {
        if (lo >= hi)
            return;
        int pos = random.nextInt(hi - lo + 1) + lo;
        int[] bounds = partition(arr, lo, hi, pos);
        if (bounds[0] >= lo)
            quickSort(arr, lo, bounds[0], random);
        if (bounds[1] <= hi)
            quickSort(arr, bounds[1], hi, random);
    }

    private static int[] partition(int[] arr, int lo, int hi, int pos)
    {
        int i = lo, j = hi, k = lo;
        int key = arr[pos];
        while (k <= j)
        {
            if (arr[k] < key)
            {
                swap(arr, k, i);
                i += 1;
                k += 1;
            }
            else if (arr[k] > key)
            {
                swap(arr, k, j);
                j -= 1;
            }
            else
                k += 1;
        }
        return new int[]{i - 1, j + 1};
    }

    private static void swap(int[] arr, int x, int y)
    {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void main(String[] args)
    {
        int[] test1 = new int[]{7,3,2,6,4,1,0,19,2,13,8,5};
        int[] test2 = new int[]{1,1,1,1,1,1,1,3,1,1,1,1,1};
        sort(test1);
        System.out.println(Arrays.toString(test1));
    }
}
