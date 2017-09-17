package BinarySearch;

import java.util.Arrays;

public class SortedArraySearch
{
    public static int binarySearch(int[] arr, int m)
    {
        int left = 0;
        int right = arr.length - 1;
        int mid;
        while (left <= right)
        {
            mid = left + (right - left) / 2;
            if (arr[mid] == m)
                return mid;
            else if (arr[mid] < m)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args)
    {
        int[] arr = new int[]{2, 3, 1, 4, 5, 6, 7, 2, 3, 12, 9, 8};
        Arrays.sort(arr);
        System.out.println(binarySearch(arr, 2));
    }
}
