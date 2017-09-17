package LinkList;

import java.util.ArrayList;

/**
 对于一个链表，我们需要用一个特定阈值完成对它的分化，使得小于等于这个值的结点移到前面，大于该值的结点在后面，同时保证两类结点内部的位置关系不变。
 给定一个链表的头结点head，同时给定阈值val，请返回一个链表，使小于等于它的结点在前，大于等于它的在后，保证结点值不重复。
 测试样例：
 {1,4,2,5},3
 {1,2,4,5}
 */
public class LinkListDivide
{
    public static IntListNode arrayDivide(IntListNode head, int val)
    {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int n = 0;
        while (head != null)
        {
            arrayList.add(n, head.val);
            head = head.next;
            n += 1;
        }
        int smallerPosition = 0;
        int biggerPosition = n - 1;
        int index = 0, temp;
        while(index <= biggerPosition)
        {
            if (arrayList.get(index) <= val)
            {
                swap(arrayList, index , smallerPosition);
                smallerPosition += 1;
                index += 1;
            }
            else
            {
                temp = arrayList.get(index);
                arrayList.remove(index);
                arrayList.add(temp);
                biggerPosition -= 1;
            }
        }

        head = new IntListNode(arrayList.get(0), null);
        IntListNode current = head;
        for (int i = 1; i < n; i+= 1)
        {
            current.next = new IntListNode(arrayList.get(i), null);
            current = current.next;
        }
        return head;
    }

    private static void swap(ArrayList<Integer> arrayList, int i, int j)
    {
        int temp = arrayList.get(i);
        arrayList.set(i, arrayList.get(j));
        arrayList.set(j, temp);
    }

    public static IntListNode linkedListDivide(IntListNode head, int val)
    {
        IntListNode smallerSentinel = new IntListNode(0, null);
        IntListNode biggerSentinel = new IntListNode(0, null);
        IntListNode current = head, smallP = smallerSentinel, biggerP = biggerSentinel;
        while (current != null)
        {
            if (current.val <= val)
            {
                smallP.next = current;
                smallP = smallP.next;
            }
            else
            {
                biggerP.next = current;
                biggerP = biggerP.next;
            }
            current = current.next;
        }
        biggerP.next = null;
        smallP.next = biggerSentinel.next;
        return smallerSentinel.next;
    }

    public static void main(String[] args)
    {
        IntListNode head = new IntListNode(360, null);
        head.next = new IntListNode(220, null);
        head.next.next = new IntListNode(2, null);
//        head.next.next.next = new IntListNode(563, null);
//        head.next.next.next.next = new IntListNode(1, null);

//        IntListNode current = head;
//        int n = 8;
//        for (int i = 0; i < n - 1; i+= 1)
//        {
//            current.next = new IntListNode((int) (Math.random() * 5) + 1, null);
//            current = current.next;
//        }
        linkedListDivide(head, 2);
    }
}
