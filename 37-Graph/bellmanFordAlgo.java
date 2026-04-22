import java.util.ArrayList;

public class bellmanFordAlgo {
    static class Edge {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for(int i=0;i<graph.length;i++) {
            graph[i] = new ArrayList<>();
        }

        // 0
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        // 1
        graph[1].add(new Edge(1, 2, -4));

        // 2
        graph[2].add(new Edge(2,3, 2));

        // 3
        graph[3].add(new Edge(3,4, 4));

        // 4
        graph[4].add(new Edge(4,1, -1));
    }

    public static void createGraph2(ArrayList<Edge> graph) {
        // 0
        graph.add(new Edge(0, 1, 2));
        graph.add(new Edge(0, 2, 4));

        // 1
        graph.add(new Edge(1, 2, -4));

        // 2
        graph.add(new Edge(2,3, 2));

        // 3
        graph.add(new Edge(3,4, 4));

        // 4
        graph.add(new Edge(4,1, -1));
    }
    public static void bellmanFord(ArrayList<Edge>[] graph, int src) {
        int V = graph.length;

        int dist[] = new int[V];
        for(int i=0;i<dist.length; i++) {
            if(i != src) dist[i] = Integer.MAX_VALUE;
        }

        //algo O(V*E)
        for(int i=0;i<V-1;i++) {
            // edges O(E)
            for(int j=0; j<graph.length; j++) {
                for(int k=0; k<graph[j].size(); k++) {
                    Edge e = graph[j].get(k);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.weight;

                    if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }

        // print distances
        for(int i: dist) {
            System.out.print(i+", ");
        }
        System.out.println();
    }
    public static void bellmanFord2(ArrayList<Edge> graph, int src, int V) {
        int dist[] = new int[V];
        for(int i=0;i<dist.length; i++) {
            if(i != src) dist[i] = Integer.MAX_VALUE;
        }

        //algo O(V*E) same TC
        for(int i=0;i<V-1;i++) {
            // edges O(E)
            for(int j=0; j<graph.size(); j++) {
                Edge e = graph.get(j);
                int u = e.src;
                int v = e.dest;
                int wt = e.weight;

                if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        // print distances
        for(int i: dist) {
            System.out.print(i+", ");
        }
        System.out.println();
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];
        // ArrayList<Edge> graph = new ArrayList<>();

        createGraph(graph);
        // createGraph2(graph);

        bellmanFord(graph, 0);
        // bellmanFord2(graph, 0, v);
    }
}
