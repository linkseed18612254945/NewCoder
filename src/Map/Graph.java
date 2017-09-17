package Map;

import java.util.Set;

public interface Graph<T>
{
    int vNumber();
    int eNumber();
    void addEdge(T v1, T v2);
    Iterable<T> adj(T v);
    Set<T> dfs(T v);
    Set<T> bfs(T v);
}
