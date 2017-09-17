package CompanyTest;

import java.util.*;

public class Toutiao1
{
    public static void findMax(Point[] points)
    {
        Stack<Point> xStack = new Stack<>();
        Stack<Point> yStack = new Stack<>();
        HashSet<Point> max = new HashSet<>();
        for (int i = 0; i < points.length; i += 1)
        {
            pushPoint(xStack, points[i], 0);
            pushPoint(yStack, points[i], 1);
        }
        while (!xStack.isEmpty() || !yStack.isEmpty())
        {
            max.add(xStack.pop());
        }
        for(Point p: max)
        {
            System.out.println(p.x + " " + p.y);
        }
    }

    private static void pushPoint(Stack<Point> stack, Point p, int n)
    {
        if (stack.isEmpty())
        {
            stack.push(p);
            return;
        }
        if (p.pos[n] < stack.peek().pos[n])
            return;
        while(!stack.isEmpty() && p.pos[n] > stack.peek().pos[n])
        {
            stack.pop();
        }
        stack.push(p);
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i += 1)
        {
            points[i] = new Point(sc.nextInt(), sc.nextInt());
        }
        findMax(points);
    }
}

class Point
{
    int x;
    int y;
    int pos[] = new int[2];
    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
        pos[0] = x;
        pos[1] = y;
    }

    @Override
    public int hashCode()
    {
        return x;
    }
}
