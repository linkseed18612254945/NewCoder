package LinkList;

public class ListRemove
{
    public IntListNode removeNode(IntListNode pNode, int delVal)
    {
        if (pNode == null)
            return null;
        IntListNode currentNode = pNode;
        if (currentNode.val == delVal)
            return pNode.next;
        while (currentNode.next != null && currentNode.next.val != delVal)
            currentNode = currentNode.next;
        if (currentNode.next != null)
            currentNode.next = currentNode.next.next;
        return pNode;
    }
}
