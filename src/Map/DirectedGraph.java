package Map;

public class DirectedGraph<T> extends AdjacencyListGraph<T>
{
    public DirectedGraph(T[] v)
    {
        super(v);
    }

    @Override
    public void addEdge(T v1, T v2)
    {
        if (!adjs.containsKey(v1) || !adjs.containsKey(v2))
            throw new IllegalArgumentException();
        adjs.get(v1).add(v2);
        eNumber += 1;
    }
}
