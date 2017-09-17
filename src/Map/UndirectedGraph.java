package Map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UndirectedGraph<T> extends AdjacencyListGraph<T>
{

    UndirectedGraph(T[] v)
    {
        super(v);
    }

    @Override
    public void addEdge(T v1, T v2)
    {
        if (!adjs.containsKey(v1) || !adjs.containsKey(v2))
            throw new IllegalArgumentException();
        adjs.get(v1).add(v2);
        adjs.get(v2).add(v1);
        eNumber += 1;
    }


}
