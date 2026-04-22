import java.util.ArrayList;

public class cycleInDirectedGraph {
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


        // graph 1 - with no cycle
        // // 0
        // graph[0].add(new Edge(0,2, 1));
        // graph[0].add(new Edge(0,1, 1));

        // // 1
        // graph[1].add(new Edge(1,3, 1));

        // // 2
        // graph[2].add(new Edge(2,3, 1));

        // graph 2 - with cycle
        // 0
        graph[0].add(new Edge(0, 2, 1));

        // 1
        graph[1].add(new Edge(1, 0, 1));

        // 2
        graph[2].add(new Edge(2, 3, 1));

        // 3
        graph[3].add(new Edge(3, 0, 1));
    }

    public static boolean isCycle(ArrayList<Edge>[] graph) { // main function to call all components
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for(int i=0;i<graph.length;i++) {
            if(!vis[i]) {
                if(isCycleUtil(graph, i, vis, stack)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis, boolean[] stack) {
        vis[curr] = true;
        stack[curr] = true;

        for(int i=0;i<graph[curr].size();i++) {
            Edge e = graph[curr].get(i);

            // case 1
            if(stack[e.dest] == true) return true; // cycle exists

            // case 2
            if(!vis[e.dest]) {
                if(isCycleUtil(graph, e.dest, vis, stack)) return true;
            }

        }

        stack[curr] = false;
        return false;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int v = 4;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);

        System.out.println(isCycle(graph));
    }
}
