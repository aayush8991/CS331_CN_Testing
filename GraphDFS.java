import java.util.*;

public class GraphDFS {
    private Map<Integer, List<Integer>> adj = new HashMap<>();

    public void addEdge(int u, int v) {
        adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
    }

    public void dfs(int start, Set<Integer> visited) {
        if (visited.contains(start)) return;
        visited.add(start);
        System.out.print(start + " ");
        for (int neighbor : adj.getOrDefault(start, new ArrayList<>())) {
            dfs(neighbor, visited);
        }
    }

    public static void main(String[] args) {
        GraphDFS g = new GraphDFS();
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);

        System.out.print("DFS traversal: ");
        g.dfs(0, new HashSet<>());
    }
}