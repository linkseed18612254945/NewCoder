package CompanyTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Didi2
{
    private static void buildMaxHeap(int[] A)
    {
        for (int i = A.length / 2 - 1; i >= 0; i -= 1)
            heapAdjust(A,i, A.length);
    }

    private static void heapAdjust(int[] A, int k, int length)
    {
        while (k < length / 2 && k >= 0)
        {
            int mc = maxChild(A, length, k);
            if (A[k] > A[mc])
                return;
            else
            {
                exchange(A, k, mc);
                k = mc;
            }
        }
    }

    private static void exchange(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int maxChild(int[] A, int length, int k)
    {
        int left = (k + 1) * 2 - 1;
        int right = (k + 1) * 2;
        if (right >= length)
            return left;
        return (A[left] > A[right])? left: right;
    }

    public static int[] heap(int[] A)
    {
        buildMaxHeap(A);
        for (int i = A.length - 1; i >= 0; i -= 1)
        {
            exchange(A, i ,0);
            heapAdjust(A, 0, i);
        }
        return A;
    }



    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        List<Integer> arrList = new ArrayList<>();
        String[] s = sc.nextLine().split(" ");
        for (int i = 0; i < s.length; i += 1)
            arrList.add(Integer.valueOf(s[i]));
        int k = sc.nextInt();
        int n = arrList.size();
        int[] arr = new int[n];
        for (int i = 0; i < n; i += 1)
            arr[i] = arrList.get(i);
        heap(arr);
        System.out.println(arr[n - k]);
    }
}
