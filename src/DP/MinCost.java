package DP;

/**
 * 对于两个字符串A和B，我们需要进行插入、删除和修改操作将A串变为B串，定义c0，c1，c2分别为三种操作的代价，请设计一个高效算法，求出将A串变为B串所需要的最少代价。
 给定两个字符串A和B，及它们的长度和三种操作代价，请返回将A串变为B串所需要的最小代价。保证两串长度均小于等于300，且三种代价值均小于等于100。
 测试样例：
 "abc",3,"adc",3,5,3,100
 返回：8
 */
public class MinCost
{
//    public static int findMinCost(String A, int n, String B, int m, int c0, int c1, int c2)
//    {
//
//    }

    public static void main(String[] args)
    {
        String A = "abc";
        int n = 3;
        String B = "adc";
        int m = 3;
        int c0 = 5, c1 = 3, c2 = 100;
        //int res = findMinCost(A, n, B, m, c0, c1, c2);
        //System.out.println(res);
    }
}
