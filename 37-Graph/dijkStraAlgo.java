import java.util.ArrayList;
import java.util.PriorityQueue;

public class dijkStraAlgo {
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
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));


        // 2
        graph[2].add(new Edge(2,4, 3));

        // 3
        graph[3].add(new Edge(3,5, 1));

        // 4
        graph[4].add(new Edge(4,3, 2));
        graph[4].add(new Edge(4,5, 5));

        // 5
        
    }

    private static class Pair implements Comparable<Pair> {
        int node;
        int dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.dist - p2.dist;
        }
    }
    public static void dijkstra(ArrayList<Edge>[] graph, int src) {
        int[] dist = new int[graph.length];
        for(int i=0;i<dist.length;i++) {
            if(i != src) dist[i] = Integer.MAX_VALUE;
        }
        
        boolean[] vis = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 1));
        while(!pq.isEmpty()) {
            Pair curr = pq.remove();
            if(!vis[curr.node]) {
                vis[curr.node] = true;

                for(int i=0;i<graph[curr.node].size();i++) {
                    Edge e = graph[curr.node].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.weight;

                    if(dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        for(int i: dist) {
            System.out.print(i+", ");
        }
    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge>[] graph = new ArrayList[v];

        createGraph(graph);

        int src = 0;
        dijkstra(graph, src);
        System.out.println();
    }
}
