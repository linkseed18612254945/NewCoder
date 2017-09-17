package Tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 有一棵二叉树,请设计一个算法判断它是否是完全二叉树。
 给定二叉树的根结点root，请返回一个bool值代表它是否为完全二叉树。树的结点个数小于等于500。
 */
public class CheckComplete
{

    public static boolean checkComplete(TreeNode root)
    {
        if (root == null)
            return false;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        boolean endFlag = false;
        while (!queue.isEmpty())
        {
            TreeNode node = queue.poll();
            if (endFlag && (node.left != null || node.right!= null))
                return false;
            if (node.left == null && node.right != null)
                return false;
            if (node.right == null)
                endFlag = true;
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
        return true;
    }
}
