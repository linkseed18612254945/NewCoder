package ArrangeAndCombine;

public class ArrangeAndCombine
{
    public static int combineNumber(int low, int up)
    {
        low = Math.min(low, up - low);
        int totalUp = 1;
        int totalLow = 1;
        int n = low;
        for (int i = 0; i < n; i += 1)
        {
            totalLow *= low;
            low -= 1;
            totalUp *= up;
            up -= 1;
        }
        return totalUp / totalLow;
    }

    public static int arrangeNumber(int low, int up)
    {
        int total = 1;
        for (int i = low;i <= up; i += 1)
            total *= i;
        return total;
    }

    /**
     * 在XxY的方格中，以左上角格子为起点，右下角格子为终点，每次只能向下走或者向右走，请问一共有多少种不同的走法
     给定两个正整数int x,int y，请返回走法数目。保证x＋y小于等于12。
     */
    public static int countWays(int x, int y)
    {
        return combineNumber(x - 1, x + y - 2);
    }

    /**
     * n个人站队，他们的编号依次从1到n，要求编号为a的人必须在编号为b的人的左边，但不要求一定相邻，请问共有多少种排法？第二问如果要求a必须在b的左边，并且一定要相邻，请问一共有多少种排法？
     给定人数n及两个人的编号a和b，请返回一个两个元素的数组，其中两个元素依次为两个问题的答案。保证人数小于等于10。
     */
    public static int[] standInLine(int n)
    {
        int[] res = new int[2];
        res[0] = arrangeNumber(1, n) / 2;
        res[1] = arrangeNumber(1, n - 1);
        return res;
    }

    /**
     *A(A也是他的编号)是一个孤傲的人，在一个n个人(其中编号依次为1到n)的队列中，他于其中的标号为b和标号c的人都有矛盾，所以他不会和他们站在相邻的位置。现在问你满足A的要求的对列有多少种？
     给定人数n和三个人的标号A,b和c，请返回所求答案，保证人数小于等于11且大于等于3。
     */
    public static int lonelyA(int n)
    {
        return arrangeNumber(1, n) - 4 * arrangeNumber(1, n - 1) + 2 * arrangeNumber(1, n - 2);
    }

    /**
     *n颗相同的糖果，分给m个人，每人至少一颗，问有多少种分法。
     给定n和m，请返回方案数，保证n小于等于12，且m小于等于n。
     */
    public static int distribution(int n, int m)
    {
        return combineNumber(m - 1, n - 1);
    }
}
