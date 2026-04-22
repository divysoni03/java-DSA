import java.util.*;
import java.util.LinkedList;

public class topologicalSortKahnsAlgo {
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

        // 1

        // 2
        graph[2].add(new Edge(2,3, 1));

        // 3
        graph[3].add(new Edge(3,1, 1));

        // 4
        graph[4].add(new Edge(4,0, 1));
        graph[4].add(new Edge(4,1, 1));

        // 5
        graph[5].add(new Edge(5,0, 1));
        graph[5].add(new Edge(5,2, 1));
        
    }


    public static void calculateInDeg(List<Edge>[] graph, int[] inDeg) {
        for(int i=0;i<graph.length; i++) {
            for(int j=0;j<graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                inDeg[e.dest]++;
            }
        }
    }
    public static void topSort(List<Edge>[] graph) {
        int[] inDeg = new int[graph.length];
        Queue<Integer> q = new LinkedList<>();
        calculateInDeg(graph, inDeg);

        for(int i=0;i<inDeg.length;i++) {
            if(inDeg[i] == 0) q.add(i);
        }

        //bfs
        while(!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + ", ");
            for(int i=0; i<graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                inDeg[e.dest]--;

                if(inDeg[e.dest] == 0) q.add(e.dest);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);

        topSort(graph);
        System.out.println();
    }
}
