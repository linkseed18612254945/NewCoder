package toOffer;

import java.util.Stack;

public class ReverseLList
{
    public static LLNode reverseLL(LLNode head)
    {
        if (head == null)
            return null;
        LLNode reverse = head, move = head.next, temp;
        while (move != null)
        {
            temp = move.next;
            move.next = reverse;
            reverse = move;
            move = temp;
        }
        return reverse;
    }

    public static void reversePrint(LLNode head)
    {
        if (head == null)
            return;
        Stack<Integer> stack = new Stack<>();
        LLNode move = head;
        while (move != null)
        {
            stack.push(head.key);
            move = move.next;
        }
        while (!stack.isEmpty())
        {
            System.out.println(stack.pop());
        }
    }
}
