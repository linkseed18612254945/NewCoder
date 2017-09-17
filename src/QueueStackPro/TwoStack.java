package QueueStackPro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * 编写一个类,只能用两个栈结构实现队列,支持队列的基本操作(push，pop)。

 给定一个操作序列ope及它的长度n，其中元素为正数代表push操作，为0代表pop操作，保证操作序列合法且一定含pop操作，请返回pop的结果序列。

 测试样例：
 [1,2,3,0,4,0],6
 返回：[1,2]
 */
public class TwoStack
{
    public static int[] twoStack(int[] ope, int n)
    {
        TwoStackQueue<Integer> tq = new TwoStackQueue<>();
        ArrayList<Integer> popList = new ArrayList<>();
        for (int i = 0; i < n; i += 1)
        {
            if (ope[i] > 0)
                tq.add(ope[i]);
            else
                popList.add(tq.remove());
        }
        return popList.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args)
    {
        int[] ope = new int[]{1, 2, 3, 0, 4, 0};
        int n = 6;
        int[] res = twoStack(ope, n);
        System.out.print(Arrays.toString(res));
    }
}

class TwoStackQueue<T>
{
    private Stack<T> addStack;
    private Stack<T> removeStack;
    private int size;

    public TwoStackQueue()
    {
        addStack = new Stack<>();
        removeStack = new Stack<>();
    }

    public int size()
    {
        return addStack.size() + removeStack.size();
    }

    public void add(T x)
    {
        addStack.push(x);
    }

    public T remove()
    {
        if (removeStack.isEmpty())
            putToRemove();
        return removeStack.pop();
    }

    private void putToRemove()
    {
        while (!addStack.isEmpty())
            removeStack.push(addStack.pop());
    }

    public boolean isEmpty()
    {
        return addStack.isEmpty() && removeStack.isEmpty();
    }
}

