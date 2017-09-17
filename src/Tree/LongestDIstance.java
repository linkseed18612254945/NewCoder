package Tree;

/**
 从二叉树的节点A出发，可以向上或者向下走，但沿途的节点只能经过一次，当到达节点B时，路径上的节点数叫作A到B的距离。对于给定的一棵二叉树，求整棵树上节点间的最大距离。
 给定一个二叉树的头结点root，请返回最大距离。保证点数大于等于2小于等于500.
 */
public class LongestDIstance
{
    private static int findDistance(TreeNode node)
    {
        if (node == null)
            return 0;
        return Math.max(findDistance(node.left), findDistance(node.right)) + 1;
    }

    public static int findLongest(TreeNode root)
    {
        if (root == null)
            return 0;
        int rightLongest = findLongest(root.right), rightDistance = findDistance(root.right);
        int leftLongest = findLongest(root.left), leftDistance = findDistance(root.left);
        return Math.max(Math.max(rightLongest, leftLongest), rightDistance + leftDistance + 1);
    }
}
