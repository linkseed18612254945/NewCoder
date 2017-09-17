package BinarySearch;

/**
 * 对于一个有序循环数组arr，返回arr中的最小值。有序循环数组是指，有序数组左边任意长度的部分放到右边去，右边的部分拿到左边来。比如数组[1,2,3,3,4]，是有序循环数组，[4,1,2,3,3]也是。
 给定数组arr及它的大小n，请返回最小值。
 测试样例：
 [4,1,2,3,3],5
 返回：1
 */
public class CircleSortArrayMin
{
    public static int getMin(int[] arr)
    {
        int left = 0;
        int right = arr.length - 1;
        while (left < right)
        {
            if (left + 1 == right)
                return Math.min(arr[left], arr[right]);
            int mid = left + (right - left) / 2;
            if (arr[mid] < arr[mid - 1])
                return arr[mid];
            if (arr[mid] > arr[right])
                left = mid + 1;
            else
                right = mid - 1;
        }
        return arr[left];
    }

    public static void main(String[] args)
    {
        int[] arr = new int[]{2, 4, 5, 6, 7, 9, 11, 0, 1 , 1, 2, 2};
        int[] arr2 = new int[]{-2, 2, 4, 5, 6, 7, 9, 11};
        int res = getMin(arr2);
        System.out.println(res);
    }
}
