package toOffer;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueToStack<T>
{
    private Queue<T> queue1 = new ArrayDeque<>();
    private Queue<T> queue2 = new ArrayDeque<>();

    public void push(T item)
    {
        Queue<T> targetQueue = queue1.isEmpty() ? queue1 : queue2;
        targetQueue.add(item);
        moveAll(targetQueue);
    }

    public T pop()
    {
        Queue<T> popQueue = queue1.isEmpty() ? queue2 : queue1;
        return popQueue.poll();
    }

    private void moveAll(Queue<T> targetQueue)
    {
        Queue<T> sourceQueue = targetQueue == queue1 ? queue2 : queue1;
        while (!sourceQueue.isEmpty())
        {
            targetQueue.add(sourceQueue.poll());
        }
    }

    public boolean isEmpty()
    {
        return queue1.isEmpty() && queue2.isEmpty();
    }

    public static void main(String[] args)
    {
        QueueToStack<Integer> test = new QueueToStack<>();
        test.push(3);
        test.push(5);
        test.push(9);
        test.push(43);
        while (!test.isEmpty())
        {
            System.out.println(test.pop() + " ");
        }
    }
}
