package Map;

import java.util.*;

public abstract class AdjacencyListGraph<T> implements Graph<T>
{
    protected Map<T, Set<T>> adjs;
    protected int vNumber;
    protected int eNumber;

    AdjacencyListGraph(T[] v)
    {
        adjs = new HashMap<>();
        vNumber = v.length;
        eNumber = 0;
        for (T x: v)
        {
            adjs.put(x, new HashSet<>());
        }
    }

    public Set<T> dfs(T start)
    {
        if (!adjs.containsKey(start))
            return null;
        Set<T> mark = new HashSet<>();
        dfsHelper(start, mark);
        return mark;
    }

    private void dfsHelper(T v, Set<T> mark)
    {
        mark.add(v);
        for (T connect: adj(v))
        {
            if (mark.contains(connect))
                continue;
            mark.add(connect);
            dfsHelper(connect, mark);
        }
    }

    public Set<T> bfs(T start)
    {
        if (!adjs.containsKey(start))
            return null;
        Queue<T> queue = new LinkedList<>();
        Set<T> mark = new HashSet<>();
        queue.add(start);
        while (!queue.isEmpty())
        {
            T node = queue.poll();
            mark.add(node);
            for (T v: adj(node))
            {
                if (!mark.contains(v))
                    queue.add(v);
            }
        }
        return mark;
    }

    @Override
    public abstract void addEdge(T v1, T v2);

    @Override
    public int vNumber()
    {
        return vNumber;
    }

    @Override
    public int eNumber()
    {
        return eNumber;
    }

    @Override
    public Iterable<T> adj(T v)
    {
        return adjs.get(v);
    }
}
