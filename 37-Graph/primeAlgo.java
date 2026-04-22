import java.util.*;

public class primeAlgo {
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
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        // 1
        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        // 2
        graph[2].add(new Edge(2,0, 15));
        graph[2].add(new Edge(2,3, 50));

        // 3
        graph[3].add(new Edge(3,1, 40));
        graph[3].add(new Edge(3,2, 50));
    }

    static class Pair implements Comparable<Pair>{
        int src;
        int dest;
        int cost;

        Pair(int src, int dest, int cost) {
            this.src = src;
            this.dest = dest;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost; // ascending order
        }
    }

    public static void prims(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0,0));

        int finalCost = 0; // total min weight
        ArrayList<Pair> finalEdges = new ArrayList<>();

        while(!pq.isEmpty()) {
            Pair curr = pq.remove();
            


            if(!vis[curr.dest]) {
                finalEdges.add(curr);
                vis[curr.dest] = true;
                finalCost += curr.cost;

                for(int i=0;i<graph[curr.src].size(); i++) {
                    Edge e = graph[curr.src].get(i);
                    
                    pq.add(new Pair(e.src, e.dest, e.weight));
                }
            }
        }

        System.out.println("min cost : " + finalCost + "\n\nEdges:");
        for(Pair e: finalEdges) {
            System.out.println(e.src + "->" + e.dest + " (cost: " + e.cost + ")");
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int v = 4;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);

        prims(graph);
    }
}
