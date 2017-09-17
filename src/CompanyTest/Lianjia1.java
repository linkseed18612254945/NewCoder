package CompanyTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Lianjia1
{
    public static int minMagic(ClassRemainScore[] remainScores, int remainTotal)
    {
        Arrays.sort(remainScores, Comparator.comparing(ClassRemainScore :: getCost));
        int totalCost = 0;
        for (int i = 0; i < remainScores.length; i += 1)
        {
            if (remainScores[i].getRemainScore() < remainTotal)
            {
                totalCost += remainScores[i].getCost() * remainScores[i].getRemainScore();
                remainTotal -= remainScores[i].getRemainScore();
            }
            else
            {
                totalCost += remainScores[i].getCost() * remainTotal;
                break;
            }

        }
        return totalCost;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        int avg = sc.nextInt();
        int requirTotal = avg * n;
        int ai, bi, total = 0;
        ClassRemainScore[] remainScores = new ClassRemainScore[n];
        for (int i = 0;i < n;i += 1)
        {
            ai = sc.nextInt();
            bi = sc.nextInt();
            total += ai;
            remainScores[i] = new ClassRemainScore(r - ai, bi);
        }
        int remainTotal = requirTotal - total;
        int res = minMagic(remainScores, remainTotal);
        System.out.print(res);
    }
}

class ClassRemainScore
{
    private int remainScore;
    private int cost;

    public ClassRemainScore(int remainScore, int cost)
    {
        this.remainScore = remainScore;
        this.cost = cost;
    }

    public int getCost()
    {
        return cost;
    }

    public int getRemainScore()
    {
        return remainScore;
    }
}
