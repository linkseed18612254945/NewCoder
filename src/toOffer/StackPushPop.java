package toOffer;

import java.util.Stack;

public class StackPushPop
{

    public static boolean isLegal(int[] pushL, int[] popL)
    {
        if (pushL == null || popL == null || pushL.length < popL.length)
            return false;
        Stack<Integer> stack = new Stack<>();
        int k  = 0;
        while (pushL[k] != popL[0])
        {
            stack.push(pushL[k]);
            k += 1;
        }
        k -= 1;
        for (int i = 1; i < popL.length; i += 1)
        {
            if (popL[i] == stack.peek())
                stack.pop();
            else
            {
                k += 1;
                stack.push(pushL[k]);
            }
            if (k >= pushL.length)
                return false;
        }
        return true;
    }

    public static void main(String[] args)
    {
        int[] a = new int[]{1, 2, 3, 4, 5};
        int[] b = new int[]{4, 5, 3, 2, 1};
        System.out.println(isLegal(a, b));
    }
}
