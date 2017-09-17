package QueueStackPro;

import java.util.Arrays;
import java.util.Stack;

public class StackReverse
{
    public static int[] reverseStack(int[] A, int n)
    {
        Stack<Integer> stackA = new Stack<>();
        for (int a: A)
            stackA.push(a);
        reverse(stackA);
        int[] reverseArr = new int[n];
        for (int i = n - 1; i >= 0; i -= 1)
            reverseArr[i] = stackA.pop();
        return reverseArr;
    }

    private static void reverse(Stack<Integer> stack)
    {
        if (stack.isEmpty())
            return;
        int top = popBottom(stack);
        reverse(stack);
        stack.push(top);
    }

    private static int popBottom(Stack<Integer> stack)
    {
        if (stack.size() == 1)
            return stack.pop();
        int top = stack.pop();
        int bottom = popBottom(stack);
        stack.push(top);
        return bottom;
    }

    public static void main(String[] args)
    {
        int n = 4;
        int[] A = new int[]{4, 3, 2, 1};
        int[] reverseA = reverseStack(A, n);
        System.out.print(Arrays.toString(reverseA));
    }
}
