package LinkList;

/**
 有一个整数val，如何在节点值有序的环形链表中插入一个节点值为val的节点，并且保证这个环形单链表依然有序。
 给定链表的信息，及元素的值A及对应的nxt指向的元素编号同时给定val，请构造出这个环形链表，并插入该值。
 测试样例：
 [1,3,4,5,7],[1,2,3,4,0],2
 返回：{1,2,3,4,5,7}
 */

public class SortLLInsert
{

    public static void printList(IntListNode node)
    {
        IntListNode current = node;
        while (current.next != node)
        {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static IntListNode insert(int[] A, int[] nxt, int val)
    {
        IntListNode head = new IntListNode(A[0], null);
        IntListNode currentNode = head;
        for (int i = 0; i < nxt.length; i += 1)
        {
            currentNode.next = new IntListNode(A[nxt[i]], null);
            currentNode = currentNode.next;
        }
        currentNode.next = head;
        printList(head);

        currentNode = head;
        IntListNode nextNode = head.next;
        while (nextNode != head)
        {
            if (val >= currentNode.val && val <= nextNode.val)
            {
                currentNode.next = new IntListNode(val, nextNode);
                return head;
            }
            currentNode = nextNode;
            nextNode = nextNode.next;
        }
        currentNode.next = new IntListNode(val, nextNode);
        if (val >= currentNode.val)
            return head;
        else if (val <= nextNode.val)
            return currentNode.next;
        return null;
    }

    public static void main(String[] args)
    {
        int val = 2;
        int[] A = new int[]{1, 3, 4, 5, 7};
        int[] nxt = new int[]{1, 2, 3, 4, 0};
        IntListNode res = insert(A, nxt, val);
        printList(res);
    }

}

