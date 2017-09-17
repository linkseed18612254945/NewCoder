package Tree;

public class CheckBalance
{
    private static class Result
    {
        int height;
        boolean balance;
        Result(){}

        Result(int height, boolean balance)
        {
            this.height = height;
            this.balance = balance;
        }
    }

    public static boolean isBalance(TreeNode root)
    {
        return checkChildTree(root).balance;
    }

    private static Result checkChildTree(TreeNode node)
    {
        if (node == null)
            return new Result(0, true);
        Result res = new Result(), leftRes, rightRes;
        leftRes = checkChildTree(node.left);
        rightRes = checkChildTree(node.right);
        res.height = Math.max(leftRes.height, rightRes.height) + 1;
        res.balance = leftRes.balance && rightRes.balance && (Math.abs(leftRes.height - rightRes.height) <= 1);
        return res;
    }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        System.out.println(isBalance(root));
    }
}
