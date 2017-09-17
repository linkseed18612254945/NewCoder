package CompanyTest;

import java.util.ArrayList;
import java.util.Scanner;

public class Ali1
{
    public static class Box
    {
        int price;
        int length;
        int width;
        int height;
    }

    public static class Model
    {
        int price;
        int length;
        int width;
        int height;
    }

    private static int process()
    {
        return -1;
    }

    public static void main(String args[])
    {
        Box boxTemplate = new Box();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext())
        {
            boxTemplate.length = scanner.nextInt();
            boxTemplate.width = scanner.nextInt();
            boxTemplate.height = scanner.nextInt();

            int itemNum = scanner.nextInt();
            Model[] items = new Model[itemNum];
            for (int i = 0; i < itemNum; i++)
            {
                Model item = new Model();
                item.price = scanner.nextInt();
                item.length = scanner.nextInt();
                item.width = scanner.nextInt();
                item.height = scanner.nextInt();
                items[i] = item;
            }
            long startTime = System.currentTimeMillis();
            int boxMinNum = Integer.MAX_VALUE;
            System.out.println(process());
        }
    }
}
