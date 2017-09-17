package toOffer;

public class findMinInRotate
{

    public static int findMin(int[] arr)
    {
        if (arr == null || arr.length == 0)
        {
            throw new IllegalArgumentException();
        }
       return find(arr, 0, arr.length - 1);
    }

    public static int find(int[] arr, int start, int end)
    {
        if (start == end)
            return arr[start];
        if (arr[start] <= arr[end])
            return arr[start];
        int mid = start + (end - start) / 2;
        if (arr[mid] >= arr[end])
            return find(arr, mid + 1, end);
        else if (arr[mid] < arr[mid - 1])
            return arr[mid];
        else
            return find(arr, start, mid - 1);
    }

    public static void main(String[] args)
    {
        int[] arr = new int[]{2, 4, 5, 6, 7, 9, 11, 0, 1 , 1, 2, 2};
        System.out.println(findMin(arr));
    }
}
