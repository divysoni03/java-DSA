import java.util.*;

public class stronglyConnectedComponent {
    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4));
    }

    public static void topSort(ArrayList<Edge>[] graph, int curr, boolean[] vis, Stack<Integer> st) {
        vis[curr] = true;

        for(int i=0;i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) {
                topSort(graph, e.dest, vis, st);
            }
        }
        st.push(curr);
    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] vis) {
        vis[curr] = true;
        System.out.print(curr+", ");

        for(int i=0;i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) {
                dfs(graph, e.dest, vis);
            }
        }        
    }

    public static void kosaraju(ArrayList<Edge>[] graph) {
        int v = graph.length;

        // step 1: topological sort
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[v];

        for(int i=0; i<v; i++) {
            if(!vis[i]) {
                topSort(graph, i, vis, st);
            }
        }

        // step 2: transpose the graph
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] transpose = new ArrayList[v];
        for(int i=0; i<v; i++) {
            vis[i] = false; // resetting it
            transpose[i] = new ArrayList<>();
        }

        for(int i=0; i<v; i++) {
            for(int j=0; j<graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                
                transpose[e.dest].add(new Edge(e.dest, e.src));
            }
        }

        // step 3: dfs travel on the transposed graph
        while(!st.isEmpty()) {
            int curr = st.pop();

            if(!vis[curr]) {
                dfs(transpose, curr, vis);
                System.out.println();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int V = 5;

        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        kosaraju(graph);
    }
}
