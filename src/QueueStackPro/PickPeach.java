package QueueStackPro;

import java.util.*;
public class PickPeach
{
    static int pick(int[] peaches)
    {
        Deque<Integer> subList = new ArrayDeque<>();
        for (int i = 0; i < peaches.length; i += 1)
        {
            if (subList.isEmpty() || subList.peekLast() <= peaches[i])
                subList.addLast(peaches[i]);
            else
            {
                while (!subList.isEmpty() && subList.peekLast() > peaches[i])
                    subList.pollLast();
                subList.addLast(peaches[i]);
            }
        }
        return subList.size();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int trees = sc.nextInt();
        int[] peaches = new int[trees];
        for (int i = 0; i < peaches.length; i++) {
            peaches[i] = sc.nextInt();
        }
        System.out.println(pick(peaches));
    }
}