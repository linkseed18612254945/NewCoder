package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeToSequenceNoRec
{
    public static List<Integer> preOrder(TreeNode root)
    {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode popNode;
        stack.add(root);
        while (!stack.isEmpty())
        {
            popNode = stack.pop();
            list.add(popNode.val);
            if (popNode.right != null)
                stack.push(popNode.right);
            if (popNode.left != null)
                stack.push(popNode.left);
        }
        return list;
    }

    public static List<Integer> inOrder(TreeNode root)
    {
        if (root == null)
            return null;
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root, popNode;
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
            if (current == null && stack.isEmpty())
                break;
        }
        return list;
    }

    public static List<Integer> postOrder(TreeNode root)
    {
        if (root == null)
            return null;
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        TreeNode popNode;
        stack1.push(root);
        while (!stack1.isEmpty())
        {
            popNode = stack1.pop();
            stack2.push(popNode);
            if (popNode.left != null)
                stack1.push(popNode.left);
            if (popNode.right != null)
                stack1.push(popNode.right);
        }
        while (!stack2.isEmpty())
        {
            list.add(stack2.pop().val);
        }
        return list;
    }


    public static int[][] convert(TreeNode root)
    {
        List<Integer> preList = preOrder(root);
        List<Integer> inList = inOrder(root);
        List<Integer> postList = postOrder(root);
        int n = preList.size();
        int[][] res = new int[3][n];
        for (int i = 0; i < 3; i += 1)
            for (int j = 0; j < n; j += 1)
            {
                if (i == 0)
                    res[i][j] = preList.get(j);
                if (i == 1)
                    res[i][j] = inList.get(j);
                if (i == 2)
                    res[i][j] = postList.get(j);
            }
        return res;
    }
}
