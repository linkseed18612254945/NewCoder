package Map;

public class GraphTest
{
    public static void main(String[] args)
    {
        boolean[] x = new boolean[10];
        System.out.println(x[1]);
        UndirectedGraph<String> testG = new UndirectedGraph<>(new String[]{"lk", "mo", "cn", "jk", "ui", "bob", "he"});
        testG.addEdge("lk", "mo");
        testG.addEdge("cn", "jk");
        testG.addEdge("lk", "cn");
        testG.addEdge("he", "lk");
        testG.addEdge("ui", "cn");
        testG.addEdge("he", "mo");
        System.out.println(testG.dfs("lk"));
        System.out.println(testG.bfs("lk"));
    }
}
