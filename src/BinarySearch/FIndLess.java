package BinarySearch;

/**
 * 定义局部最小的概念。arr长度为1时，arr[0]是局部最小。arr的长度为N(N>1)时，如果arr[0]<arr[1]，那么arr[0]是局部最小；如果arr[N-1]<arr[N-2]，那么arr[N-1]是局部最小；如果0<i<N-1，既有arr[i]<arr[i-1]又有arr[i]<arr[i+1]，那么arr[i]是局部最小。 给定无序数组arr，已知arr中任意两个相邻的数都不相等，写一个函数，只需返回arr中任意一个局部最小出现的位置即可。
 */
public class FIndLess
{
    public static int getLess(int[] arr)
    {
        if (arr == null || arr.length == 0)
            return -1;
        if (arr.length == 1)
            return 0;
        return getLessHelper(arr, 0, arr.length - 1);
    }

    private static int getLessHelper(int[] arr, int left, int right)
    {
        if (arr[left] < arr[left + 1])
            return left;
        if (arr[right] < arr[right - 1])
            return right;
        int mid = left + (right - left) / 2;
        if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1])
            return mid;
        if (arr[mid] > arr[mid - 1])
            return getLessHelper(arr, left, mid - 1);
        if (arr[mid] > arr[mid + 1])
            return getLessHelper(arr, mid + 1, right);
        return -1;
    }

    public static void main(String[] args)
    {
        int[] arr = new int[]{3,2,9,2,1,4,0,10,9,0,8,3,5,6,7,1,9,2,4,0,7};
        int res = getLess(arr);
        System.out.println(res);
    }
}
