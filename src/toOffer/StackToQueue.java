package toOffer;

import java.util.Stack;

public class StackToQueue<T>
{
    private Stack<T> inner = new Stack<>();
    private Stack<T> outer = new Stack<>();

    public void add(T item)
    {
        inner.push(item);
    }

    public T poll()
    {
        if (outer.isEmpty())
            moveAll();
        return outer.pop();
    }

    private void moveAll()
    {
        while (!inner.isEmpty())
        {
            outer.push(inner.pop());
        }
    }

    public boolean isEmpty()
    {
        return inner.isEmpty() && outer.isEmpty();
    }

    public int size()
    {
        return inner.size() + outer.size();
    }

}
