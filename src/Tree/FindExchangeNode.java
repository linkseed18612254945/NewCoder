package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 一棵二叉树原本是搜索二叉树，但是其中有两个节点调换了位置，使得这棵二叉树不再是搜索二叉树，请找到这两个错误节点并返回他们的值。保证二叉树中结点的值各不相同。
 给定一棵树的根结点，请返回两个调换了位置的值，其中小的值在前。
 */
public class FindExchangeNode
{

    private static List<Integer> inOrder(TreeNode root)
    {
        if (root == null)
            return null;
        List<Integer> list = new ArrayList<>();
        TreeNode current = root, popNode;
        Stack<TreeNode> stack = new Stack<>();
        while (true)
        {
            if (current != null)
            {
                stack.push(current);
                current = current.left;
            }
            else
            {
                popNode = stack.pop();
                list.add(popNode.val);
                current = popNode.right;
            }
            if (stack.isEmpty() && current == null)
                break;
        }
        return list;
    }

    public static int[] find(TreeNode root)
    {
        List<Integer> treeList = inOrder(root);
        if (treeList == null || treeList.size() < 2)
            return null;
        int[] res = new int[2];
        int index = 1, temp = 0;
        int last = treeList.get(0);
        for (int i = 1;i < treeList.size(); i += 1)
        {
            if (treeList.get(i) < last)
            {
                if (index == 1)
                {
                    res[index] = last;
                    temp = treeList.get(i);
                    index -= 1;
                }
                else
                {
                    res[index] = treeList.get(i);
                    return res;
                }
            }
            last = treeList.get(i);
        }
        if (index == 1)
            return null;
        else
        {
            res[0] = temp;
            return res;
        }
    }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(3);
        int[] res = find(root);
        System.out.println(Arrays.toString(res));
    }
}
