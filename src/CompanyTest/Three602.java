package CompanyTest;

import java.util.Scanner;
import java.util.Stack;

public class Three602
{

    public static int[] process(int[] arr)
    {
        int[] res = new int[arr.length];
        for (int i = 1; i < arr.length;i += 1)
        {
            for (int j = i; j >= 0; j -= 1)
            {
                if (arr[i] < arr[j])
                    res[i] += 1;
            }
        }
        return res;
    }

    public static int[] precess(int[] arr)
    {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stackTemp = new Stack<>();
        int[] res = new int[arr.length];
        int count;
        for (int i = 0; i < arr.length;i += 1)
        {
            count = 0;
            while (!stack.isEmpty() && stack.peek() < arr[i])
                stackTemp.push(stack.pop());
            stack.push(arr[i]);
            while (!stackTemp.isEmpty())
            {
                stack.push(stackTemp.pop());
                count += 1;
            }
            res[i] = i - count;
        }
        return res;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i += 1)
        {
            arr[i] = sc.nextInt();
        }
        int[] res = process(arr);
        for (int i = 0;i < n; i += 1)
        {
            if (i != n - 1)
                System.out.print(res[i] + " ");
            else
                System.out.println(res[i]);
        }
    }
}
