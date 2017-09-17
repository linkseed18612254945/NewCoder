package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 有一棵二叉树，其中所有节点的值都不一样,找到含有节点最多 的搜索二叉子树,并返回这棵子树的头节点.
 给定二叉树的头结点root，请返回所求的头结点,若出现多个节点最多的子树，返回头结点权值最大的。
 */
public class MaxSubBST
{
    private static void inOrder(TreeNode node, List<Integer> list)
    {
        if (node == null)
            return;
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }

    private static boolean isBST(TreeNode node)
    {
        List<Integer> treeList = new ArrayList<>();
        inOrder(node, treeList);
        if (treeList.size() < 2)
            return true;
        int last = treeList.get(0);
        for (int i = 1; i < treeList.size(); i += 1)
        {
            if (last > treeList.get(i))
                return false;
            last = treeList.get(i);
        }
        return true;
    }

    private static int minInBST(TreeNode node)
    {
        if (node == null)
            return  Integer.MAX_VALUE;
        List<Integer> treeList = new ArrayList<>();
        inOrder(node, treeList);
        return treeList.get(0);
    }

    private static int maxInBST(TreeNode node)
    {
        if (node == null)
            return  Integer.MIN_VALUE;
        List<Integer> treeList = new ArrayList<>();
        inOrder(node, treeList);
        return treeList.get(treeList.size() - 1);
    }

    private static int BSTSize(TreeNode node)
    {
        if (node == null)
            return 0;
        List<Integer> treeList = new ArrayList<>();
        inOrder(node, treeList);
        return treeList.size();
    }

    public static TreeNode getMax(TreeNode node)
    {
        if (node == null)
            return null;
        if (isBST(node.left) && isBST(node.right))
        {
            int leftMin, rightMin;
            leftMin = maxInBST(node.left);
            rightMin = minInBST(node.right);
            if (leftMin < node.val && rightMin > node.val)
                return node;
        }
        return BSTSize(getMax(node.left)) > BSTSize(getMax(node.right)) ? getMax(node.left) : getMax(node.right);
    }
}
