package BinarySearch;

/**
 * 对于一个有序数组arr，再给定一个整数num，请在arr中找到num这个数出现的最左边的位置。
 给定一个数组arr及它的大小n，同时给定num。请返回所求位置。若该元素在数组中未出现，请返回-1。
 测试样例：
 [1,2,3,3,4],5,3
 返回：2
 */
public class FindLeftNumber
{
    public static int LeftMostAppearance(int[] arr, int n, int m)
    {
        if (arr == null || arr.length == 0)
            return -1;
        int left = 0;
        int right = n - 1;
        while (left <= right)
        {
            int mid = left + (right - left) / 2;
            if (arr[mid] == m)
            {
                while (arr[mid] == m)
                {
                    if (mid == 0)
                        return 0;
                    mid -= 1;
                }
                return mid + 1;
            }
            else if (arr[mid] > m)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args)
    {
        int[] arr = new int[]{1, 2, 3, 3, 4};
        int res = LeftMostAppearance(arr, 5, 3);
        System.out.println(res);
    }
}
