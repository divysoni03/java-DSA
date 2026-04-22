import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class checkIfBiPartite {
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
        graph[0].add(new Edge(0,1, 1));
        graph[0].add(new Edge(0,2, 1));

        // 1
        graph[1].add(new Edge(1,0, 1));
        graph[1].add(new Edge(1,3, 1));

        // 2
        graph[2].add(new Edge(2,0, 1));
        graph[2].add(new Edge(2,4, 1));

        // 3
        graph[3].add(new Edge(3,1, 1));
        // graph[3].add(new Edge(3,4, 1));

        // 4
        graph[4].add(new Edge(4,2, 1));
        // graph[4].add(new Edge(4,3, 1));
    }

    public static boolean isBipartite(ArrayList<Edge>[] graph) {
        int color[] = new int[graph.length];
        for(int i=0;i<color.length;i++) color[i] = -1;

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<graph.length;i++) {
            if(color[i] == -1) { // bfs
                q.add(i);
                color[i] = 0; // yellow

                while(!q.isEmpty()) {
                    int curr = q.remove();
                    for(int j=0;j<graph[curr].size();j++) {
                        Edge e = graph[curr].get(j);
                        if(color[e.dest] == -1) { // case 1
                            int nextColor = color[curr] == 0 ? 1:0;
                            color[e.dest] = nextColor;
                            q.add(e.dest);
                        } else if(color[e.dest] == color[curr]) { // case 2
                            return false;
                        }
                        // case 3 - do nothing
                    }
                }
            }

        }

        return true;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);

        System.out.println(isBipartite(graph));
    }
}
