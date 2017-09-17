package LinkList;

import java.util.Stack;

public class Palindrome
{
    public static boolean isPalindrome(IntListNode head)
    {
        Stack<Integer> tempStack = new Stack<>();
        IntListNode current = head;
        while (current != null)
        {
            tempStack.push(current.val);
            current = current.next;
        }
        while (head != null)
        {
            if (tempStack.pop() != head.val)
                return false;
            head = head.next;
        }
        return true;
    }

    public static boolean isPalindromeWithHalfStack(IntListNode head)
    {
        Stack<Integer> tempStack = new Stack<>();
        IntListNode quick = head, slow = head;
        while (quick != null)
        {
            if (quick.next != null)
            {
                tempStack.push(slow.val);
                quick = quick.next.next;
                slow = slow.next;
            }
            else
            {
                slow = slow.next;
                break;
            }
        }
        while (slow != null)
        {
            if (slow.val != tempStack.pop())
                return false;
            slow = slow.next;
        }
        return true;

    }

    public static IntListNode reverse(IntListNode head)
    {
        IntListNode reverseHead, temp;
        reverseHead = head;
        head = head.next;
        reverseHead.next = null;
        while (head != null)
        {
            temp = head.next;
            head.next = reverseHead;
            reverseHead = head;
            head = temp;
        }
        return reverseHead;
    }

    public static void main(String[] args)
    {
        IntListNode head1 = IntListNode.arrayToIntList(new int[]{1, 2, 3, 2, 1});
        IntListNode head2 = IntListNode.arrayToIntList(new int[]{2,3,7,3,8,6,2,1,6,7,8,8,6,6,1,3,5,5,4,4,2,8,2,9,8,6,6,8,1,6,5,8,8,2,2,9,4,6,1,5,1,1,2,9,2,5,1,6,1,8,9,6,2,1,1,9,7,5,3,9,3,4,4,6,5,8,4,1,9,9,5,8,0,9,9,5,4,8,8,6,4,4,4,6,9,8,6,4,4,4,2});
        System.out.println(isPalindromeWithHalfStack(head2));
    }
}
